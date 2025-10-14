package cs1501_p1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * test coverage not guaranteed
 * @author    noah
 */
public class Test_01 {

    /** an int[][] where each int[] is a test case. {@code setup()} returns a List of BSTs generated from these int arrays, with ints added in the order listed. test cases mostly generated randomly, except for the first 8*/
    private final int[][] puts = { 
        {}, { 0 }, { 1 },  { 0, 1 }, { 1, 0 }, { 1, 0, 2 }, { 0, 1, 2 }, { 2, 1, 0 },
        { 97, 935, 334, 562, 371, 52, 566, 983, 824, 989 },
        { 640, 652, 18, 915, 294, 431, 305, 181, 696, 63, 449, 706, 465, 996, 743, 487, 235, 748, -19, 876, -2 },
        { 864, 898, 8, 521, 492, 301, 558, 365, 976, 13, 463, 211, 245, 575 },
        { 897, 647, 140, 268, 527, 25, 794, 539, 160, 801, 547, 44, 557, 174, 690, 311, 829, 317, 193, 321, 195, 708, 709, 577, 79, 470, 856, 346, 859, 604, 862, 103, 108, 110, 750, 753, 114, 113, 370, 244, 887, 632, 249, 762, 763, 125 },
        { 13, 27, 417, 682, 810, 813, 432, 953, 828, 572, 326, 583, 209, 466, 215, 603, 994, 359, 233 },
        { 387, 10, 12, 15, 658, 403, 277, 664, 284, 30, 798, 807, 424, 940, 430, 818, 184, 576, 192, 833, 708, 710, 583, 200, 463, 470, 345, 732, 478, -29, 360, 745, 492, 621, 500, 247, 122, 891 },
        { 993, 545, 643, 233, 337, 244, 854, 887, 569, 767 },
        { 769, 770, 642, 130, 11, 526, 402, 24, 157, 31, 32, 673, 36, 550, 558, 820, 308, 948, 55, 311, 317, 318, 704, 834, 68, 583, 205, 850, 92, 221, 734, 227, 355, 487, 619, 235, 365, 368, 757, 122, 253 },
        { 642, 900, 135, 137, 907, 914, 404, 917, 29, 289, 802, 290, 935, 562, 183, 959, 191, 66, 579, 710, 582, 329, 339, 858, 862, 735, 224, 481, 995, 101, 618 },
        { 644, 910, 529, 407, 541, 159, 170, 43, 172, 428, 685, 438, 825, 570, 458, 459, 588, 606, 734, 481, 496, -12, 501, 374, 758, 372, 507 },
        { 514, 3, 386, 389, 5, 771, 138, 651, 269, 401, 146, 19, 402, 26, 412, 420, 936, 681, 688, 562, 439, 696, 315, 62, 705, 451, 327, 588, 335, 722, 341, 214, 215, 984, 91, 604, 221, 222, 354, 867, 228, -24, 749, 367, 626, 627, 762, 510 },
        { 1, 646, 394, 651, 917, 543, 33, 675, 292, 420, 294, 552, 559, 950, 183, 697, 708, 711, 461, 718, 337, 723, 469, 90, 348, -29, 613, 358, 105, -21, 877, 881, 626, 499, 765 },
        { 516, 647, 777, 906, 393, 400, 528, 529, 403, 537, 415, 546, 547, 424, 168, 45, 176, 947, 182, 441, 574, 575, 191, 579, 964, 835, 71, 201, 714, 590, 207, 978, 596, 856, 217, 859, 219, 348, 97, 609, 996, 233, 361, 368, 115, 119, 125 },
        { 132, 7, 137, 271, 919, 920, 157, 31, 300, 44, 173, 178, 444, 460, 214, 870, 111, 625, 755, 628, 886, 376 },
        { 259, 643, 389, 134, 523, 527, 658, 915, 21, 280, 923, 928, 801, 293, 549, 550, 166, 297, 684, 307, 947, 948, 950, 567, 442, 59, 955, 958, 705, 328, 459, 723, 89, 859, 93, 995, -22, 634 },
        { 257, 516, 784, 275, 664, 923, 157, 34, 35, 420, 47, 305, 818, 820, 54, 578, 706, 837, 75, 465, 729, 608, 226, 870, 109, 629 },
        { 509, 1, 259, 772, 6, 792, 922, 923, 927, 550, 423, 814, 433, 52, 185, 59, 573, 191, 961, 840, 587, 971, 214, 854, 983, 855, 219, 739, 740, 229, -29, 872, -23, 488, 115, 250, 636, 765, 766 },
        { 131, 139, 651, 919, 796, 34, 935, 681, 174, 431, 560, 689, 432, 825, 954, 194, 842, 845, 846, 975, 593, 850, 981, 341, 89, 347, 358, 872, 749, 508, 499, 634, 636, 254 },
        { 260, 7, 9, 18, 147, 916, 786, 791, 408, 664, 922, 27, 169, 937, 41, 433, 695, 569, 197, 971, 464, 80, 342, 87, 347, 990, 479, 608, 96, 352, 355, 478, 613, 876, 879, -17, 762 },
        { 390, 328, 937, 425, 843, 588, 721, 753, 531, 632 },
        { 0, 779, 400, 529, 148, 24, 667, 160, 420, 38, 424, 425, 299, 559, 175, 305, 817, 51, 53, 830, 575, 577, 962, 195, 451, 325, 582, 709, 464, 976, 595, 84, 476, 478, 607, 994, 995, 360, 872, 493, -15, -14, -13, 241, 118, 374, 383 },
        { 392, 525, 786, 659, 536, 29, 797, 925, 546, 803, 292, 677, 550, 678, 34, 298, 939, 810, 818, 959, 65, 451, 583, 976, 209, 978, 855, 475, 91, 732, -23, 489, 363, 109, -19, 237, 368, 251, -3, 126, 127 },
        { 772, 266, 408, 297, 938, 557, 436, 581, 837, 712, 463, 978, 349, 884, 374, 503, 506, 123, 252 },
        { 130, 518, 136, 530, 663, 930, 163, 303, 50, 51, 180, 183, 832, 195, 581, 199, 584, 973, 78, 975, 981, 984, 740, 101, 752, 114, 244, 891 },
        { 387, 771, 389, 12, 657, 402, 658, 283, 288, 804, 421, 164, 806, 297, 49, 818, 435, 692, 437, 951, 953, 572, 193, 194, 708, 837, 68, 582, 456, 841, 202, 203, 847, 719, 466, 88, 996, 869, 108, 238, 111, -17, -14, -12, 373, 251, 765 },
        { 768, 609, 578, 41, 811, 43, 815, 911, 944, 304, 82, 692, 468, 663, 888 },
        { 898, 391, 524, 400, 401, 275, 663, 25, 282, 550, 432, 435, 951, 832, 712, 75, 211, 725, 474, 867, 615, 871, 872, 359, 487, 890, 254 },
        { 130, 909, 274, 789, 277, 541, 546, 678, 295, 42, 432, 693, 826, 62, 577, 971, 463, 84, 598, 855, 737, 610, -11, 248, 379 },
        { 522, 524, 801, 935, 814, 577, 706, 582, 461, 87, 216, 222, 741, 490, 110, 880, 370, 763, 254 },
        { 142, 275, 665, 282, 927, 40, 45, 182, 822, 326, 459, 468, 345, 475, 478, 351, -6, 372, 247, 762 },
        { 519, 916, 928, 34, 294, 810, 813, 433, 834, 76, 721, 851, 979, 472, 604, 609, 228, -28, 617, 105, 498 },
        { 896, 387, 261, 6, 269, 783, 147, 277, 921, 154, 929, 676, 301, 302, 815, 432, 177, 697, 575, 703, 581, 330, 74, 718, 464, 337, 723, 216, 731, 733, 607, -24, 488, 621, 240 },
        { 651, 268, 142, 527, 796, 413, 809, 303, 690, 309, 960, 587, 972, 83, 859, 221, 737, 747, 239, 112 },
        { 33, 226, 584, 556, 76, 80 },
        { 96, 33, 327, 40, 683, 364, 427, 881, 370, -11, 442, 255 },
        { -27, 581, 998, 453, 43, 14, 240, 20, 950, 470, 602, 987 },
        { 737, 194, 419, 485, 934, 296, 267, 589, 173, 77, 973, 178, 629, -9, 953 },
        { 768, 513, 258, 387, 910, 783, 401, 535, 664, 157, 797, 803, 676, 805, 38, 934, 935, 810, 429, 174, 173, 432, 692, 440, 571, 192, 966, 840, 714, 336, 337, 465, 89, 217, 731, 990, 991, 628, 630, 377, 253 },
        { 1, 520, 137, 909, 912, 914, 152, 25, 157, 414, 32, 801, 420, 292, 428, 943, 688, 184, 186, 314, 188, 447, 705, 202, 843, 78, 208, 598, 347, 486, 248, 507, 893 },
        { 514, 262, 8, 653, 13, 788, 534, 282, 156, 158, 162, 420, 165, 44, 46, 687, 816, 946, 563, 446, 318, 577, 838, 71, 328, 585, 70, 849, 339, 84, 86, 983, 473, 93, 486, 360, -22, -4, 237, 754, 882, 373, 632, -6, 380 },
        { 385, 897, 4, 645, 913, 793, 29, 932, 300, 815, 435, 567, 188, 969, 586, 232, 490, 235, 620, 369, 631, 760, 254, 127 },
        { 320, 801, 194, 864, -30, 41, 748, 620, 303, 340, 308, 468 },
        { 832, 578, 835, 133, 425, 522, 11, 268, 714, 942, 20, 443, 894, 287 },
        { 774, 138, 21, 22, 917, 795, 673, 932, 689, 831, 576, 841, 714, 599, 344, 475, 223, 736, 97, 611, -1 },
        { 386, 259, 10, 911, 17, 149, 533, 798, 288, 417, 298, 432, 50, 565, 705, 71, 456, 721, 981, 983, 471, 601, 732, 106, 366, 508, 383 },
        { 385, 903, 525, 143, 787, 917, 928, 35, 675, 678, 424, 169, 41, 813, 304, 570, 327, 585, 714, 715, 205, 593, 338, 856, 472, 475, 220, 478, 98, 122, -26, 104, 1000, 618, 366, 494, 501, 502, 888, 377, 634, 127 },
        { 640, 257, 514, 522, 781, 405, 663, 793, 797, 543, 808, 305, 306, 437, 181, 447, 193, 706, 456, 970, 846, 80, 721, 467, 475, -29, 110, 498 },
        { 640, 488, 425, 207, 690, 275 },
        { 192, 352, 641, 353, 196, 229, 393, -21, 780, 622, 399, 879, 401, 175, 468, 793, 825, 985 },
        { 43, 395, 717, 430, 79, 816, 723, 53, 920, 474, 91, 252, 542, 191 },
        { 646, 785, 661, 662, 152, 920, 541, 808, 425, 555, 434, 564, 185, 572, 829, 702, 191, 962, 67, 837, 838, 974, 854, 217, 478, 488, 105, 125 },
        { 132, 521, 394, 141, 401, 914, 535, 288, 935, 555, 564, 821, 695, 568, 569, 961, 578, 709, 197, 82, 981, 89, 348, 996, 613, 232, 237, 127, 367, -17, 498, 371, 252, 767 },
        { 800, 483, 996, -2, 151, 381, 382 },
        { 384, 256, 897, 773, 529, 537, 410, 291, 165, 941, 693, 440, 56, 828, 444, 78, 207, 469, 359, 874, 491, 751, 241, 882, 764 },
        { 965, -22, 368, 309, 443 },
        { 519, 409, 33, 802, 676, 806, 808, 41, 939, 560, 946, 316, 191, 327, 330, 974, 719, 847, 849, 83, 341, 220, 865, 482, 244, -12, 374, -3, 895 },
        { 651, 15, 657, 659, 789, 278, 281, 283, 157, 286, 544, 673, 674, 550, 170, 683, 557, 951, 439, 188, 578, 328, 73, 716, 340, 216, 223, 620, 108, 752, 624, 882, -13, 884, -9, 634 },
        { 832, 929, 100, 203, 207, 784, 880, 822, -2 },
        { 906, 913, 921, 34, 678, 296, 815, 950, 61, 191, 66, 69, 973, 849, 978, 100, 232, 104, 757, -11, 381 },
        { 900, 518, 652, 912, 274, 533, 409, 537, 155, 665, 667, 547, 419, 808, 177, 689, 436, 824, 63, 66, 201, 974, 977, 723, 724, 341, 342, 854, 729, 987, 609, 867, 614, 880, 624, -14, 756, 757 },
        { 992, 449, 801, 647, 682, 845, 174, 399, 505, 314, 476, 445, 606, 799 },
        { 774, 519, 520, 904, 906, 392, 15, 532, 150, 663, 409, 668, 924, 669, 287, 32, 801, 415, 798, 805, 296, 937, 682, 946, 823, 828, 60, 190, 577, 65, 965, 712, 460, 76, 844, 845, 977, 338, 854, 984, 344, 354, 123, 111, 112, 498, 120, -5, 254, 511 },
        { 897, 5, 274, 406, 920, 35, 812, 432, 437, 953, 187, 573, 326, 201, 331, 332, 207, 848, 721, 722, 729, 985, 475, 91, 604, 225, 739, 996, 104, 362, 875, 237, 494, 880, 241, 881, 119, 381 },
        { 518, 650, 401, 663, 791, 153, 671, 37, 679, 298, 684, 46, 438, 829, 321, 582, 590, 980, 855, 352, -6, 228, 229, 873, -16, 120, 633, 506, 638 },
        { 768, 641, 130, 519, 525, 782, 145, 657, 405, 150, 152, 410, 160, 930, 291, 550, 942, 814, 815, 817, 821, 182, 199, 328, 841, 586, 77, 975, 471, 475, 92, 606, 353, 101, 488, 1000, 747, 878, 368, 499, 373, 501, 888, 761 },
        { 512, 131, 392, 395, 18, 403, 662, 285, 930, 547, 548, 679, 567, 568, 825, 697, 60, 710, 841, 973, 206, 94, 999, 361, 628, 377, 636 },
        { 911, 790, 540, 413, 416, 165, 558, 566, 702, 320, 65, 455, 593, 984, 600, 868, 614, -24, 747, 117, 759, 762 },
        { 480, 676, 901, 230, 871, 996, 267, 715, 429, 877, 559, 460, 145, 598, 406, 662, 541 },
        { 11, 911, 785, 673, 947, 312, 697, 570, 58, 187, 446, 192, 713, 972, 844, 723, 852, 93, 997, 491, 892 },
        { 480, 545, 580, 166, 838, 712, 455, 48, 17, 659, 668 },
        { 353, -19, 342, 249, 666 },
        { 97, 518, 473, 529, 531, 665 },
        { 512, 865, -29, 581, 133, 809, 459, 268, 333, 366, 978, 627, -11, 984, 89, 442 },
        { 548, 36, 584, 591, 435 },
        { 909, 22, 804, 551, 680, 297, 295, 941, 560, 183, 827, 60, 188, 573, 450, 978, 852, 734, 480, 618, 492, 372 },
        { 769, 771, 260, 4, 134, 391, 911, 661, 790, 21, 923, 162, 802, 41, 42, 44, 300, 941, 944, 817, 946, 445, 192, 712, 461, 82, 862, 224, 226, 611, -27, 102, 1000, 876, 242, 885, 250 },
        { 512, 641, 258, 771, 394, 138, 907, 659, 148, 793, 159, 31, 424, 555, 304, 565, 952, 697, 185, 444, 706, 196, 71, 840, 460, 462, 727, 485, 870, -26, 489, 619, -4, 622, 752, 245, 377, 127, 126, 383 },
        { 512, 513, 396, 397, 782, 792, 160, 693, 715, 332, 854, 88, -28, 484, 358, 999, 744, -19, 502 },
        { 581, 103, 267, 555, 909, 365, 269, 720, 431, 82, -6, 187, 988, 61 },
        { 267, 146, 22, 926, 545, 36, 167, 431, 309, 184, 449, 583, 462, 849, 978, 729, 217, 605, 96, 740, 869, 615, 495, 497, -15, 118, 508 },
        { 142, 924, 542, 936, 552, 811, 182, 951, 567, 315, 189, 837, 711, 717, 847, 254, 345, 741, 498, 372, 501, 631, 249, 382 },
        { 1, 774, 913, 291, 164, 688, 818, 186, 61, 62, 449, 589, 598, 222, 481, 616, 491, 878, -16, 891 },
        { 192, 481, 834, 545, 293, 79, 528, 723, 628, 534, 24, 729, -5 },
        { 770, 131, 900, 263, 776, 522, 654, 272, 534, 791, 152, 157, 931, 165, 554, 302, 52, 322, 333, 591, 336, 850, 853, 86, 477, 734, 607, 608, 483, -27, 109, 112, 243, 249 },
        { 258, 386, 131, 262, 647, 649, 279, 281, 26, 929, 675, 935, 168, 46, 943, 433, 565, 439, 824, 569, 576, 448, 453, 710, 975, 594, 724, 341, 598, 347, 863, 352, 96, 360, -24, 236, 364, 622, 879, 496, 244, 886, 249, 635 },
        { 68, 612, 741, 40, 428, 877, 339, 661, 150, 951, 824, 761, 187, 893, 223 },
        { 960, 163, -29, 645, 198, 376 },
        { 535, 677, 198, 741, 968, 841, 68, 878, 271, 912, 338, -13, 695, 888, -6, 828, 254 },
        { 486, 872, 589, 782, 175, 624, 660, 598, 87, 186 },
        { 323, 229, 263, 73, 201, 331, 657, -1, 23, 440, 158, 223 },
        { 519, 780, 524, 272, 530, 149, 281, 540, 415, 292, 173, 176, 816, 439, 186, 61, 704, 711, 847, 464, 981, 86, 470, 726, 860, 349, 734, 479, 96, 353, 867, 503, 869, 486, 742, -27, 874, 367, 371, 119, 893, -1 },
        { 930, 130, 38, 468, 287 },
        { 772, 647, 391, 782, 656, 284, 804, 165, 677, 295, 422, 170, 554, 433, 435, 439, 960, 710, 712, 457, 461, 462, 985, 730, 219, 605, 349, 862, 733, 610, 739, 356, 613, 232, 617, 108, 120, 633, 251, 765 },
        { 128, 609, 352, 866, 133, 135, 296, 999, 332, -20, 818, 947, 570, 472, 121, 218, 828, 925 },
        { 769, 773, 392, 520, 906, 657, 274, 924, 673, 163, 419, 420, 934, 806, 558, 815, 302, 695, 188, 190, 831, 574, 449, 451, 710, 841, 73, 458, 338, 725, 86, 605, 734, 350, 992, 736, 105, 234, 113, 627, 374, 252, 510, 383 },
        { 640, 527, 277, 409, 665, 286, 543, 417, 803, 38, 296, 814, 47, 305, 820, 565, 568, 702, 704, 965, 455, 200, 75, 76, 717, 459, 335, 975, 207, 84, 726, 87, 219, 606, 997, 741, 357, -24, 105, 487, 872, -25, -18, 242, 885, 246, 764 },
        { 171, 75, 556, 436, 373, 886, 895, 376, 285, 95 },
        { 66, 612, 772, 9, 235, 43, 464, 498 },
        { 738, 232, 365, 272, 977, 625, 754, 177, 757, 151, 666, 444, 861, 319 },
        { 323, 307, 55, 568, 767 },
        { 64, 32, 96, 16, 48, 80, 112, 8, 24, 40, 56, 72, 88, 104 } // i also secretly hardcoded this one
    };

    /**
     * 
     * @return all the BST<Integer>s (based on inputs from {@code int[][] puts} in one big List
     */
    private List<BST<Integer>> setup() {
        List<BST<Integer>> ts = new ArrayList<BST<Integer>>();
        for (int i = 0; i < puts.length; i++) {
            ts.add(new BST<Integer>());
            for (int k : puts[i]) {
                ts.get(i).put(k);
            }
        }
        return ts;
    }

    @Test
    public void putAndContains() {
        List<BST<Integer>> ts = setup();
        for (int i = 0; i < ts.size(); i++) {
            for (int k = 0; k < puts[i].length; k++) {
                assertTrue(ts.get(i).contains(puts[i][k]), "failed to find " + puts[i][k] + " in BST " + i);
            }
            assertTrue(!ts.get(i).contains(-31), "incorrectly stated that -31 is in BST " + i);
            assertTrue(!ts.get(i).contains(107), "incorrectly stated that 107 is in BST " + i);
            assertTrue(!ts.get(i).contains(819), "incorrectly stated that 819 is in BST " + i);
            assertTrue(!ts.get(i).contains(1001), "incorrectly stated that 1001 in BST " + i);
        }
    }

    @Test
    public void delete() {
        // delete all the keys from a BST, in the opposite order they were added
        List<BST<Integer>> ts = setup();
        for (int i = 0; i < ts.size(); i++) {
            for (int k = puts[i].length-1; k >= 0; k--) {
                ts.get(i).delete(puts[i][k]);
                assertTrue(!ts.get(i).contains(puts[i][k]), "failed to delete " + puts[i][k] + " from BST " + i);
                for (int l = k - 1; l > 0; l--) {
                    assertTrue(ts.get(i).contains(puts[i][l]), "accidentally deleted " + puts[i][l] + " while attemtping to delete " + puts[i][k] + " from BST " + i);
                }
            }
        }

        // delete all the keys from a BST, in the same order they were added (starting with the root)
        ts = setup();
        for (int i = 0; i < ts.size(); i++) {
            for (int k = 0; k < puts[i].length; k++) {
                ts.get(i).delete(puts[i][k]);
                assertTrue(!ts.get(i).contains(puts[i][k]), "failed to delete " + puts[i][k] + " from BST " + i);
                for (int l = k + 1; l < puts[i].length; l++) {
                    assertTrue(ts.get(i).contains(puts[i][l]), "accidentally deleted " + puts[i][l] + " while attemtping to delete " + puts[i][k] + " from BST " + i);
                }
            }
        }
        
        /* 
         * delete all the keys from a BST in the order they were added, starting with i%length and looping around.
         * this will hopefully weed out some edge cases where deletion is complex.
         * 
         * the offset 'i' is the BST's number, i.e. its index in the list of BSTs, so the BST with index 9 will
         * start deleting from the 10th item added (index 9), then delete in order until the end, then loop back
         * around to delete from index 0 until the BST is empty, for example.
         */ 
        ts = setup();
        for (int i = 1; i < ts.size(); i++) {
            boolean started = false;
            for (int k = i%puts[i].length; k != i%puts[i].length || !started; k = (k+1)%puts[i].length) {
                started = true;
                ts.get(i).delete(puts[i][k]);
                assertTrue(!ts.get(i).contains(puts[i][k]), "failed to delete " + puts[i][k] + " from BST " + i);
                if (k >= i%puts[i].length) {  // if the deleting hasn't looped around yet
                    for (int l = (k+1)%puts[i].length; l > k || l < i%puts[i].length; l = (l+1)%puts[i].length) {
                        assertTrue(ts.get(i).contains(puts[i][l]), "accidentally deleted " + puts[i][l] + " while attemtping to delete " + puts[i][k] + " from BST " + i);
                    }
                } else {  // once the deleting has looped around to the beginning
                    for (int l = (k+1)%puts[i].length; l < i%puts[i].length; l = (l+1)%puts[i].length) {
                        assertTrue(ts.get(i).contains(puts[i][l]), "accidentally deleted " + puts[i][l] + " while attemtping to delete " + puts[i][k] + " from BST " + i);
                    }
                }
            }
        }
    }

    @Test
    public void height() {
        List<BST<Integer>> ts = setup();
        // exact tests for manually-entered BSTs
        assertTrue(ts.get(0).height() == 0, "empty BST should have height 0");
        assertTrue(ts.get(1).height() == 1, "singleton BST should have height 1");
        assertTrue(ts.get(2).height() == 1, "singleton BST should have height 1");
        assertTrue(ts.get(3).height() == 2, "2-item BST should have height 2");
        assertTrue(ts.get(4).height() == 2, "2-item BST should have height 2");
        assertTrue(ts.get(5).height() == 2, "full 3-item BST should have height 2");
        assertTrue(ts.get(6).height() == 3, "non-full 3-item BST should have height 3");
        assertTrue(ts.get(7).height() == 3, "non-full 3-item BST should have height 3");
        
        // exact tests for a few randomly-generated BSTs
        assertTrue(ts.get(8).height() == 6, "BST 8 should have height 6");
        assertTrue(ts.get(9).height() == 8, "BST 9 should have height 8");
        assertTrue(ts.get(10).height() == 8, "BST 10 should have height 8");
        assertTrue(ts.get(11).height() == 11, "BST 11 should have height 11");
        assertTrue(ts.get(12).height() == 8, "BST 12 should have height 8");
        assertTrue(ts.get(13).height() == 11, "BST 13 should have height 11");
        assertTrue(ts.get(14).height() == 5, "BST 14 should have height 5");
        assertTrue(ts.get(15).height() == 13, "BST 15 should have height 13");
        
        // less stringent tests: guarantees that log(n) <= height <= n, where n = no. of nodes
        for (int i = 16; i < ts.size(); i++) {
            BST<Integer> t = ts.get(i);
            int height = t.height();
            assertTrue(height <= puts[i].length,  "BST " + i + " is too tall: height is " + height + " even though it only contains " + puts[i].length + " items");
            assertTrue(height >= Math.log(puts[i].length) / Math.log(2),  "BST " + i + " is too short: height is " + height + " even though it contains " + puts[i].length + " items");
        }
    }

    @Test
    public void isBalanced() {
        List<BST<Integer>> ts = setup();
        for (int i = 0; i < ts.size(); i++) {
            // BSTs 0-6, 81, 107, and 108 are definitely balanced, and i am prettyyyyy sure the rest are not
            if (i<6 || i==81 || i==107 || i==108) assertTrue(ts.get(i).isBalanced(), "tree number " + i + " is balanced");
            else assertTrue(!ts.get(i).isBalanced(), "tree number " + i + " is balanced? surprising!");
        }
    }

    @Test
    public void iot() {
        List<BST<Integer>> ts = setup();
        for (int i = 0; i < ts.size(); i++) {
            StringBuilder valid = new StringBuilder();
            int[] sorted = puts[i].clone();
            Arrays.sort(sorted);
            for (int el : sorted) valid.append(el + ":");
            if (valid.length() > 1) valid.deleteCharAt(valid.length()-1);  // ditch the extra colon at the end
            assertEquals(valid.toString(), ts.get(i).inOrderTraversal(), "for BST " + i + " produced " + ts.get(i).inOrderTraversal() + " when " + valid.toString() + " was expected");
        }
    }

    @Test
    public void serial() {
        BST<Integer> t = new BST<Integer>();
        for (int el : new int[] {10, 5, 37, 2, 45}) t.put(el);
        assertEquals("R(10),I(5),L(2),X(NULL),I(37),X(NULL),L(45)", t.serialize(),
            "expected \"R(10),I(5),L(2),X(NULL),I(37),X(NULL),L(45)\" but got " + t.serialize() + " instead");
        
        t = new BST<Integer>();
        for (int el : new int[] {1, 2, 3, 4, 5}) t.put(el);
        assertEquals("R(1),X(NULL),I(2),X(NULL),I(3),X(NULL),I(4),X(NULL),L(5)", t.serialize(),
            "expected \"R(1),X(NULL),I(2),X(NULL),I(3),X(NULL),I(4),X(NULL),L(5)\" but got " + t.serialize() + " instead");
        
        t = new BST<Integer>();
        for (int el : new int[] {1, 2, 3, 4, 5, 10, 7, 8, 12}) t.put(el);
        assertEquals("R(1),X(NULL),I(2),X(NULL),I(3),X(NULL),I(4),X(NULL),I(5),X(NULL),I(10),I(7),X(NULL),L(8),L(12)", t.serialize(),
            "expected \"R(1),X(NULL),I(2),X(NULL),I(3),X(NULL),I(4),X(NULL),I(5),X(NULL),I(10),I(7),X(NULL),L(8),L(12)\" but got " + t.serialize() + " instead");
        
        t = new BST<Integer>();
        for (int el : new int[] {2, 3, 1}) t.put(el);
        assertEquals("R(2),L(1),L(3)", t.serialize(), "expected \"R(2),L(1),L(3)\" but got " + t.serialize() + " instead");
        
        t = new BST<Integer>();
        assertEquals("", t.serialize(), "expected \"\" but got " + t.serialize() + " instead");
        
        t.put(2);
        assertEquals("R(2)", t.serialize(), "expected \"R(2)\" but got " + t.serialize() + " instead");
    }

    @Test
    public void reverse() {
        BST<Integer> t = new BST<Integer>();
        for (int el : new int[] {10, 5, 37, 2, 45}) t.put(el);
        String rev = t.reverse().serialize();
        assertEquals("R(10),I(37),L(45),X(NULL),I(5),X(NULL),L(2)", rev,
            "expected \"R(10),I(37),L(45),X(NULL),I(5),X(NULL),L(2)\" but got " + rev + " instead");
        assertEquals("R(10),I(5),L(2),X(NULL),I(37),X(NULL),L(45)", t.serialize(),
            "expected \"R(10),I(5),L(2),X(NULL),I(37),X(NULL),L(45)\" but got " + t.serialize() + " instead; reverse() seems to have modified the original BST");
        
        t = new BST<Integer>();
        for (int el : new int[] {1, 2, 3, 4, 5}) t.put(el);
        rev = t.reverse().serialize();
        assertEquals("R(1),I(2),I(3),I(4),L(5),X(NULL),X(NULL),X(NULL),X(NULL)", rev,
            "expected \"R(1),I(2),I(3),I(4),L(5),X(NULL),X(NULL),X(NULL),X(NULL)\" but got " + rev + " instead");
        assertEquals("R(1),X(NULL),I(2),X(NULL),I(3),X(NULL),I(4),X(NULL),L(5)", t.serialize(),
            "expected \"R(1),X(NULL),I(2),X(NULL),I(3),X(NULL),I(4),X(NULL),L(5)\" but got " + t.serialize() + " instead; reverse() seems to have modified the original BST");
        
        t = new BST<Integer>();
        for (int el : new int[] {1, 2, 3, 4, 5, 10, 7, 8, 12}) t.put(el);
        rev = t.reverse().serialize();
        assertEquals("R(1),I(2),I(3),I(4),I(5),I(10),L(12),I(7),L(8),X(NULL),X(NULL),X(NULL),X(NULL),X(NULL),X(NULL)", rev,
            "expected \"R(1),I(2),I(3),I(4),I(5),I(10),L(12),I(7),L(8),X(NULL),X(NULL),X(NULL),X(NULL),X(NULL),X(NULL)\" but got " + rev + " instead");
        assertEquals("R(1),X(NULL),I(2),X(NULL),I(3),X(NULL),I(4),X(NULL),I(5),X(NULL),I(10),I(7),X(NULL),L(8),L(12)", t.serialize(),
            "expected \"R(1),X(NULL),I(2),X(NULL),I(3),X(NULL),I(4),X(NULL),I(5),X(NULL),I(10),I(7),X(NULL),L(8),L(12)\" but got " + t.serialize() + " instead; reverse() seems to have modified the original BST");

        t = new BST<Integer>();
        for (int el : new int[] {2, 3, 1}) t.put(el);
        rev = t.reverse().serialize();
        assertEquals("R(2),L(3),L(1)", rev, "expected \"R(2),L(3),L(1)\" but got " + rev + " instead");
        assertEquals("R(2),L(1),L(3)", t.serialize(), "expected \"R(2),L(1),L(3)\" but got " + t.serialize() + " instead; reverse() seems to have modified the original BST");
        
        t = new BST<Integer>();
        rev = t.reverse().serialize();
        assertEquals("", rev, "expected \"\" but got " + rev + " instead");
        assertEquals("", t.serialize(), "expected \"\" but got " + t.serialize() + " instead; reverse() seems to have modified the original BST");
        
        t.put(2);
        rev = t.reverse().serialize();
        assertEquals("R(2)", rev, "expected \"R(2)\" but got " + rev + " instead");
        assertEquals("R(2)", t.serialize(), "expected \"R(2)\" but got " + t.serialize() + " instead; reverse() seems to have modified the original BST");
    }
}
