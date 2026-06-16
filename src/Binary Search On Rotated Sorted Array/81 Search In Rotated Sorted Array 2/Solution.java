class Solution {
    // TC-> O(log n) SC-> O(1)
    public boolean search(int[]arr, int target) {
        int n = arr.length;
        int st = 0, end = n-1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(arr[mid] == target) return true;
            else if(arr[st] == arr[mid] && arr[mid] == arr[end]){
                st++;
                end--;
            }
            else if(arr[mid] <= arr[end]){
                if(target > arr[mid] && target <= arr[end]) st = mid+1;
                else end = mid-1;
            }else{
                if(target >= arr[st] && target < arr[mid]) end = mid-1;
                else st = mid+1;
            }
        }
        return false;
    }
}
