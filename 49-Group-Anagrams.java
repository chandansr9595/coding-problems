class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groupedAnagrams = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for(String current: strs){
            char[] charArray = current.toCharArray();
            Arrays.sort(charArray);
            String sortedCurrent = new String(charArray);
            if(!map.containsKey(sortedCurrent)) {
                map.put(sortedCurrent, new ArrayList<>());
            }
            map.get(sortedCurrent).add(current);
        }
        groupedAnagrams.addAll(map.values());
        return groupedAnagrams;
    }
}