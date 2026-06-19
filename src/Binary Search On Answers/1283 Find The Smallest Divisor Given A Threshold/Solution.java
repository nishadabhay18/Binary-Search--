class Solution {
    // TC-> O(n.log end) SC-> O(1)
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int st = 1, end = 0;
        for(int i=0; i<n; i++){
            end = Math.max(end, nums[i]);
        }
        int ans = end;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(isPossible(mid, nums, threshold)){
                ans = mid;
                end = mid-1;
            }else st = mid+1;
        }
        return ans;
    }
    public boolean isPossible(int mid, int[] nums,int threshold){
        int n = nums.length;
        int val = 0;
        for(int i=0; i<n; i++){
            if(nums[i] < mid) val++;
            else{
                int midd = nums[i]/mid;
                if(nums[i] % mid != 0) midd++;
                val += midd;
            }
        }
        if(val <= threshold) return true;
        return false;
    }
}