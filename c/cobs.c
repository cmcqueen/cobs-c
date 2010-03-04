/*
 * cobs.c
 *
 * Consistent Overhead Byte Stuffing
 */

#include <stdlib.h>
#include "cobs.h"


cobs_encode_result cobs_encode(uint8_t *dst_buf_ptr, size_t dst_buf_len, const uint8_t * src_ptr, size_t src_len)
{
    const uint8_t *     src_end_ptr         = src_ptr + src_len;
    uint8_t *           dst_buf_end_ptr     = dst_buf_ptr + dst_buf_len;
    uint8_t *           dst_code_write_ptr  = dst_buf_ptr;
    uint8_t *           dst_write_ptr       = dst_code_write_ptr + 1;
    uint8_t             src_byte            = 0;
    uint8_t             search_len          = 1;
    cobs_encode_result  result              = { 0, COBS_ENCODE_OK };
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

