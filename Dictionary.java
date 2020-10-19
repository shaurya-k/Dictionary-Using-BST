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
/**
 * This interface models and abstract data type for a dictionary
 * 
 * @author shaurya
 *
 */
public interface Dictionary {
  /**
   * checks whether the dictionary is empty or not
   * 
   * @return true if empty dictionary
   */
  public boolean isEmpty();

  /**
   * adds this word definition (word and the provided meaning) to the dictionary
   * 
   * @param word
   * @param meaning
   * @return true if the word was successfully added to this dictionary
   * @throws Throws IllegalArgumentException if either word or meaning is null or an empty String
   */
  public boolean addWord(String word, String meaning);


  /**
   * looks up what the definition of certain word is
   * 
   * @param s - to check if meaning of word is in dictionary
   * @throws a NoSuchElementException if the word s was not found in this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   */

  public String lookup(String s);

  /**
   * Returns the number of words stored in this dictionary
   * 
   * @return the number of words stored in this dictionary
   */
  public int size();
}
