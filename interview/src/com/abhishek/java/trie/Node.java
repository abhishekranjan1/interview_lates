package com.abhishek.java.trie;

import java.util.HashMap;
import java.util.Map;

public class Node {
	private String prefix;
	private boolean isWord;
	private Map<Character,Node> children;
	public String getPrefix() {
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	public boolean isWord() {
		return isWord;
	}
	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}
	public Map<Character, Node> getChildren() {
		return children;
	}
	public void setChildren(Map<Character, Node> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "Node [prefix=" + prefix + ", isWord=" + isWord + ", children=" + children + "]";
	}
	public Node(String prefix) {
		this.prefix = prefix;
		this.children = new HashMap<>();	
		this.isWord = false;
	}
}
