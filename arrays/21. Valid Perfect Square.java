class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1) return true;
        int low=1,high=num;
        while(low<=high){
            long mid=(low+high)/2;
            long squared=mid*mid;
            if(squared==num){
                return true;
            }
            else if(squared<num){
                low=(int)mid+1;
            }
            else{
                high=(int)mid-1;
            }
        }
        return false;
    }
}
