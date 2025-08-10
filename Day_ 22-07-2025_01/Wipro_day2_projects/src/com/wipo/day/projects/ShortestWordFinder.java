package com.wipo.day.projects;

public class ShortestWordFinder {

    public static void main(String[] args) {
        String sentence = "An anagram is a word or phrase formed by rearranging the letters";
        sentence = sentence.toLowerCase();        
        String[] words = sentence.split(" ");
        String shortest = ""; 

        for (String word : words) 
        {

            if (word.equals("a") || word.equals("an") || word.equals("is")||word.equals("the")|| word.equals("or")|| word.equals("by"))
            {
                continue;
            }

            if (shortest.equals("") || word.length() < shortest.length()) 
            {
                shortest = word;
            }
        }

        System.out.println("The shortest word (excluding 'a', 'an', 'is') is: " + shortest);
    }
}
