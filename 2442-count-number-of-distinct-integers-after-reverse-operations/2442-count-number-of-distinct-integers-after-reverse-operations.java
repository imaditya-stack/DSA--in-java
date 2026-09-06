class Solution {
    public int countDistinctIntegers(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int n = nums.length;
        for(int i = 0 ; i<n ; i++){
            set.add(nums[i]);
            int rev = 0;
            while(nums[i] > 0){
                int rem = nums[i] % 10;
                rev = (rev * 10) +rem;
                nums[i] /= 10;
            }
            set.add(rev);
        }

        return set.size();

    }
}




// class Solution {
//     public int countDistinctIntegers(int[] nums) {
        
//         int[] res = new int[2*nums.length];

//         for(int i = 0 ; i< nums.length ; i++){
//             res[i] = nums[i];
//         }

//         for(int i = nums.length ; i< res.length ; i++){
//             int num = nums[i - nums.length];
//             int rev = 0;
//             while(num > 0){
//                 int rem = num %10;
//                 rev = (rev * 10) +rem;
//                 num /=10;
//             }
//             res[i] = rev;
//         }
//         HashSet<Integer> set = new HashSet<>();
//         for(int j = 0 ; j< res.length ; j++){
//             set.add(res[j]);
//         }

//         return set.size();

//     }
// }