package com.abhishek.java.practice1.trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
	String prefix;
	Map<Character,Node> children;
	boolean isWord;
	@Override
	public String toString() {
		return "Node [prefix=" + prefix + ", children=" + children + ", isWord=" + isWord + "]";
	}
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public Map<Character, Node> getChildren() {
		return children;
	}
	public void setChildren(Map<Character, Node> children) {
		this.children = children;
	}
	public boolean isWord() {
		return isWord;
	}
	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	
	public Node(String prefix) {
		this.prefix = prefix;
		this.isWord = false;
		this.children = new HashMap<>();
		
	}

}
