class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, candidates, target, new ArrayList<>(), 0, target);
        return res;
    }
    
    public void printTemp(List<Integer> temp, int target){
        for(int i=0; i<temp.size(); i++){
            System.out.print(temp.get(i) + " ");
        }
        System.out.println(", target = " + target);
    }
    
    public void helper(
        List<List<Integer>> res, 
        int[] candidates, 
        int target, 
        List<Integer> temp,
        int index,
        int actTarget
    ) {
        printTemp(temp, target);
        if(target <= 0){
            if(target == 0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        
        for(int i=index; i<candidates.length; i++){
            temp.add(candidates[i]);
            helper(res, candidates, target-candidates[i] , temp, i, actTarget);
            temp.remove(temp.size()-1);
        }
        
    }
}