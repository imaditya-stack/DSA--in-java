class Solution {
    public boolean isSameAfterReversals(int num) {
         
         int number = num;
         int first = 0;

         while(number > 0){
            int rem1 = number % 10;
            first = (first * 10) + rem1;
            number /= 10;
         }

         int second = 0;

         while(first > 0){
            int rem2 = first % 10;
            second = (second * 10) + rem2;
            first /= 10;
         }


         return (num == second) ? true : false;

    }
}