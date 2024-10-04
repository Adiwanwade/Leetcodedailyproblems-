class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // int[]arrcopy=new int[arr.length];
//         for(int i=0;i<arr.length;i++){
// arrcopy[i]=arr[i];
//         }
int []arrcopy=arr.clone();
        Arrays.sort(arrcopy);
        int count=1;
        // for(int i=0;i<arr.length;i++){
        //     int j=0;
        //     while(arrcopy[j]<arr[i]){
        //         count++;
        //         j++;
        //     }
        //     arr[i]=count+1;
        //     count=0;
        // }

        HashMap<Integer,Integer>h1=new HashMap<>();
for(int i:arrcopy){
    if(!h1.containsKey(i)){
        h1.put(i,count);
    count++;
    }
}
for(int i=0;i<arr.length;i++){
    arr[i]=h1.get(arr[i]);
}
        return arr;
    }
}
