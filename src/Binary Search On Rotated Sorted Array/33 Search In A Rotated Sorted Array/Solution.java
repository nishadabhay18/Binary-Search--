class Solution {
    // TC-> O(n) SC-> O(1)
    public int search(int[] arr, int target) {
        int n = arr.length;
        int st = 0, end = n-1, ans = -1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] < arr[end]){// mid to end is shorted
                if(arr[mid] < target && target <= arr[end]) st = mid+1;
                else end = mid-1;
            }else{// st to mid is shorted
                if(arr[mid] > target && arr[st] <= target) end = mid-1;
                else st = mid+1;
            }
        }
        return ans;
    }
}