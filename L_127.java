class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
       
        HashSet<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord))
            return 0;
        
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level=1;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0;i<size;i++){
                String currWord = queue.poll();
                char[] wordArray = currWord.toCharArray();
                for(int j=0;j<wordArray.length;j++){
                    char original_Char = wordArray[j];
                    for(char c='a';c<='z';c++){       
                        if(wordArray[j]==c)
                            continue;
                        wordArray[j]=c;
                        String newWord = String.valueOf(wordArray);
                        if(endWord.equals(newWord)) 
                            return level+1;;
                        if(set.contains(newWord)){
                            queue.offer(newWord);
                            set.remove(newWord);
                        }                   
                    }
                    wordArray[j]=original_Char;
                }
            }
            level++;
        }
return 0;      
    }
}