//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    
    static class Pair{
        String first;
        int second;
        public Pair(String _first,int _second){
            this.first = _first;
            this.second = _second;
        }
    }
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        HashSet<String> set = new HashSet<>();
        for(String it : wordList){
            set.add(it);
        }
        set.remove(startWord);
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(startWord,1));
        
        while(!queue.isEmpty()){
            Pair pair = queue.peek();
            String word = pair.first;
            int step = pair.second;
            queue.poll();
            if(word.equals(targetWord) == true){
                return step;
            }
            char[] wordArray = word.toCharArray();
            for(int i = 0; i<wordArray.length; i++){
                char original = wordArray[i];
                for(char ch = 'a'; ch <= 'z'; ch++){
                    wordArray[i] = ch;
                    String newWord = new String(wordArray);
                    if(set.contains(newWord)){
                        queue.offer(new Pair(newWord,step+1));
                        set.remove(newWord);
                    }
                }
                wordArray[i] = original;
            }
        }
        
        
        return 0;
    }
}