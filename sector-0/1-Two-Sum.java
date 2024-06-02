class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> targets = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int required = target - nums[i];
            if (targets.containsKey(required)) {
                return new int[] { targets.get(required), i };
            }

            targets.put(nums[i], i);
        }
        return new int[] {};
    }
}