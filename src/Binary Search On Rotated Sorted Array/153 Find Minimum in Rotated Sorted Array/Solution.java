class Solution {
    // TC-> O(log n) SC-> O(1)
    public int findMin(int[] arr) {
        int n = arr.length;
        int st = 0, end = n-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if((mid == 0 || arr[mid] < arr[mid-1]) && (mid == n-1 || arr[mid] < arr[mid+1])) return arr[mid];
            else if(arr[mid] > arr[end]) st = mid + 1;
            else end = mid - 1;
        }
        return -1;
    }
}