class Solution {
    // TC-> O(log n) SC-> O(1)
    public int searchInsert(int[] arr, int target) {
        int n = arr.length;
        int st = 0, end = n-1;
        while (st <= end){
            int mid = st+(end-st)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) end = mid-1;
            else st = mid+1;
        }
        return st;
    }
}
