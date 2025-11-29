package graph.o9GenericTransfermation;
import java.util.*;
class pair{
    String name;
    int level;
    pair(String name,int level){
        this.name = name;
        this.level = level;
    }
}
class o9WordLadderBFS {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> hs = new HashSet<>();
        Queue<pair> q = new LinkedList<>();
        for(String name : wordList){
            hs.add(name);
        }
        q.add(new pair(beginWord,1));
        hs.remove(beginWord);
        while(!q.isEmpty()){
            pair p = q.poll();
            String name = p.name;
            int level = p.level;
            if(name.equals(endWord)){
                return level;
            }
            for(int i = 0; i < name.length(); i++){
                for(char ch = 'a'; ch <= 'z'; ch++){
                    char[] charArray = name.toCharArray();
                    charArray[i] = ch;
                    String newName = new String(charArray);
                    if(hs.contains(newName)){
                        hs.remove(newName);
                        q.add(new pair(newName,level+1));
                    }
                }
            }
        }
        return 0;
    }
}