package me.xfly.leetcode;

import java.util.HashMap;

public class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    String word = null;
    public TrieNode() {}
}
