class Solution {
    public void bfs(int stN,int[]edges,int[]d){
        int n=edges.length;
        Queue<Integer>q=new LinkedList<>();
        q.offer(stN);
        Boolean[]visit =new Boolean[n];
        Arrays.fill(visit,Boolean.FALSE);
        d[stN]=0;
        while(!q.isEmpty()){
            int node=q.poll();
            if(visit[node]){
                continue;
            }
            visit[node]=true;
            int nb=edges[node];
            if(nb!=-1&&!visit[nb]){
                d[nb]=1+d[node];
                q.offer(nb);
            }
        }
    }
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int[]d1=new int[n],d2=new int[n];
        Arrays.fill(d1,Integer.MAX_VALUE);
        Arrays.fill(d2,Integer.MAX_VALUE);
        bfs(node1,edges,d1);
        bfs(node2,edges,d2);
        int minD=-1,minT=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(minT>Math.max(d1[i],d2[i])){
                minD=i;
                minT=Math.max(d1[i],d2[i]);
            }
        }
        return minD;
            }
}
