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
 * This class models a binary node for a BST. Each binary node (aka instance of DictionaryWord)
 * defines its data consisting of a pair of word and its meaning, and a link to each child (right
 * and left) of the node.
 * 
 * @author shaurya
 *
 */
public class DictionaryWord {
  private final String word; // word that represents the search key for this dictionary word
  private final String meaning; // The meaning of the word that this dictionary node defines
  private DictionaryWord leftChild; // The leftChild of the the current WebPageNode
  private DictionaryWord rightChild; // The rightChild of the the current WebPageNode

  /**
   * Creates a new dictionary word with the provided word and its meaning pair
   * 
   * @param word
   * @param meaning
   * @throws IllegalArgumentException when the word or meaning are either references to an empty
   *                                  string or null references
   */
  public DictionaryWord(String word, String meaning) {
    if (word == null) { // checks if null
      throw new IllegalArgumentException("word can't have null references"); // throw error
    }
    if (meaning == null) { // checks if null
      throw new IllegalArgumentException("meaning can't have null references");// throw error
    }
    if (word.isEmpty()) { // checks if empty
      throw new IllegalArgumentException("word can't have empty references");// throw error
    }
    if (meaning.isEmpty()) { // checks if empty
      throw new IllegalArgumentException("meaning can't have empty references");// throw error
    }
    this.word = word; // assigns the parameter to class variable
    this.meaning = meaning; // assigns the parameter to class variable
  }


  /**
   * Getter for the left child of this dictionary word
   * @return leftChild
   */
  public DictionaryWord getLeftChild() {
    return leftChild;
  }

  /**
   * Setter for the left child of this dictionary word
   * @param leftChild
   */
  public void setLeftChild(DictionaryWord leftChild) {
    this.leftChild = leftChild; // assigns the parameter to class variable
  }

  /**
   * Getter for the right child of this dictionary word
   * @return rightChild
   */
  public DictionaryWord getRightChild() {
    return rightChild;
  }

  /**
   * Getter for the right child of this dictionary word
   * @param rightChild
   */
  public void setRightChild(DictionaryWord rightChild) {
    this.rightChild = rightChild; // assigns the parameter to class variable
  }

  /**
   * Getter for the word of this dictionary word
   * @return word
   */
  public String getWord() {
    return word;
  }

  /**
   * Getter for the meaning of the word of this dictionary word
   * @return meaning
   */
  public String getMeaning() {
    return meaning;
  }

  /**
   * Returns a String representation of this DictionaryWord. This String should be formatted as 
   * follows. "<word>: <meaning>". For instance, for a dictionaryWord that has the String "Awesome"
   * for the instance field word and the String "adj. Inspiring awe; dreaded." as value for meaning 
   * field, the String representing that dictionaryWord is "Awesome: adj. Inspiring awe; dreaded."
   */

  @Override
  public String toString() {

    String a = word + ": " + meaning; // intializes string a with word + : + meaning
    return a;
  }
}
