import java.util.*;

class Solution {
    public int maximumSwap(int num) {
        char[] ch = String.valueOf(num).toCharArray();
        int[] ocr = new int[10];

        for (int i = 0; i < ch.length; i++) {
            ocr[ch[i] - '0'] = i;
        }

        for (int i = 0; i < ch.length; i++) {
            for (int j = 9; j > ch[i] - '0'; j--) {

                if (ocr[j] > i) {

                    char temp = ch[i];
                    ch[i] = ch[ocr[j]];
                    ch[ocr[j]] = temp;

                    return Integer.parseInt(new String(ch));
                }
            }
        }

        return num;
    }
}
