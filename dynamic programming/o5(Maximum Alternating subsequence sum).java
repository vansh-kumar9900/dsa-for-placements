// class Solution {
//     public long maxAlternatingSum(int[] arr) {
//         int idx = 0;
//         long[][] dp = new long[arr.length][2]; // this is taken like how these variables are changing as first one is from 0 to n-1 so we took n length and second one is the state or flag where there can be two values only either zero or one so thats why we took 2 there.
//         for(long[] a : dp){
//             Arrays.fill(a,-1);
//         }
//         return solve(arr,0,0,dp);
//     }
    // public long solve(int[] arr,int idx, int flag, long[][] dp){
    //     if(idx == arr.length) return 0;
    //     if(dp[idx][flag] != -1){
    //         return dp[idx][flag];
    //     }
    //     long take;
    //     if(flag == 0){
    //         take = arr[idx] + solve(arr,idx+1,1,dp);
    //     }
    //     else{
    //         take = -arr[idx] + solve(arr,idx+1,0,dp);
    //     }
    //     long skip =  solve(arr,idx+1,flag,dp);
    //     return dp[idx][flag] = Math.max(skip,take);
    // }
// }


// memoization done above, tabulation below
// tabulation approach now down

// class Solution {
//     public long maxAlternatingSum(int[] arr) {
//         int idx = 0;
//         long[][] dp = new long[arr.length+1][2];
//         return solve(arr,0,0,dp);
//     }
//     public long solve(int[] arr,int idx, int flag, long[][] dp){
//         int n = arr.length;
//         dp[n][0] = 0;
//         dp[n][1] = 0;
//         for(int idx = n-1; idx >= 0; idx--){
//             for(int flag = 0;flag <= 1; flag++){
//                 long skip = dp[idx+1][flag];
//                 long take;
//                 if(flag == 0){
//                     take = arr[idx] + dp[idx+1][1];
//                 }
//                 else{
//                     take = -arr[idx] + dp[idx+1][0];
//                 }
//                 dp[idx][flag] = Math.max(take,skip);
//             }
//         }
//         return dp[0][0];
//     }
// }
