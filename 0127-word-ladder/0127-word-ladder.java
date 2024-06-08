class Solution {
    
    static class Pair{
        String first;
        int second;
        public Pair(String _first,int _second){
            this.first = _first;
            this.second = _second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        HashSet<String> set = new HashSet<>();
        for(String it : wordList){
            set.add(it);
        }
        set.remove(beginWord);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord,1));
        
        while(!queue.isEmpty()){
            Pair pair = queue.peek();
            String word = pair.first;
            int steps = pair.second;
            queue.remove();
            
            if(word.equals(endWord) == true){
                return steps;
            }
            
            char[] wordArray = word.toCharArray();
            for(int i = 0; i<wordArray.length; i++){
                char original = wordArray[i];
                for(char ch ='a'; ch<='z'; ch++){
                    if(original == ch){
                        continue;
                    }
                    wordArray[i] = ch;
                    String newWord = String.valueOf(wordArray);
                    if(set.contains(newWord)){
                        queue.offer(new Pair(newWord,steps+1));
                        set.remove(newWord);
                    }
                }
                wordArray[i] = original;
            }
        }
        return 0;
    }
    
}