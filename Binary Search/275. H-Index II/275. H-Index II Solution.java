class Solution {
    public int hIndex(int[] citations) {
        int l =0; 
        int n = citations.length;
        int r = n-1;
        int h_index=0;
        while(l <= r){
            int mid = (l + r)/ 2;
            if(citations[mid] >= n - mid){
                h_index = n-mid;
                r = mid-1;
            }else{
                l = mid +1;
            }
        }
        return h_index;
    }
    
}