class Solution {
    // TC-> O(n) SC-> O(1)
    public boolean searchMatrix(int[][] arr, int target) {
        int m = arr.length, n = arr[0].length;
        int st = 0, end = m*n-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            int midElt = arr[mid / n][mid % n];
            if(midElt == target) return true;
            else if(midElt > target) end = mid-1;
            else st = mid+1;
        }
        return false;
    }
}