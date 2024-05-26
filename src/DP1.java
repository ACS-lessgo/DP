// fibonacci dp series - 1

import java.util.Arrays;

public class DP1 {
    // recursive approach
    public static int fibonacci(int n)
    {
        if(n==1 || n==0)
        {
            return n;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    // TODO --> implement new approach

    // dp-1 recursive approach
    public static int fibonacci1(int n , int[] dp)
    {
        if(n==1 || n==0) return n;

        if(dp[n]!=-1)  return dp[n];

        return dp[n] = fibonacci1(n-1,dp) + fibonacci1(n-2,dp);

    }

    // dp-2 space optimized iterative approach
    public static int fibonacci2(int n) {
        int prev2 = 0;
        int prev1 = 1;
        int curr = 0;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }


    public static void main(String[] args) {

        // recursion
        int result = fibonacci(5);
        System.out.println("Recursion --> "+result);

        //dp-1
        int n = 5;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int result1 = fibonacci1(n,dp);
        System.out.println("DP1 --> "+result1);

        // dp-2 space iterative dp
        System.out.println("DP2 --> "+fibonacci2(5));
    }
}


