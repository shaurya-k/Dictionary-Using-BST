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

/**
 * This class tests certain algorithms and checks if they are doing their intended purpose
 * 
 * @author Shaurya
 *
 */
public class DictionaryTests extends DictionaryBST {
  /**
   * main method which runs all the methods
   * 
   * @param args
   */
  public static void main(String[] args) {

    getAllWordsTest(); // calls method
    lookupTest(); // calls method
    isEmptyTest(); // calls method
    heightTest(); // calls method
    sizeTest(); // calls method
  }

  /**
   * This method checks if the getAllWords function works properly
   * @return false if test failed
   */
  public static boolean getAllWordsTest() {
    DictionaryBST dictionary = new DictionaryBST(); // creates dictionary object
    // adds words to the dictionary
    dictionary.addWord("shaurya", "my name");
    dictionary.addWord("chadbourne", "my dorm");
    dictionary.addWord("wisconsin", "my state");
    ArrayList<String> output = dictionary.getAllWords(); // creates array list with all the words in
                                                         // dictionary in correct order
    if (output.get(0).equals("chadbourne")) { // checks element at 0
      if (output.get(1).equals("shaurya")) { // checks element at 1
        if (output.get(2).equals("wisconsin")) { // checks element at 2
          System.out.println("Passed getAllWordsTest");
          return true;
        }
      }
    }
    System.out.println("Failed getAllWordsTest");
    return false;

  }

  /**
   * This method checks if the lookup function works properly
   * @return false if test failed
   */
  public static boolean lookupTest() {
    DictionaryBST dictionary = new DictionaryBST(); // create dictionary object
    // adds words to the dictionary
    dictionary.addWord("shaurya", "my name");
    dictionary.addWord("chadbourne", "my dorm");
    dictionary.addWord("wisconsin", "my state");
    // assigns string variable with definition of desired words
    String output = dictionary.lookup("shaurya");
    String output2 = dictionary.lookup("chadbourne");
    if (output.equals("my name")) { // checks if first word returns correct definition
      if (output2.equals("my dorm")) {// checks if second word returns correct definition
        System.out.println("Passed lookupTest");
        return true;
      }
    }
    System.out.println("Failed lookupTest");
    return false;
  }

  /**
   * this method checks if isEmpty function works properly
   * @return false if test failed
   */
  public static boolean isEmptyTest() {
    // creates two new dictionaries objects
    DictionaryBST dictionary = new DictionaryBST();
    DictionaryBST dictionary2 = new DictionaryBST();
    // adds words to first dictionary
    dictionary.addWord("shaurya", "my name");
    dictionary.addWord("chadbourne", "my dorm");
    dictionary.addWord("wisconsin", "my state");

    if (!dictionary.isEmpty()) { // checks if first dictionary is not empty
      if (dictionary2.isEmpty()) { // checks if second dictionary is empty
        System.out.println("Passed isEmptyTest");
        return true;
      }
    }
    System.out.println("Failed isEmptyTest");
    return false;
  }

  /**
   * this method checks if height function works properly
   * @return false if test failed
   */
  public static boolean heightTest() {
    // creates three dictionaries objects
    DictionaryBST dictionary = new DictionaryBST();
    DictionaryBST dictionary2 = new DictionaryBST();
    DictionaryBST dictionary3 = new DictionaryBST();
    // adds words to first dictionary
    dictionary.addWord("shaurya", "my name");
    dictionary.addWord("chadbourne", "my dorm");
    dictionary.addWord("wisconsin", "my state");
    // adds words to second dictionary
    dictionary2.addWord("shaurya", "my name");
    dictionary2.addWord("chadbourne", "my dorm");
    dictionary2.addWord("wisconsin", "my state");
    dictionary2.addWord("age", "i am 18");
    dictionary2.addWord("track", "my favorite sport");

    if (dictionary.height() == 2) { // checks if first dictionary height is 2
      if (dictionary2.height() == 3) { // checks if second dictionary height is 3
        if (dictionary3.height() == 0) { // checks if third dictionary height is 0
          System.out.println("Passed heightTest");
          return true;
        }
      }
    }
    System.out.println("Failed heightTest");
    return false;
  }

  /**
   * this method checks if the size function works properly
   * @return false if test failed
   */
  public static boolean sizeTest() {
    // creates 3 new dictionaries objects
    DictionaryBST dictionary = new DictionaryBST();
    DictionaryBST dictionary2 = new DictionaryBST();
    DictionaryBST dictionary3 = new DictionaryBST();
    // adds 3 words to dictionary
    dictionary.addWord("shaurya", "my name");
    dictionary.addWord("chadbourne", "my dorm");
    dictionary.addWord("wisconsin", "my state");
    // adds 5 words to dictioanry2
    dictionary2.addWord("shaurya", "my name");
    dictionary2.addWord("chadbourne", "my dorm");
    dictionary2.addWord("wisconsin", "my state");
    dictionary2.addWord("age", "i am 18");
    dictionary2.addWord("track", "my favorite sport");

    if (dictionary.size() == 3) { // checks the size of first dictionary
      if (dictionary2.size() == 5) { // checks the size of second dictionary
        if (dictionary3.size() == 0) { // checks the size of third dictionary
          System.out.println("Passed sizeTest");
          return true;
        }
      }
    }
    System.out.println("Failed sizeTest");
    return false;
  }
}
