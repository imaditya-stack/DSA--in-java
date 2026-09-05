class Solution {
    public int reverse(int x) {
       int num = x;
       long max =(long) Math.pow(2,31) - 1;
       long min = -(long)(Math.pow(2,31));

       long result = 0;
       if(num > 0){
            while(num > 0){
            int rem = num% 10;
            result = (result * 10) + rem;
            num /= 10;
            }
       }

       else{
          num = num * -1;
          while(num > 0){
                int rem = num% 10;
                result = (result * 10) + rem;
                num /= 10;
          }
          result  = result *-1;     
       }

       if(result > max || result < min){
        return 0;
       }
       else{
        return (int)result;
       }
    }
}