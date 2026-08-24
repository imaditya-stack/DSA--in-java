class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        Stack<Character> st = new Stack<>();

        for(int i=0; i<n ; i++){
            char ch = num.charAt(i);
            while(!st.isEmpty() && k>0 && st.peek() > ch){
                st.pop();
                k--;
            }
            st.push(ch);
        }

        while(k>0){
            st.pop();
            k--;
        }

        StringBuilder ans = new StringBuilder();
         while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        ans.reverse();

        int i = 0;
        while(i < ans.length() && ans.charAt(i)=='0'){
            i++;
        }
        ans = new StringBuilder(ans.substring(i));
        
        if (ans.length() == 0) {
            return "0";
        }

        return ans.toString();

    }
}