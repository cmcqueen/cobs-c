public class Tests{

    static int[] random_data = new int[] {0x00AE, 0x499A, 0x0000, 0x2061, 0x0005, 0x0320, 0x03E0, 0x1710, 0xA224, 0x0185, 0x0499, 0x0000, 0x1901, 0x0000, 0x0000, 0xB533, 0x4210, 0xFFC2, 0x0202, 0x0202, 0xF202, 0xF1F2, 0xD1E1, 0xAFC0, 0xFF00, 0xF002, 0xF103, 0xE103, 0xE1F5, 0xD1E4, 0xC1D5, 0x91C2, 0x8895, 0x30D9, 0xEDCB, 0x110F, 0x3322, 0x2233, 0x0011, 0xCCEE, 0xFFED, 0x1100, 0x2222, 0x3333, 0x2233, 0x0022, 0xDEF0, 0x9ACC, 0x15CC, 0x2FA4, 0x2555, 0x9C78, 0x7666, 0x01C8, 0x3B38, 0x3534, 0x2452, 0x0463, 0x13BB, 0x0623, 0xEC00, 0x9797, 0x9797, 0x2AFB, 0x00AE, 0xFBE0, 0x1B70, 0xF3BE, 0x000E, 0xF86E, 0x1B7E, 0xF3CE, 0xFFCE, 0xF41E, 0x102E, 0xEC0E, 0xFFDE, 0xEC3E, 0x139E, 0xEF9E, 0xFB9E, 0xF77E, 0x13E0, 0xE7EE, 0xF7AE, 0xF750, 0x0C30, 0xEBEE, 0xF730, 0xF010, 0x0B50, 0xE430, 0xF420, 0xF370, 0x07C0, 0xE450, 0x0470, 0xFBCE, 0xFF5C, 0x0F90, 0x07D0, 0xFC3E, 0xFF6C, 0x0F90, 0x03A0, 0xFC0E, 0xF40C, 0x0BF0, 0x03A0, 0xF41E, 0xF78C, 0x0B70, 0xFF72, 0xFF6E, 0xF7DE, 0x07C0, 0xFFA2, 0x0330, 0xF42E, 0x0BC0, 0xFF22, 0xFC00, 0xF75E, 0x0410, 0x0022, 0x0350, 0xF3A0, 0x0832, 0x04DE, 0xFBF0, 0x1BCE, 0xF00E, 0xFC5E, 0xFC80, 0x1BF0, 0xF02E, 0x0002, 0xF81E, 0x142E, 0xEC9E, 0x07DE, 0xF09E, 0x17CE, 0xF3AE, 0xFFC0, 0xFBB0, 0x1080, 0xEBFE, 0xFFE0, 0xFF90, 0x1460, 0xE4AE, 0xFBC0, 0xF840, 0x0FE0, 0xE860, 0xF8C0, 0xF400, 0x0842, 0xE4B0, 0x0890, 0x03BE, 0xFF9C, 0x0FD0, 0x0020, 0x0450, 0xFFCC, 0x0FE0, 0x07D0, 0x03FE, 0xFBEE, 0x0C60, 0x0B80, 0xF86E, 0xFB8E, 0x1370, 0x0782, 0x038E, 0xF85E, 0x0FC2, 0x07C2, 0x037E, 0xF84E, 0x0880, 0x0392, 0x0420, 0xF7CE, 0x0C42, 0xFCB2, 0xFFE0, 0xF020, 0x0490, 0x107E, 0x03D0, 0x1F90, 0xFBCE, 0x089E, 0x0080, 0x1820, 0xF40E, 0x0800, 0xFC30, 0x141E, 0xF06E, 0x0400, 0xFFA0, 0x17CE, 0xF7B0, 0x07D0, 0xFFB0, 0x1830, 0xF3FE, 0x0002, 0xFFE0, 0x14D0, 0xECB0, 0xFBE2, 0xFCB0, 0x13B0, 0xECA0, 0xF8DE, 0xF432, 0x0832, 0xE8D0, 0x1420, 0xFF8E, 0xFF6E, 0x1380, 0x0840, 0x005E, 0xFBEC, 0x0FB0, 0x0BB2, 0xFFFE, 0xFBDE, 0x0820, 0x0BC0, 0x0360, 0xFB8C, 0x0F70, 0x0794, 0x036E, 0xFBFE, 0x0FA0, 0x0BC4, 0x0390, 0xF89E, 0x0C72, 0xFFB2, 0xFC70, 0xFB7E, 0x0470, 0xFCB0, 0xFFF0, 0xF3F0, 0x04A0, 0x049E, 0x03B0, 0x1F90, 0xF7D0, 0x042E, 0x0070, 0x1F70, 0xFBBE, 0x0F00, 0x03B0, 0x142E, 0xF01E, 0x07B0, 0xFFB0, 0x1B60, 0xF37E, 0xFBD0, 0xFF90, 0x1410, 0xF3C0, 0xFC00, 0x0370, 0x1482, 0xF030, 0xF800, 0xFC50, 0x13C2, 0xF050, 0x0070, 0xF812, 0x0C02, 0xEC80, 0x00D0, 0xFBFE, 0xFBCC, 0x0810, 0xFC60, 0xFCB0, 0xFBCE, 0x0FE0, 0x0B40, 0xFFFE, 0xF05C, 0x0840, 0x07D0, 0xFFD0, 0xF79E, 0x0FB0, 0xF802, 0xFFD0, 0xF44E, 0x0BF0, 0xFC32, 0x07A0, 0xF4BE, 0x0C60, 0xF822, 0x0080, 0xF01E, 0x0892, 0x00B4, 0xF850, 0xF040, 0x04B2, 0x085E, 0x0782, 0x1F70, 0xFBEE, 0x001E, 0x0420, 0x1F80, 0xFBB0, 0x03B0, 0x0390, 0x17F0, 0xF04E, 0x0770, 0xFFE0, 0x1B40, 0xF76E, 0xFFC0, 0xFFB0, 0x17E0, 0xEC1E, 0x03A0, 0x03A0, 0x10C0, 0xEC60, 0xFBC2, 0xFC80, 0x0C00, 0xEC60, 0x0050, 0xF800, 0x0802, 0xEC90, 0x0080, 0xF7B0, 0xF7AE, 0x0410, 0xFC32, 0xFC50, 0xF7BE, 0x07F0, 0xFFD2, 0xFBC0, 0xF02E, 0x0460, 0x0382, 0xF410, 0xF36E, 0x0BA0, 0xFBF2, 0xFBC0, 0xF01C, 0x0440, 0xFFE2, 0xFBE0, 0xF0EE, 0x08A2, 0xF804, 0xFCB0, 0xEC3E, 0x04A2, 0x0082, 0xF830, 0xE830, 0x04B2, 0x13F0, 0x0380, 0x1F40, 0xFBB0, 0x0F90, 0x0420, 0x17A0, 0xF7AE, 0x0F40, 0xFFE2, 0x13AE, 0xF03E, 0x0F12, 0xFF60, 0x0F50, 0xF340, 0x0362, 0xFF30, 0x1760, 0xEFD0, 0x0762, 0x0360, 0x1072, 0xEC50, 0xF7B2, 0xF852, 0x07B0, 0xE480, 0xF820, 0xF7C2, 0x03C2, 0xE490, 0x1422, 0x03AE, 0x036E, 0x13C2, 0x13B2, 0x0440, 0xFFCE, 0x13D2, 0x1362, 0x0002, 0xFBDE, 0x0C40, 0x1732, 0x0390, 0xFF8E, 0x1760, 0x0B82, 0x0750, 0x039E, 0x1000, 0x0F82, 0x0B80, 0xFCAE, 0x1080, 0x0BD4, 0x0470, 0xFBCE, 0x0C92, 0x0832, 0x07E0, 0xF7FE, 0x0CA2, 0x0010, 0x0380, 0x13D0, 0xF7A0, 0xFFBE, 0x0052, 0x1380, 0xF770, 0xFF70, 0xFFA0, 0x0FC0, 0xF3BE, 0x0340, 0xFF60, 0x0FC0, 0xF370, 0xFB30, 0xFB80, 0x0C10, 0xE40E, 0xFBA0, 0xFBB0, 0x0C42, 0xE860, 0xFB92, 0xF4A2, 0x0B82, 0xE850, 0xF832, 0xFBA2, 0x0002, 0xE470, 0x0022, 0xF7A0, 0xEFFE, 0x0BC0, 0x03D2, 0xF860, 0xF79E, 0x0F92, 0x0390, 0xFFB0, 0xF3FE, 0x0FC0, 0x0762, 0xFF70, 0xEFFE, 0x1380, 0x0362, 0xFFB0, 0xF42E, 0x0810, 0x07A2, 0x07C0, 0xF87E, 0x0C82, 0x0B94, 0x0490, 0xFB90, 0x1062, 0x0842, 0x07B0, 0xEC10, 0x0C82, 0x0850, 0x13E2, 0x2360, 0x0420, 0x0460, 0x10B0, 0x1FB0, 0x03E0, 0x0B80, 0x0BF0, 0x1430, 0xFC00, 0x0F90, 0x0BC2, 0x1BA0, 0xFFC0, 0x07C2, 0x0B82, 0x1BF0, 0xF44E, 0x0BB2, 0x0FD2, 0x14C2, 0xF8A0, 0x0792, 0x0852, 0x13E2, 0xF850, 0x00A0, 0x0032, 0x0C22, 0xF0D0, 0xF452, 0xEFE0, 0xEF7E, 0xFC32, 0xF072, 0xF4C0, 0xEBCE, 0x03F0, 0xFBA2, 0xF400, 0xE45E, 0x0410, 0xFFA2, 0xF7D0, 0xEBBE, 0x0BD0, 0xFBC2, 0xFB80, 0xF00E, 0x0050, 0x03D2, 0x03D0, 0xF0E0, 0x0CA0, 0x0384, 0x0440, 0xF3EE, 0x0C52, 0x00A2, 0x0030, 0xEC20, 0x04C0, 0x1022, 0x0FD2, 0x1F80, 0x03F0, 0x0830, 0x0C82, 0x17E0, 0xFFB0, 0x0410, 0x0432, 0x0870, 0xF48E, 0x0BD0, 0x07B2, 0x0F90, 0xFBB0, 0xFFF0, 0x07A2, 0x1410, 0xF410, 0x0022, 0x0BC2, 0x0CE0, 0xF850, 0xFFB2, 0x0490, 0x0BC0, 0xECC0, 0xFC70, 0x0012, 0x0400, 0xF0B2, 0x0402, 0xF7D0, 0xF37E, 0x0BF2, 0x0022, 0xFC90, 0xEFFE, 0x0FC2, 0xFC12, 0xF84E, 0xE87E, 0x0480, 0x07E2, 0xFFB0, 0xF7AE, 0x0FC0, 0x0002, 0x07A0, 0xF81E, 0x1002, 0x0422, 0x0FD0, 0xF8CE, 0x1842, 0x07A4, 0x0880, 0xFBB0, 0x0CB0, 0x0C62, 0x0BF0, 0xFBF0, 0x10A0, 0xF030, 0x07D2, 0x0BE0, 0xF800, 0xECA0, 0x0482, 0x0830, 0xFBE0, 0xF040, 0xFC80, 0x0810, 0xF030, 0xF410, 0xF830, 0x0BA0, 0xF7A0, 0xF3D2, 0xFFF2, 0x0840, 0xEFF0, 0xF400, 0x03B2, 0x0872, 0xF030, 0xEFB2, 0x0042, 0x03B2, 0xEC40, 0xFFE0, 0xFFE2, 0x0012, 0xF420, 0xF422, 0xF7B0, 0xE7CE, 0x0BD2, 0xF080, 0x0070, 0xEC2E, 0x0FE2, 0xF850, 0x0070, 0xF00E, 0x0C42, 0x0020, 0x0030, 0xF7AE, 0x17B2, 0x03D2, 0x0400, 0xF84E, 0x17F0, 0x0BE2, 0x13A0, 0xFC4E, 0x1820, 0x0792, 0x1020, 0xFB9E, 0x1C10, 0x1BC2, 0x13C0, 0xFBE0, 0x2002, 0xF040, 0x13A2, 0x0F80, 0xFC30, 0xF46E, 0x0CC2, 0x17B2, 0x0010, 0xFC10, 0x0872, 0x1000, 0xF8B0, 0x07BE, 0x0BE2, 0x13B0, 0xFFE0, 0xF410, 0x0450, 0x0C70, 0xF420, 0x03C0, 0x0F82, 0x1060, 0xFFE0, 0xFB70, 0x13D2, 0x0F90, 0xF820, 0xFC40, 0x0FA2, 0x0BE2, 0xFC60, 0xF012, 0xFB80, 0xEB5E, 0x0802, 0xF420, 0x0090, 0xF78E, 0x13E2, 0xFC02, 0x0060, 0xF40E, 0x1090, 0x0F90, 0x0BD0, 0xFBAE, 0x1FD2, 0x0002, 0x0820, 0xF85E, 0x1800, 0x0F82, 0x1B60, 0xFC3E, 0x23C2, 0x0B42, 0x1BA0, 0xFF7E, 0x27E0, 0x1012, 0x1B70, 0xFFC0, 0x2040, 0xFC70, 0x1BA2, 0x0FA0, 0x0BA0, 0x0002, 0x1432, 0x0FE0, 0x0010, 0xF83E, 0x13E0, 0x085E, 0x07E0, 0x005E, 0x0842, 0x0FEE, 0x03D0, 0xFC20, 0x0FE2, 0x1400, 0x0780, 0x0B90, 0x1772, 0x1410, 0x07B0, 0xFB10, 0x17F2, 0x0B20, 0x03F0, 0xFC1E, 0x17B2, 0x07CE, 0x0830, 0xE050, 0xEF80, 0xD38E, 0x0382, 0xEBE0, 0xF810, 0xDFBE, 0x07D0, 0xEC10, 0xFFC0, 0xE01E, 0x0BB0, 0xF820, 0xF810, 0xEBBE, 0x0BA0, 0xFBF0, 0x07A0, 0xF3EE, 0x1B50, 0x0752, 0x0F30, 0xF7EE, 0x1B80, 0x02F2, 0x0FD0, 0xF70E, 0x13C0, 0x0BE0, 0x1390, 0xF79E, 0x1C00};
   
    static char[] test_string_0 = new char[]{ 0, 0, 0, 0 };
    static char[] test_string_1 = new char[]{ '1', '2', '3', '4', '5', };
    static char[] test_string_2 = new char[]{ '1', '2', '3', '4', '5', 0, };
    static char[] test_string_3 = new char[]{ '1', '2', '3', '4', '5', 0, '6', '7', '8', '9', };
    static char[] test_string_4 = new char[]{ '1', '2', '3', '4', '5', 0, '6', '7', '8', '9', 0 };
    static char[] test_string_5 = new char[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, };
    static char[] test_string_6 = new char[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254 };
    static char[] test_string_7 = new char[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255 };


    static char[][] tests = new char[][]{new char[random_data.length*2] ,test_string_0, test_string_1, test_string_2, test_string_3, test_string_4, test_string_5, test_string_6, test_string_7};

    public static void main(String[] args){

        for(int i = 0; i<random_data.length; i++){
            int z = i*2;
            tests[0][z+1] = (char) ((random_data[i]>>8) & 0xFF);
            tests[0][z] = (char) ((random_data[i]) & 0xFF);
        }
        
        for(int t = 0; t < tests.length; t++){

            char[] encoded = new char[Cobs.encodeDstBufMaxLen(tests[t].length)];

            Cobs.EncodeResult encodeResult = Cobs.encode(encoded, encoded.length, tests[t], tests[t].length);
          
            char[] decoded = new char[Cobs.decodeDstBufMaxLen(encodeResult.outLen)];

            Cobs.DecodeResult decodeResult = Cobs.decode(decoded, decoded.length, encoded, encodeResult.outLen);

            boolean same = true;
            if(tests[t].length != decodeResult.outLen){
                same = false;
            } else {
                for(int i = 0; i<tests[t].length; i++){
                    if(tests[t][i] != decoded[i]){
                        same = false;
                        break;
                    }
                }
            }

            if(same) System.out.println("Test #" + (t+1) + " success");
            else System.out.println("Test #" + (t+1) + " failed");

        }

    }



}