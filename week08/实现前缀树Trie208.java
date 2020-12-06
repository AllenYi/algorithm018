package com.arithmeticHomeWorkEight;

public class Trie {
    Trie[] tries = new Trie[26];
    boolean isEnd=false;

    Trie(){
    }

    public void insert(String word){
        Trie trie = this;
        for (char c : word.toCharArray()){
            if (trie.tries[c - 'a'] ==null){
                trie.tries[c - 'a' ] = new Trie();
            }
            trie = trie.tries[c - 'a'];
        }
        trie.isEnd = true;


    }

    public boolean  search(String word){
        Trie trie = this;
        for (char c : word.toCharArray()){
            if (trie.tries[c - 'a']==null)return false;
            trie = trie.tries[c-'a'];
        }
        return  trie.isEnd;
    }

    public boolean startsWith(String prefix){
        Trie trie=this;
        for (char c : prefix.toCharArray()){
            if (trie.tries[c - 'a']==null) return false;
            trie = trie.tries[c - 'a'];
        }
        return true;
    }
}
