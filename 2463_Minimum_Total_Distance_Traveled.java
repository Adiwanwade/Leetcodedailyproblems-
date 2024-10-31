class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(x,y)->Integer.compare(x[0],y[0]));
long[][]memo = new long[robot.size()][factory.length];
        return dfs(0, 0,robot,factory,memo);
    }
    public long dfs(int robotIndex, int factoryIndex,List<Integer> robots, int[][] factories,long[][]memo) {
        
        if (robotIndex == robots.size()) {
            return 0;
        }
        
        if (factoryIndex == factories.length) {
            return Long.MAX_VALUE / 1000; 
            }
       
        if (memo[robotIndex][factoryIndex] != 0) {
            return memo[robotIndex][factoryIndex];
        }
      
        
        long ans = dfs(robotIndex, factoryIndex + 1,robots,factories,memo); 
      
        long distanceSum = 0; 
        for (int k = 0; k < factories[factoryIndex][1]; ++k) {
            if (robotIndex + k == robots.size()) {
                break; 
                }
            
            distanceSum += Math.abs(robots.get(robotIndex + k) - factories[factoryIndex][0]);
            ans = Math.min(ans, distanceSum + dfs(robotIndex + k + 1, factoryIndex + 1,robots,factories,memo));
        }
        memo[robotIndex][factoryIndex] = ans; 
      
        return ans;
    }
}
