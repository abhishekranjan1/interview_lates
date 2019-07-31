package com.abhishek.java.trie    ;

import java.util.LinkedList;
import java.util.List;

public class AutoComplete {
	private Node root;
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
		for(int i=0;i<word.length();i++) {
			char ch = word.charAt(i);			
			if(!currentNode.getChildren().containsKey(ch))
				{
					//If the Node does not exist we need to create it
					currentNode.getChildren().put(ch, new Node(word.substring(0,i+1)));
				}			
			//If we already have the Node we are going to the next one	
			currentNode = currentNode.getChildren().get(ch);
			if(i==word.length()-1) currentNode.setWord(true);
			}
		//currentNode.setWord(true);
		System.out.println(currentNode);
	}
	
	public List<String> getWordsForPrefix(String prefix)
	{
		List<String> results = new LinkedList<>();
		Node currentNode = root;
		
		for(char ch: prefix.toCharArray())
		{
			if(currentNode.getChildren().containsKey(ch))
			{
				currentNode = currentNode.getChildren().get(ch);
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
		
		for(Character ch: currentNode.getChildren().keySet())
		{
			findAllChildWords(currentNode.getChildren().get(ch),results);
		}		
	}
	public boolean find(String word) {
	    Node currentNode = root;
	    for (int i = 0; i < word.length(); i++) {
	        char ch = word.charAt(i);
	        Node nextNode = currentNode.getChildren().get(ch);
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
	        return current.getChildren().isEmpty();
	    }
	    char ch = word.charAt(index);
	    Node node = current.getChildren().get(ch);
	    if (node == null) {
	        return false;
	    }
	    boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isWord();
	 
	    if (shouldDeleteCurrentNode) {
	        current.getChildren().remove(ch);
	        return current.getChildren().isEmpty();
	    }
	    return false;
	}

}
