class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++) {

            while(!st.isEmpty() && heights[st.peek()] > heights[i]) {
                int element = st.pop();
                int nse = i;
                int pse;
                if(st.isEmpty()) {
                    pse = -1;
                } else {
                    pse = st.peek();
                }

                int area = heights[element] * (nse - pse - 1);

                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        while(!st.isEmpty()) {
            int nse = n;
            int element = st.pop();
            int pse;

            if(st.isEmpty()) {
                pse = -1;
            } else {
                pse = st.peek();
            }

            int area = heights[element] * (nse - pse - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}