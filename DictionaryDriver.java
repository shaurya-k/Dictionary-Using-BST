//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Dictionary Using BST)
// Files: (Dictionary.java, DictionaryBST.java, DictionaryDriver.java, DictionarWord.java,
// DictionaryTests.java)
// Course: (CS 300, Spring, and 2019)
//
// Author: (Shaurya Kethireddy)
// Email: (skethireddy@wisc.edu)
// Lecturer's Name: (Gary Dahl)
//
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: None
// Online Sources: None
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * This class is a driver application which will run the DictionaryBST and the methods
 * 
 * @author shaurya
 *
 */
public class DictionaryDriver {
  /**
   * main method which runs the program
   * 
   * @param args
   */
  public static void main(String[] args) {
    DictionaryBST dict = new DictionaryBST(); // creates new DictionaryBST object
    Scanner scnr = new Scanner(System.in); // Initializes new scanner
    String response = ""; // initialize response string

    while (!response.equals("q")) { // condition
      printCommandPrompt(); // calls print method
      System.out.println("Please enter your command: ");
      response = scnr.next(); // takes next word
      response = response.toLowerCase(); // switches to lower case
      try {
        if (response.equals("a")) {
          String word = scnr.next().trim(); // assigns word with characters until next space
          String meaning = scnr.nextLine().trim(); // assigns meaning with characters until next new
                                                   // line
          if (word.equals(null) || meaning.equals(null) || word.isEmpty() || meaning.isEmpty()) {
            System.out.println("WARNING: Syntax Error for [A <word> <meaning>] command line.");
          } else {
            dict.addWord(word, meaning); // add the word and meaning to dictionary
          }
        } else if (response.equals("l")) {
          String lookup = scnr.next(); // assign lookup with characters until next space
          if (lookup.equals(null) || lookup.isEmpty()) {
            System.out.println("WARNING: Syntax Error for [L <word>] command line.");
          } else {
            System.out.println(lookup + ": " + dict.lookup(lookup)); // calls method with param
          }
        } else if (response.equals("g")) {
          if (dict.size() == 0) { // condition
            System.out.println("Dictionary is empty.");
          } else {
            int size = dict.size(); // assign size with dictionary size
            ArrayList<String> wordsInList = dict.getAllWords(); // intialize array with all the
                                                                // words
            String printWords = null; // intialize new string
            for (int i = 0; i < size; i++) { // for loop to iterate through
              if (i == 0) {
                printWords = wordsInList.get(0); // print the first word
              } else {
                printWords = printWords + ", " + wordsInList.get(i); // add words with comma
              }
            }
            System.out.println(printWords);
          }
        } else if (response.equals("s")) {
          System.out.println(dict.size());// prints the called method
        } else if (response.equals("h")) {
          System.out.println(dict.height());// prints the called method
        } else if (response.equals("q")) {
          break; // break out of the while loop
        } else {
          System.out.println("WARNING: Unrecognized command."); // if input not one of desired
                                                                // commands
        }
      } catch (IllegalArgumentException e) { // catch Illegal exception
        System.out.println(e.getMessage());// print error message
      } catch (NoSuchElementException e) {// catch NoSuchElement exception
        System.out.println(e.getMessage());// print error message
      }
    }

    System.out.println("============================== END ===================================");
    scnr.close(); // close scanner
  }



  /**
   * helper method to print out the command prompt
   */
  public static void printCommandPrompt() {
    System.out.println("=========================== Dictionary ============================\n"
        + "Enter one of the following options:\n"
        + "[A <word> <meaning>] to add dict new word and its definition in the dictionary\n"
        + "[L <word>] to search dict word in the dictionary and display its definition\n"
        + "[G] to print all the words in the dictionary in sorted order\n"
        + "[S] to get the count of all words in the dictionary\n"
        + "[H] to get the height of this dictionary implemented as dict binary search tree\n"
        + "[Q] to quit the program\n"
        + "======================================================================");
  }
}


