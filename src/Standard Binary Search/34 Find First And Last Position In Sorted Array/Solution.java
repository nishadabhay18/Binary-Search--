class Solution {
    // TC-> O(n) SC-> O(1)
    public int[] searchRange(int[] arr, int target) {
        int[] ans = {-1,-1};
        int st = search(arr, target, true);
        int end = search(arr, target, false);
        ans[0] = st;
        ans[1] = end;
        return ans;
    }
    public static int search(int []arr, int target,boolean startIndex ){
        int n = arr.length;
        int st = 0, end = n-1;
        int ans = -1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(arr[mid] > target) end = mid-1;
            else if(arr[mid] < target) st = mid+1;
            else{
                ans = mid;
                if(startIndex) end = mid-1;
                else st = mid+1;
            }
        }
        return ans;
    }
}