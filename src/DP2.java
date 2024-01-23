import java.util.Arrays;

// frog jump - 1
public class DP2 {
  public static int jumper(int n , int[] arr, int[] dp){   // memoization method
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

    public static void main(String[] args) {
        int[] arr = {10,20,30,10,20};
        int[] dp = new int[arr.length+1];
        Arrays.fill(dp,-1);
        System.out.println(jumper(arr.length-1,arr,dp));
    }
}
