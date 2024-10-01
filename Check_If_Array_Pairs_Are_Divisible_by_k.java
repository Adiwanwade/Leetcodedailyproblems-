class Solution {
    public boolean canArrange(int[] arr, int k) {
        int []map=new int[k];
        for(int i:arr){
        int rem=(((i%k)+k)%k);
        map[rem]++;
        }
        if(map[0]%2!=0){
            return false;
        }
        for(int rem=1;rem<=k/2;rem++){
            if(map[rem]!=map[k-rem]){
                return false;
            }
        }
        return true;
    }
}
