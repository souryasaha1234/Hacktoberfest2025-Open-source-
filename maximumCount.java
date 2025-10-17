class Solution {
    private int binSearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ind = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                ind = mid;
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }
        return ind;
    }

    public int maximumCount(int[] nums) {
        int n = nums.length;
        if (nums[0] == 0 && nums[n - 1] == 0) {
            return 0;
        }
        if ((nums[0] > 0 && nums[n - 1] > 0) || (nums[0] < 0 && nums[n - 1] < 0)) {
            return n;
        }
        int cntNeg = binSearch(nums, 0);
        // System.out.println(cntNeg);
        int x = binSearch(nums, 1);
        // System.out.println(x);
        int cntPos = n - (x == -1 ? n : x);
        // System.out.println(cntPos);

        return Math.max(cntNeg, cntPos);
    }
}
