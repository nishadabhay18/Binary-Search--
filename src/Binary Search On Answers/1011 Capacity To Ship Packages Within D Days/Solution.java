class Solution {
    // TC-> O(nlog end) SC-> O(1)
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int st = 0, end = 0;
        for(int i=0; i<n; i++){
            end += weights[i];
        }
        int ans = 0;
        while(st <= end){
            int mid = st+(end-st)/2;
            if(canDistributeWeights(mid, weights, days)){
                ans = mid;
                end = mid-1;
            }
            else st = mid+1;
        }
        return ans;
    }
    public boolean canDistributeWeights(int val, int[] weights, int days){
        int n = weights.length;
        int countDays = 1, sum = 0;
        for(int data: weights){
            if(data+sum <= val) sum += data;
            else{
                sum = data;
                countDays++;
                if(countDays > days) return false;
            }
        }
        return true;
    }
}