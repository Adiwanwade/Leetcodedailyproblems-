class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> v = new HashSet<>();
        q.offer(new int[] { 1, 0 });
        v.add(1);
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int pos = curr[0], moves = curr[1];
            for (int i = 1; i <= 6 && pos + i <= n * n; i++) {
                int next = pos + i;
                int[] coords = getCoordinates(next, n);
                int r = coords[0], c = coords[1];
                if (board[r][c] != -1) {
                    next = board[r][c];
                }
                if (next == n * n)
                    return moves + 1;
                if (!v.contains(next)) {
                    v.add(next);
                    q.offer(new int[] { next, moves + 1 });
                }
            }
        }
        return -1;
    }

    public int[] getCoordinates(int pos, int n) {
        int r = (pos - 1) / n, c = (pos - 1) % n;
        int row = n - 1 - r;
        int col = (r % 2 == 0) ? c : (n - 1 - c);
        return new int[] { row, col };
    }
}
