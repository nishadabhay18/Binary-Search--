class Solution {
    // TC-> O(log n) SC-> O(1)
    public int findMin(int[] arr) {
        int st = 0, end = arr.length-1;
        while(st < end) {
            int mid = st + (end - st) / 2;
            if (arr[mid] > arr[end]) st = mid + 1;
            else if (arr[mid] < arr[end]) end = mid;
            else end--; // shrink if equal, avoid ambiguity
        }
        return arr[st];
    }
}