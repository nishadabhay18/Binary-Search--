class Solution {
    // TC-> O(n·log ans)
    public int maximumCandies(int[] candies,long k){
        int n = candies.length;
        long total = 0;
        int ans = 0;
        for(int i=0; i<n; i++){
            total += candies[i];
            ans = Math.max(ans, candies[i]);
        }
        if(total < k) return 0;
        int st = 1, end = ans, result = 0;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(canDistribute(candies, k, mid)){
                result = mid;
                st = mid+1;
            }else end = mid-1;
        }
        return result;
    }
    public boolean canDistribute(int[] candies,long k,int mid){
        int n = candies.length;
        long count = 0;
        for(int c : candies){
            count += (c / mid);
            if(count >= k) return true;
        }
        return false;
    }
}