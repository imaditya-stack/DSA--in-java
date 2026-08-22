class Solution {
    public long subArrayRanges(int[] nums) {

        int n = nums.length;

        long minSum = 0;
        long maxSum = 0;

        Stack<Integer> st = new Stack<>();

        int[] preLess = new int[n];
        int[] nextLess = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }

            preLess[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }

            nextLess[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = 0; i < n; i++) {
            int left = i - preLess[i];
            int right = nextLess[i] - i;

            minSum += (long) right * left * nums[i];
        }

        int[] preMax = new int[n];
        int[] nextMax = new int[n];

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }

            preMax[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }

            nextMax[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = 0; i < n; i++) {
            int left = i - preMax[i];
            int right = nextMax[i] - i;

            maxSum += (long) right * left * nums[i];
        }

        return maxSum - minSum;
        
    }
}