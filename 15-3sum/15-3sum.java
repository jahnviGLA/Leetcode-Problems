// Last updated: 1/19/2026, 1:17:56 PM
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1, right = n - 1;

            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums1));
        int[] nums2 = {0, 1, 1};
        System.out.println(solution.threeSum(nums2));
        int[] nums3 = {0, 0, 0};
        System.out.println(solution.threeSum(nums3));
        
    }
}