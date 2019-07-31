package com.abhishek.java.trie;

import java.util.List;

public class TrieClient {
	public static void main(String[] args)
	{
		String[] words = {"ABA","ARA","RAN","BTA","ABBA","ABBBBBBA"};
		AutoComplete obj = new AutoComplete();	
		obj.insertWords(words);
		List<String> results = obj.getWordsForPrefix("AB");
		for(String s: results)
		{
			System.out.println(s+"' ");
		}
		System.out.println(obj.find("ABA"));
		System.out.println(obj.find("word"));
		
	}

}
