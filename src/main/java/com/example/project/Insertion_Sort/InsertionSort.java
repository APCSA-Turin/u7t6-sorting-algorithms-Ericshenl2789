package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class InsertionSort {


    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        for(int i = 1; i< elements.length; i++){
            int index = i;
            int num = elements[i];
            while(index > 0 && num < elements[index - 1]){
                elements[index] = elements[index - 1];
                index--;
            }
            elements[index] = num;
        }
        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        for(int i = 1; i < words.size(); i ++){
            int index = i;
            String word = words.get(i);
            while(index > 0 && word.compareTo(words.get(index-1)) < 0){
                words.set(index, words.get(index-1));
                index--;
            }
            words.set(index, word);
        }
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        for(int i = 0; i < words.size() - 1; i++){
            int small = i;
            for(int j = i; j <words.size(); j++){
                if(words.get(j).compareTo(words.get(small)) < 0){
                    small = j;
                }
            }
            String temp = words.get(i);
            words.set(i, words.get(small));
            words.set(small, temp);
        }
    }

    public static ArrayList<String> loadWordsInto(ArrayList<String> wordList) {
        try {
            Scanner input = new Scanner(new File("src/main/java/com/example/project/Selection_Sort/words.txt"));
            while (input.hasNext()) {
                String word = input.next();
                wordList.add(word);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return wordList;
    }

   
}