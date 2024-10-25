class Solution {
    public List<String> removeSubfolders(String[] folder) {
          Arrays.sort(folder, String.CASE_INSENSITIVE_ORDER);
          ArrayList<String>a1=new ArrayList<>();
          a1.add(folder[0]);
          for(int i=1;i<folder.length;i++){
            String last=a1.get(a1.size()-1);
            last+='/';
            if(!folder[i].startsWith(last)){
                a1.add(folder[i]);
            }
          }
          return a1;
    }
}
