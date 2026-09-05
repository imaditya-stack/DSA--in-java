class Solution {
    public int alternateDigitSum(int n) {

        String s = Integer.toString(n);
        int length = s.length();
        int sum = 0;
        int sign = 1;

        for(int i= 0 ; i<length ; i++){
            int digit = s.charAt(i) - '0';
            sum += digit * sign;
            sign *= -1;

        }

        return sum;

    }
}