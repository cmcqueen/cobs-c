/*
 * cobs.c
 *
 * Consistent Overhead Byte Stuffing
 */

#include <stdlib.h>
#include <string.h>         /* for memcpy() */
#include "cobs.h"


cobs_encode_result cobs_encode(uint8_t *dst_buf_ptr, size_t dst_buf_len, const uint8_t * src_ptr, size_t src_len)
{
    cobs_encode_result  result              = { 0, COBS_ENCODE_OK };
    const uint8_t *     src_end_ptr         = src_ptr + src_len;
    uint8_t *           dst_buf_end_ptr     = dst_buf_ptr + dst_buf_len;
    uint8_t *           dst_code_write_ptr  = dst_buf_ptr;
    uint8_t *           dst_write_ptr       = dst_code_write_ptr + 1;
    uint8_t             src_byte            = 0;
    uint8_t             search_len          = 1;
    uint8_t             final_zero          = TRUE;


    /* Check for having zero output buffer space at the start--
     * a special case that needs to be checked and handled specially.
     */
    if (dst_buf_len == 0)
    {
        result.out_len = 0;
        result.status = COBS_ENCODE_OUT_BUFFER_OVERFLOW;
    }
    else
    {
        /* Iterate over the source bytes */
        while (src_ptr < src_end_ptr)
        {
            /* Check for running out of output buffer space */
            if (dst_write_ptr >= dst_buf_end_ptr)
            {
                result.status = COBS_ENCODE_OUT_BUFFER_OVERFLOW;
                break;
            }

            src_byte = *src_ptr++;
            if (src_byte == 0)
            {
                /* We found a zero byte */
                *dst_code_write_ptr = search_len;
                dst_code_write_ptr = dst_write_ptr++;
                search_len = 1;
                final_zero = TRUE;
            }
            else
            {
                /* Copy the non-zero byte to the destination buffer */
                *dst_write_ptr++ = src_byte;
                search_len++;
                if (search_len == 0xFF)
                {
                    /* We have a long string of non-zero bytes */
                    *dst_code_write_ptr = search_len;
                    dst_code_write_ptr = dst_write_ptr++;
                    search_len = 1;
                    final_zero = FALSE;
                }
            }
        }

        /* We've reached the end of the source data (or possibly run out of output buffer)
         * Finalise the remaining output. In particular, write the code (length) byte.
         * Update the pointer to calculate the final output length.
         */
        if ((search_len > 1) || (final_zero != FALSE))
        {
            *dst_code_write_ptr = search_len;
            dst_code_write_ptr = dst_write_ptr;
        }

        /* Calculate the output length, from the value of dst_code_write_ptr */
        result.out_len = dst_code_write_ptr - dst_buf_ptr;
    }

    return result;
}


cobs_decode_result cobs_decode(uint8_t *dst_buf_ptr, size_t dst_buf_len, const uint8_t * src_ptr, size_t src_len)
{
    cobs_decode_result  result              = { 0, COBS_DECODE_OK };
    const uint8_t *     src_end_ptr         = src_ptr + src_len;
    uint8_t *           dst_buf_end_ptr     = dst_buf_ptr + dst_buf_len;
    uint8_t *           dst_write_ptr       = dst_buf_ptr;
    size_t              remaining_bytes;
    uint8_t             len_code;

    if (src_len != 0)
    {
        for (;;)
        {
            len_code = *src_ptr++;
            if (len_code == 0)
            {
                result.status |= COBS_DECODE_ZERO_BYTE_IN_INPUT;
                break;
            }
            len_code--;

            remaining_bytes = src_end_ptr - src_ptr;
            if (len_code > remaining_bytes)
            {
                result.status |= COBS_DECODE_INPUT_TOO_SHORT;
                len_code = remaining_bytes;
            }

            remaining_bytes = dst_buf_end_ptr - dst_write_ptr;
            if (len_code > remaining_bytes)
            {
                result.status |= COBS_DECODE_OUT_BUFFER_OVERFLOW;
                len_code = remaining_bytes;
            }

            memcpy(dst_write_ptr, src_ptr, len_code);
            dst_write_ptr += len_code;
            src_ptr += len_code;

            if (src_ptr >= src_end_ptr)
            {
                break;
            }

            /* Add a zero to the end */
            if (len_code != 0xFE)
            {
                if (dst_write_ptr >= dst_buf_end_ptr)
                {
                    result.status |= COBS_DECODE_OUT_BUFFER_OVERFLOW;
                    break;
                }
            }
        }
    }

    return result;
}
