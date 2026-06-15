class Solution {
    // TC-> O(n) SC-> O(1)
    public int splitArray(int[] arr, int k) {
        int n = arr.length;
        if(k > n) return -1;
        int st = 0, end = 0;
        for (int i=0; i<n; i++) {
            st = Math.max(st, arr[i]); // largest book
            end += arr[i];             // total pages
        }
        int ans = -1;
        while(st <= end) {
            int mid = st + (end - st) / 2;
            if(isPossible(arr, mid, k)) {
                ans = mid;
                end = mid - 1;
            }else st = mid + 1;
        }
        return ans;
    }
    public boolean isPossible(int[] arr, int max, int k) {
        int curr = 0, count = 1;
        for(int pages : arr) {
            if(curr + pages <= max) curr += pages;
            else{
                count++;
                curr = pages;
                if(count > k) return false;
            }
        }
        return true;
    }
}