import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP3 {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        int[] dp = new int[nums.size()+1];
        Arrays.fill(dp,-1);
        int n = nums.size();
        //return getMaxSum(nums,n-1,dp);
        return getMaxSum2(nums,n-1);
    }

    public static int getMaxSum(ArrayList<Integer> nums , int n , int[] dp)
    {
        if(n==0) return nums.get(n);
        if(n<0) return 0;
        if(dp[n]!=-1) return dp[n];

        int pick =nums.get(n)+getMaxSum(nums,n-2,dp);
        int not_pick = getMaxSum(nums,n-1,dp);
        dp[n]=Math.max(pick,not_pick);

        return Math.max(pick,not_pick);
    }

    public static int getMaxSum2(ArrayList<Integer> nums , int n)
    {
        int prev = nums.get(0);
        int prev2 = 0;
        int curr = 0;
        for(int i=1;i<n;i++)
        {
            int take = nums.get(i);
            if(i>1){
                take+= prev2;
            }
            int dont_take = prev;
            curr=Math.max(take,dont_take);
            prev2= prev;
            prev=curr;
        }
        return prev;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(List.of(1, 2, 3, 1, 3, 5, 8, 1, 9));
        System.out.println(maximumNonAdjacentSum(arr));
    }
}

// vid - 5