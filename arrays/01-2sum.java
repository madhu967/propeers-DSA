//brute force method 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i =0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }
}


//better approch 
class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n=nums.length;
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int i=0;i<n;i++){
        int complement=target-nums[i];
        if(map.containsKey(complement)){
            return new int[]{map.get(complement),i};
        }
        map.put(nums[i],i);
       }
       return new int[]{-1,-1};
    }
}

//Better Approch
class Solution {
    public int[] twoSum(int[] nums, int target) {
       int n=nums.length;
       int[][] numsWithIndex=new int[n][2];
       for(int i=0;i<n;i++){
        numsWithIndex[i][0]=nums[i];
        numsWithIndex[i][1]=i;
       }
       Arrays.sort(numsWithIndex , (a,b)->Integer.compare(a[0],b[0]));
       int left=0;int right=n-1;
       while(left<right){
        int sum=numsWithIndex[left][0]+numsWithIndex[right][0];
        if(sum==target){
                     return new int[] {
                    numsWithIndex[left][1],
                    numsWithIndex[right][1]
                };

        }
        else if(sum<target){
            left++;
        }
        else{
            right--;
        }
       }
       return new int[]{-1,-1};
    }
}
