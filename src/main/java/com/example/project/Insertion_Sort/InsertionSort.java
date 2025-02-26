package com.example.project.Insertion_Sort;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        
        ArrayList<String> words = InsertionSort.loadWordsInto(new ArrayList<String>());

InsertionSort.selectionSortWordList(words);
System.out.println(words);
System.out.println();
ArrayList<String> word = InsertionSort.loadWordsInto(new ArrayList<String>());
InsertionSort.insertionSortWordList(word);
System.out.println(word);


    }

    // PART A. implementing insertion sort
    public static int[] insertionSort(int[] elements) {
        int count = 0;
        for(int i = 1; i < elements.length; i++){
            int index = i;
            int num = elements[i];
            while(index > 0 && num < elements[index - 1]){
                count++;
                elements[index] = elements[index - 1];
                index--;
            }
            elements[index] = num;
        }
        System.out.println(count);
        return elements;
    }

   
    public static void selectionSort(int[] elements) {
        int count = 0;
        for(int i = 0; i < elements.length - 1; i++){
            int small = i;
            for(int j = i + 1; j < elements.length; j++){
                count++;
                if(elements[j]<elements[small]){
                    small = j;
                }
            }
            int temp = elements[i];
            elements[i] = elements[small];
            elements[small] = temp;
        }
        System.out.println(count);
    }

    // PART B. sorting a 1000-word list
    public static ArrayList<String> insertionSortWordList(ArrayList<String> words) {
        int count = 0;
        for(int i = 1; i < words.size(); i ++){
            int index = i;
            String word = words.get(i);
            while(index > 0 && word.compareTo(words.get(index-1)) < 0){
                count++;
                words.set(index, words.get(index-1));
                index--;
            }
            words.set(index, word);
        }
        System.out.println(count);
        return words;
    }

    public static void selectionSortWordList(ArrayList<String> words) {
        int count = 0;
        for(int i = 0; i < words.size() - 1; i++){
            int small = i;
            for(int j = i+1; j <words.size(); j++){
                count++;
                if(words.get(j).compareTo(words.get(small)) < 0){
                    small = j;
                }
            }
            String temp = words.get(i);
            words.set(i, words.get(small));
            words.set(small, temp);
        }
        System.out.println(count);
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