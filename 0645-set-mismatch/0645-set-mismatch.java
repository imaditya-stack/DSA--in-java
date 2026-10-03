class Solution {
    public int[] findErrorNums(int[] nums) {
        long expectedSum = 0;
        long actualSum = 0;

        for(int num : nums){
            actualSum += num;
        }
        for(int i = 1; i<=nums.length ; i++){
            expectedSum += i;
        }

        long difference = actualSum - expectedSum;

         long expectedSquareSum = 0;

        for (int i = 1; i <= nums.length; i++) {
            expectedSquareSum += (long) i * i;
        }

        long actualSquareSum = 0;

        for (int num : nums) {
            actualSquareSum += (long) num * num;
        }

        long squareDifference =
                actualSquareSum - expectedSquareSum;

        long sum = squareDifference / difference;

        long duplicate = (difference + sum) / 2;
        long missing = (sum - difference) / 2;

        return new int[] {
            (int) duplicate,
            (int) missing
        };

    }
}