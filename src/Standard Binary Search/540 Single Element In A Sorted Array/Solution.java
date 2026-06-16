class Solution {
    // TC-> O(logn)
    public int singleNonDuplicate(int[] arr){
        int n = arr.length;
        int st = 0, end = n-1;
        while(st < end){
            int mid = st+(end-st)/2;
            if(mid % 2 == 1) mid--;
            if(arr[mid] == arr[mid+1]) st = mid+2;
            else end = mid-1;
        }
        return arr[st];
    }
}