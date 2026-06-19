class Solution {
    // TC-> O(n log n + n log end) SC-> O(1)
    public static boolean check(int[]arr,int k, int mid){
        int n = arr.length;
        int firstCowPos = arr[0], countCow = 1;
        for(int i=1; i<n; i++){
            if((arr[i] - firstCowPos) >= mid){
                firstCowPos = arr[i];
                countCow++;
            }
        }
        return countCow >= k;
    }
    public static int aggressiveCows(int[] arr, int k) {
        int n = arr.length;
        Arrays.sort(arr);
        int st = 0, end = arr[n-1]-arr[0], ans = 0;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(check(arr, k, mid) == true){
                ans = mid;
                st = mid+1;
            }else end = mid-1;
        }
        return ans;
    }
}