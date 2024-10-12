import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        
        int[][] events = new int[n][3];

        
        for (int i = 0; i < n; i++) {
            events[i][0] = times[i][0]; 
            events[i][1] = times[i][1]; 
            events[i][2] = i; 
        }

        
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

       
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        
        PriorityQueue<int[]> chairEndTime = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int[] event : events) {
            int arrival = event[0];
            int leaving = event[1];
            int friendIndex = event[2];

           
            while (!chairEndTime.isEmpty() && chairEndTime.peek()[0] <= arrival) {
                availableChairs.add(chairEndTime.poll()[1]);
            }

            
            int chair = availableChairs.poll();

            
            if (friendIndex == targetFriend) {
                return chair;
            }

            
            chairEndTime.add(new int[]{leaving, chair});
        }

        return -1;    }
}
