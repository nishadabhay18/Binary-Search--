class Solution {
    // TC-> O(n·log 1e7) SC-> O(1)
    public int minSpeedOnTime(int[] dist, double hour) {
        int n = dist.length;
        if (hour < n-1) return -1;
        int st = 1, end = (int) 1e7, ans = -1;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(isTimePossible(mid, dist, hour)){
                ans = mid;
                end = mid-1;
            }else st = mid+1;
        }
        return ans;
    }
    public boolean isTimePossible(int mid, int[] dist, double hour){
        int n = dist.length;
        double val = 0;
        for(int i=0; i<n; i++){
            if(i != n-1) val += Math.ceil((double) dist[i]/mid);
            else val += (double) dist[i]/mid;
        }
        return (val <= hour);
    }
}