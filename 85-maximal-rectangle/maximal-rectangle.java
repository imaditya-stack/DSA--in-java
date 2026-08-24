class Solution {
    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;   
        int[][] pSum = new int[n][m];
        int maxArea = 0;

        for (int j=0 ; j<m ; j++){
            int sum = 0;
            for(int i=0 ; i<n ; i++){
                if(matrix[i][j] == '1')
                sum ++;
                else{
                    sum = 0;
                }
                pSum[i][j] = sum;
            }
        }

        for (int i=0 ; i<n ; i++){
            maxArea = Math.max(maxArea , largestRectangleArea(pSum[i]));
        } 

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int maxArea = 0;
        Stack<Integer> st = new Stack<>();

        for(int i=0 ; i<n ; i++){

            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                int element = st.pop();
                int nse = i;
                int pse = st.empty() ? -1 : st.peek();

                int area = heights[element] * (nse - pse - 1);
                maxArea = Math.max(maxArea , area);
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int nse = n;
            int element = st.pop();

            int pse = st.isEmpty() ? -1 : st.peek();

            int area = heights[element] * (nse - pse - 1);
            maxArea = Math.max(maxArea , area);
        }

        return maxArea;
    }

}