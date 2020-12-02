class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        return findInterleave(s1, s2, s3, -1, -1, -1);
    }
    
    private boolean findInterleave(
                   String s1, String s2, String s3, 
                   int s1Index, int s2Index, 
                   int s3Index) {
        boolean s1res = false, s2res = false;
        if(s1.length() == (s1Index + 1) 
           && s2.length() == (s2Index + 1) 
           && s1Index + s2Index == (s3Index - 1)){
            return true;
        }
        
        if((s1Index + 1) < s1.length() &&  
           s1.charAt(s1Index+1) == s3.charAt(s3Index + 1)){
            s1res = findInterleave(s1, s2, s3, 
                                   ++s1Index, s2Index, ++s3Index);
            if(!s1res) {
                s1Index--;
                s3Index--;
            }
        } 
        if(!s1res && (s2Index+1) < s2.length() && 
                  s2.charAt(s2Index+1) == s3.charAt(s3Index + 1)) {
            s2res = findInterleave(s1, s2, s3, 
                                   s1Index, ++s2Index, ++s3Index);
            if(!s2res) {
                s2Index--;
                s3Index--;
            }
        }
        return s1res || s2res;
    }
}