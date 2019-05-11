enum Index {
    GOOD, BAD, UNKNOWN
}
class Solution {
    Index[] memo;
    
/*
* Given an array of non-negative integers, 
* you are initially positioned at the first index of the array.
* Each element in the array represents your maximum jump length at that position.
* Determine if you are able to reach the last index.
*/
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        
        // initialize last element to GOOD, and others to UNKNOWN
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length-1) {
                memo[i] = Index.GOOD;
            } else {
                memo[i] = Index.UNKNOWN;
            }
        }
 
        boolean soln = canJumpFromPos(0, nums); 
        // printer(nums, memo);
        return soln;
    }
    
    public boolean canJumpFromPos(int pos, int[] nums) {
        // System.out.println(pos);
        // Base case
        if (memo[pos] != Index.UNKNOWN) {
            if (memo[pos] == Index.GOOD) {
                return true;
            }
            return false;
        }
        
        // Else, memo for pos is UNKNOWN; must fill it
        int counter = nums[pos];
        while (counter > 0) {
            int indexToCheck = pos + counter;
            if (indexToCheck < nums.length) {
                if (canJumpFromPos(indexToCheck, nums)) {
                    memo[pos] = Index.GOOD;
                    return true;
                }
            }
            counter--;
        }
        
        memo[pos] = Index.BAD;
        return false;
    }
    
    // For debugging
    public void printer(int[] nums, Index[] memo) {
        for (int i = 0; i < nums.length; i++) {
             System.out.println(nums[i] + " = " + memo[i]);
        }
    }
}
