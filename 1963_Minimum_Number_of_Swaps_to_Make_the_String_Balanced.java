class Solution {
    public int minSwaps(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;
        int count = 0;
        char[] arr = s.toCharArray(); // Convert string to char array for easier manipulation
        int bal=0;
        while (p1 < p2) {
        

            // If the current character at p1 is '[' (opening bracket)
            if (arr[p1] == '[') {
                bal++;
            } else {
                bal--;
            }

            // If we have more closing brackets than opening ones, we need a swap
            if (bal <0) {
                // Move p2 left to find an opening bracket '[' to swap
                

                // Swap characters at p1 and p2
                
                count++;  // Increment the swap count
                  bal=1;// Move p2 further left after the swap
            }

            p1++; // Move p1 to the right
        }

        return count;
    }


}
