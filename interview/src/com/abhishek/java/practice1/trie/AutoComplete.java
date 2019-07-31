package com.abhishek.java.practice1.trie;

import java.util.LinkedList;
import java.util.List;

public class AutoComplete {
	Node root;
	public void insertWords(String[] words)
	{
		root = new Node("");
		for(String s: words)
		{
			insertAWord(s);
		}	
	}
	private void insertAWord(String word) {
		Node currentNode = root;
		for(int i=0;i<word.length();i++)
		{
			char ch = word.charAt(i);
			if(!currentNode.children.containsKey(ch))
			{
				currentNode.children.put(ch, new Node(word.substring(0,i+1)));
			}		
			currentNode = currentNode.children.get(ch);
		}
	currentNode.setWord(true);
		
		System.out.println(currentNode);
	}
	
	public List<String> getWordsForPrefix(String prefix)
	{
		List<String> results = new LinkedList<>();
		Node currentNode = root;		
		for(char ch: prefix.toCharArray())
		{
			//If the current Node contains the character move to the next Node
			//else return false
			if(currentNode.children.containsKey(ch))
			{
				currentNode = currentNode.children.get(ch);
			}
			else
			{
				return results;
			}			
		}
		findAllChildWords(currentNode, results);
		return results;
	}
	
	private void findAllChildWords(Node currentNode, List<String> results) {
		if(currentNode.isWord())
		{
			results.add(currentNode.getPrefix());
		}
		
		for(Character ch: currentNode.children.keySet())
		{
			findAllChildWords(currentNode.children.get(ch),results);
		}		
	}
	public boolean find(String word) {
	    Node currentNode = root;
	    for (int i = 0; i < word.length(); i++) {
	        char ch = word.charAt(i);
	        Node nextNode = currentNode.children.get(ch);
	        if (nextNode == null) {
	            return false;
	        }
	        currentNode = nextNode;
	    }
	    return currentNode.isWord();
	}
	
	public void delete(String word) {
	    delete(root, word, 0);
	}
	 
	private boolean delete(Node current, String word, int index) {
	    if (index == word.length()) {
	        if (!current.isWord()) {
	            return false;
	        }
	        current.setWord(false);
	        return current.children.isEmpty();
	    }
	    char ch = word.charAt(index);
	    Node node = current.children.get(ch);
	    if (node == null) {
	        return false;
	    }
	    boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isWord();
	 
	    if (shouldDeleteCurrentNode) {
	        current.children.remove(ch);
	        return current.children.isEmpty();
	    }
	    return false;
	}

}
