class Solution {
    // TC-> O(n.log max) SC-> O(1)
    public int minEatingSpeed(int[] piles, int hours) {
        int n = piles.length;
        int min = 1;
        int max = 0;
        for (int pile : piles) max = Math.max(max, pile);
        while(min < max) {
            int mid = (min+max)/2;
            int time = 0;
            for (int pile : piles) {
                time += (pile + mid - 1) / mid;
            }
            if (time > hours) min = mid+1;
            else max = mid;
        }
        return min;
    }
}
