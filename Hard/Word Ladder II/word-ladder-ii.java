//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class comp implements Comparator<ArrayList<String>> {
    // override the compare() method
    public int compare(ArrayList<String> a, ArrayList<String> b)
    {
        String x = "";
        String y = "";
        for(int i=0; i<a.size(); i++)
            x += a.get(i);
        for(int i=0; i<b.size(); i++)
            y += b.get(i);
        return x.compareTo(y);
    }
}

public class GFG
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
            ArrayList<ArrayList<String>> ans = obj.findSequences(startWord, targetWord, wordList);
            if(ans.size()==0)
                System.out.println(-1);
            else
            {
                Collections.sort(ans, new comp());
                for(int i=0; i<ans.size(); i++)
                {
                    for(int j=0; j<ans.get(i).size(); j++)
                    {
                        System.out.print(ans.get(i).get(j) + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(String it : wordList){
            set.add(it);
        }
        Queue<ArrayList<String>> queue = new LinkedList<>();
        ArrayList<String> ls = new ArrayList<>();
        ls.add(startWord);
        queue.offer(ls);
        ArrayList<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(startWord);
        int level = 0;
        
        while(!queue.isEmpty()){
            ArrayList<String> vec = queue.peek();
            queue.remove();
            
            // erase all the word that has been
            // used on the prevous level to transform
            if(vec.size() > level){
                level++;
                for(String it : usedOnLevel){
                    set.remove(it);
                }
            }
            
            String word = vec.get(vec.size() - 1);
            
            if(word.equals(targetWord) == true){
                if(ans.size() == 0){
                    ans.add(vec);
                }else if(ans.get(0).size() == vec.size()){
                    ans.add(vec);
                }
            }
            char[] wordArray = word.toCharArray();
            for(int i = 0; i<wordArray.length; i++){
                char original = wordArray[i];
                for(char ch = 'a'; ch<='z'; ch++){
                    if(original == ch){
                        continue;
                    }
                    wordArray[i] = ch;
                    String newWord = String.valueOf(wordArray);
                    
                    if(set.contains(newWord)){
                        vec.add(newWord);
                        
                        ArrayList<String> temp = new ArrayList<>(vec);
                        queue.add(temp);
                        
                        usedOnLevel.add(newWord);
                        vec.remove(vec.size()-1);
                    }
                }
                wordArray[i] = original;
            }
        }
        
        return ans;
    }
}