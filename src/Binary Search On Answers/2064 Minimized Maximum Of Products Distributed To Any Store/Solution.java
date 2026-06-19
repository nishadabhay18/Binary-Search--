class Solution {
    // TC-> O(m·log end) SC-> O(1)
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;
        int st = 1, end = 0;
        for(int i=0; i<m; i++) end = Math.max(end, quantities[i]);
        int ans = end;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(isPossible(mid, n, quantities)){
                ans = mid;
                end = mid-1;
            }else st = mid+1;
        }
        return ans;
    }
    public boolean isPossible(int mid, int n, int[] quantities){
        int stores = 0;
        for(int curr : quantities){
            stores += (curr + mid - 1) / mid;
            if(stores > n) return false;
        }
        return true;
    }
}