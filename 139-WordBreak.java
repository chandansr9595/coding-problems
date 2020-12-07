class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean dp[] = new boolean[n + 1];
        dp[0] = true;
        int maxLen = 0;
        for(String word: wordDict){
            maxLen = Math.max(word.length(), maxLen);
        }
        for(int i =1; i<= n;i++){
            for(int j=0; j<i ; j++){
                if((i-j) > maxLen)
                    continue;
                if(dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}