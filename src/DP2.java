import java.util.Arrays;

// frog jump - 1
public class DP2 {
  public static int jumper(int n , int[] arr, int[] dp)  // memoization method
  {
      if(n==0) return 0;
      if(dp[n]!=-1) return dp[n];
      int jump1 = jumper(n-1,arr,dp)+Math.abs(arr[n]-arr[n-1]);
      int jump2 = Integer.MAX_VALUE;
      if(n>1)
      {
          jump2 = jumper(n-2, arr,dp)+Math.abs(arr[n]-arr[n-2]);
      }
      dp[n]=Math.min(jump1,jump2);
      return Math.min(jump1,jump2);
  }

  public static int jumper2(int n,int[] arr,int[] dp,int k)   // tabulation method
  {
      if(n==0) return 0;
      if(dp[n]!=-1) return dp[n];
      int min_steps = Integer.MAX_VALUE;
      for(int i=0;i<n;i++)
      {
          for(int j =0;j<k;j++)
          {
              if(i-j>=0)
              {
                dp[n]=dp[i-j]+Math.abs(arr[n]-arr[n-j]);
                min_steps=Math.min(dp[n],min_steps);
              }
          }
      }
      return dp[n-1];
  }

  public static void main(String[] args) {
        int[] arr = {10,20,10,20,10};
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        System.out.println(jumper(arr.length-1,arr,dp));
      System.out.println(jumper2(arr.length-1,arr,dp,2));
  }
}
