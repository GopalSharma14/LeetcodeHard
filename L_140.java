class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        
        Map<String,List<String>> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        if(wordDict.contains(s))
            result.add(s);
        
        for(int i=1;i<s.length();i++){
            String left = s.substring(0,i);
            if(wordDict.contains(left)){
                List<String> sub = wordBreak(s.substring(i),wordDict);
                for(String sen : sub){
                    result.add(left+" "+ sen);
                }
            }
        }
        map.put(s,result);
        return result;
    }
}