/*
 * cobs.h
 *
 * Consistent Overhead Byte Stuffing
 */

#ifndef COBS_H_
#define COBS_H_


#include <stdint.h>
#include <stdlib.h>


#ifndef FALSE
#define FALSE       (0)
#endif

#ifndef TRUE
#define TRUE        (!FALSE)
#endif

#ifndef dimof
#define dimof(X)    (sizeof(X)/sizeof((X)[0]))
#endif


#define COBS_ENCODE_DST_BUF_LEN_MAX(SRC_LEN)            ((SRC_LEN) + ((SRC_LEN)/254u) + 1)
#define COBS_DECODE_DST_BUF_LEN_MAX(SRC_LEN)            (((SRC_LEN) == 0) ? 0 : ((SRC_LEN) - 1))


typedef enum
{
    COBS_ENCODE_OK                  = 0x00,
    COBS_ENCODE_OUT_BUFFER_OVERFLOW = 0x01
} cobs_encode_status;

typedef struct
{
    size_t              out_len;
    cobs_encode_status  status;
} cobs_encode_result;


cobs_encode_result cobs_encode(uint8_t *dst_buf_ptr, size_t dst_buf_len, const uint8_t * src_ptr, size_t src_len);



#endif /* COBS_H_ */
