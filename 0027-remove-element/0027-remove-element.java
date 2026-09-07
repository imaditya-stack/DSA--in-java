class Solution {
    public int removeElement(int[] nums, int val) {
        
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        for(int i=0; i<n ; i++){
            if(nums[i] != val){
                res.add(nums[i]);
                
            }
        }
        for(int j=0 ; j<res.size() ; j++){
            nums[j] = res.get(j);
        }

        return res.size();
    }
}