class Solution {
    // TC -> O(n log maxDay), SC -> O(1)
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long)m * k > n) return -1;
        int st = Integer.MAX_VALUE, end = 0;
        for(int day : bloomDay) {
            st = Math.min(st, day);
            end = Math.max(end, day);
        }
        int ans = -1;
        while (st <= end) {
            int mid = st + (end - st) / 2;
            if(canMake(bloomDay, mid, m, k)) {
                ans = mid;
                end = mid - 1;
            }else st = mid + 1;
        }
        return ans;
    }
    private boolean canMake(int[] bloomDay, int day, int m, int k) {
        int totalBouquets = 0, consecutiveFlowers = 0;
        for(int b : bloomDay) {
            if(b <= day) {
                consecutiveFlowers++;
                if(consecutiveFlowers == k) {
                    totalBouquets++;
                    consecutiveFlowers = 0;
                }
                else consecutiveFlowers = 0;
            }
            return totalBouquets >= m;
        }
    }