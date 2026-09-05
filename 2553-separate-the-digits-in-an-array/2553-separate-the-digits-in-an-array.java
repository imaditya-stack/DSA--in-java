class Solution {
    public int[] separateDigits(int[] nums) {
        
        StringBuilder ans = new StringBuilder();

        for(int num : nums){
            ans.append(Integer.toString(num));
        }

        int[] result = new int[ans.length()];
        
        for(int i=0 ; i<ans.length(); i++){
            result[i] = ans.charAt(i)-'0';
        }

        return result;
    }
}