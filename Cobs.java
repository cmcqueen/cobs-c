
public class Cobs {


    public static int encodeDstBufMaxLen(int srcLen){
        return ((srcLen) + (((srcLen) + 253)/254));
    }

    public static int decodeDstBufMaxLen(int srcLen){
        return (((srcLen) == 0) ? 0 : ((srcLen) - 1));
    }


    public static enum EncodeStatus {
        OK,
        NULL_POINTER,
        OUT_BUFFER_OVERFLOW;
    }

    public static class EncodeResult {
        int outLen;
        EncodeStatus status;
    }

    public static enum DecodeStatus {
        OK,
        NULL_POINTER,
        OUT_BUFFER_OVERFLOW, 
        ZERO_BYTE_IN_INPUT,
        INPUT_TOO_SHORT;
    }

    public static class DecodeResult {
        int outLen;
        DecodeStatus status;
    }

    public static EncodeResult encode(char[] dst_buf_ptr, int dst_buf_len, char[] src_ptr, int src_len){
        EncodeResult result = new EncodeResult();
        result.outLen = 0;
        result.status = EncodeStatus.OK;

        int dst_write_counter = 1;
        int dst_code_write_counter = 0;
        int dst_buf_end_counter = dst_buf_len;

        int src_ptr_counter = 0;
        int src_end_counter = src_len;

        int search_len = 1;

        if(dst_buf_ptr == null || src_ptr == null){
            result.status = EncodeStatus.NULL_POINTER;
            return result;
        }


        if (src_len != 0)
        {
            /* Iterate over the source bytes */
            for (;;)
            {
                /* Check for running out of output buffer space */
                if (dst_write_counter >= dst_buf_end_counter)
                {
                    result.status = EncodeStatus.OUT_BUFFER_OVERFLOW;
                    break;
                }

                int src_byte = (int) src_ptr[src_ptr_counter++];
                
                if (src_byte == 0)
                {
                    /* We found a zero byte */
                    dst_buf_ptr[dst_code_write_counter] = (char) (search_len & 0xFF);
                    dst_code_write_counter = dst_write_counter++;
                    search_len = 1;
                    if (src_ptr_counter >= src_end_counter)
                    {
                        break;
                    }
                }
                else
                {
                    /* Copy the non-zero byte to the destination buffer */
                    dst_buf_ptr[dst_write_counter++] = (char) (src_byte & 0xFF);
                    
                    search_len++;
                    if (src_ptr_counter >= src_end_counter)
                    {
                        break;
                    }
                    if (search_len == 0xFF)
                    {
                        /* We have a long string of non-zero bytes, so we need
                        * to write out a length code of 0xFF. */
                        dst_buf_ptr[dst_code_write_counter] = (char) (search_len & 0xFF);

                        dst_code_write_counter = dst_write_counter++;
                        search_len = 1;
                    }
                }
            }
        }
        
        /* We've reached the end of the source data (or possibly run out of output buffer)
        * Finalise the remaining output. In particular, write the code (length) byte.
        * Update the pointer to calculate the final output length.
        */
        if (dst_code_write_counter >= dst_buf_end_counter)
        {
            /* We've run out of output buffer to write the code byte. */
            result.status = EncodeStatus.OUT_BUFFER_OVERFLOW;
            dst_write_counter = dst_buf_end_counter;
        }
        else
        {
            /* Write the last code (length) byte. */
            dst_buf_ptr[dst_code_write_counter] = (char) (search_len & 0xFF);
        }

        /* Calculate the output length, from the value of dst_code_write_ptr */
        result.outLen = dst_write_counter;

        return result;
    }



    public static DecodeResult decode(char[] dst_buf_ptr, int dst_buf_len, char[] src_ptr, int src_len){
        DecodeResult result = new DecodeResult();
        result.outLen = 0;
        result.status = DecodeStatus.OK;

        int src_ptr_counter = 0;
        int src_end_counter = src_len;
        int dst_buf_end_counter = dst_buf_len;
        int dst_write_counter = 0;
        int remaining_bytes;
        int src_byte;
        int i;
        int len_code;


        
        /* First, do a NULL pointer check and return immediately if it fails. */
        if ((dst_buf_ptr == null) || (src_ptr == null))
        {
            result.status = DecodeStatus.NULL_POINTER;
            return result;
        }

        if (src_len != 0)
        {
            for (;;)
            {
                len_code = (int) src_ptr[src_ptr_counter++];
                if (len_code == 0)
                {
                    result.status = DecodeStatus.ZERO_BYTE_IN_INPUT;
                    break;
                }
                len_code--;

                /* Check length code against remaining input bytes */
                remaining_bytes = src_end_counter - src_ptr_counter;
                if (len_code > remaining_bytes)
                {
                    result.status = DecodeStatus.INPUT_TOO_SHORT;
                    len_code = remaining_bytes;
                }

                /* Check length code against remaining output buffer space */
                remaining_bytes = dst_buf_end_counter - dst_write_counter;
                if (len_code > remaining_bytes)
                {
                    result.status = DecodeStatus.OUT_BUFFER_OVERFLOW;
                    len_code = remaining_bytes;
                }

                for (i = len_code; i != 0; i--)
                {
                    src_byte = (char) (src_ptr[src_ptr_counter++] & 0xFF);
                    if (src_byte == 0)
                    {
                        result.status = DecodeStatus.ZERO_BYTE_IN_INPUT;
                    }

                    dst_buf_ptr[dst_write_counter++] = (char) src_byte;
                }

                if (src_ptr_counter >= src_end_counter)
                {
                    break;
                }

                /* Add a zero to the end */
                if (len_code != 0xFE)
                {
                    if (dst_write_counter >= dst_buf_end_counter)
                    {
                        result.status = DecodeStatus.OUT_BUFFER_OVERFLOW;
                        break;
                    }
                    dst_buf_ptr[dst_write_counter++] = 0;
                }
            }
        }

        result.outLen = dst_write_counter;

        return result;
    }



}