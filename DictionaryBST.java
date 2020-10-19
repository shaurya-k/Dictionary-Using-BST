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

/**
 * this class implements the interface dictionary and contains recursive methods
 * 
 * @author shaurya
 *
 */
public class DictionaryBST implements Dictionary {
  private DictionaryWord root; // declares type DictionaryWord variable

  /**
   * This should be the only constructor of this class. Creates an empty dictionaryBST.
   */

  public DictionaryBST() {
    root = null; // assigns root to null
  }

  // Methods defined in the Dictionary interface
  /**
   * this method checks if the dictionary is empty
   * 
   * @return false if root is not null
   */
  @Override
  public boolean isEmpty() {
    return root == null; // checks if root is null
  }

  /**
   * this method adds a word with its corresponding mean
   * @param word - first param is the word 
   * @param meaning - second param is the meaning
   * @throws IllegalArgumentException if word/meaning are null/empty
   * @return true if word added successfully
   */
  @Override
  public boolean addWord(String word, String meaning) {
    if (word == null) { // check if word is null
      throw new IllegalArgumentException("word can't have null references");// throw exception
    }
    if (meaning == null) {// check if meaning is null
      throw new IllegalArgumentException("meaning can't have null references");// throw exception
    }
    if (word.isEmpty()) {// check if word is empty
      throw new IllegalArgumentException("word can't have empty references");// throw exception
    }
    if (meaning.isEmpty()) {// check if meaning is empty
      throw new IllegalArgumentException("meaning can't have empty references");// throw exception
    }
    if (isEmpty()) {
      root = new DictionaryWord(word, meaning); // assigns root with new word
      return true;
    }
    return addWordHelper(new DictionaryWord(word, meaning), root); // calls the helper method
  }

  /**
   * this method looks up a word and returns its corresponding definition
   * @param s - the word to lookup
   * @return the definition of the word
   */
  @Override
  public String lookup(String s) {
    if (isEmpty()) {
      throw new NoSuchElementException("No defintion found for the word " + s); // throw exception
                                                                                // if the dictionary
                                                                                // is empty
    }
    return lookupHelper(s, root); // calls the helper method
  }

  /**
   * Computes and returns the size of this dictionaryBST, the number of total nodes
   * @return the size of the dictionary
   */
  @Override
  public int size() {
    return sizeHelper(this.root); // calls the helper method
  }

  // Public methods not defined in the Dictionary interface
  /**
  * Computes and returns the height of this dictionaryBST, as the number of nodes 
  * from root to the deepest leaf DictionaryWord node.
  * 
  * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
  */
  public int height() {
    if (isEmpty()) {
      return 0; // if the dictionary is empty
    }
    return heightHelper(this.root); // calls the helper method
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   * 
   * @return an ArrayList that contains all the words within this dictionary sorted in 
   *         the ascendant order
   */
  public ArrayList<String> getAllWords() {
    if (isEmpty()) {
      return new ArrayList<String>(); // returns new array list
    }
    return getAllWordsHelper(root); // calls the helper method
  }

  // Recursive private helper methods
  // Each public method should make call to the recursive helper method with the
  // corresponding name

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   * 
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current the current DictionaryWord that is the root of the subtree where 
   *        newWord will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   */
  private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {
    boolean isAdded = true; // intialize boolean variable
    if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) == 0) { // checks if word is
                                                                             // already in the
                                                                             // dictionary
      isAdded = false; // sets to false
    } else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) < 0) { // checks if word
                                                                                   // is less value
                                                                                   // than current
      if (current.getLeftChild() == null) {
        current.setLeftChild(newWordNode); // sets the left child
      }
      current = current.getLeftChild(); // assigns the current
      addWordHelper(newWordNode, current); // recursive method
    } else if (newWordNode.getWord().compareToIgnoreCase(current.getWord()) > 0) { // checks if word
                                                                                   // is more value
                                                                                   // than current
      if (current.getRightChild() == null) {
        current.setRightChild(newWordNode); // sets the right child
      }
      current = current.getRightChild(); // assigns the current
      addWordHelper(newWordNode, current); // recursive method
    }


    return isAdded;
  }


  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   * 
   * @param s String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current) {
    if (current == null) {
      throw new NoSuchElementException("No defintion found for the word " + s); // throw exception
    }
    if (s.compareToIgnoreCase(current.getWord()) == 0) { // if current is equal to the word s
      return current.getMeaning(); // get the meaning of it
    } else if (s.compareToIgnoreCase(current.getWord()) < 0) { // if current is greater than the
                                                               // word s
      current = current.getLeftChild(); // assign current to left child
      return lookupHelper(s, current); // recursive method
    }
    current = current.getRightChild(); // assign current to right child
    return lookupHelper(s, current); // recursive method
  }


  /**
   * Recursive helper method that returns the number of dictionary words stored in 
   * the subtree rooted at current
   * 
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    if (current == null) { // if current has null pointer
      return 0;
    }
    int size = sizeHelper(current.getLeftChild()) + sizeHelper(current.getRightChild()) + 1;
    // assigns size with the number of nodes in the dictionary
    return size;
  }


  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of   
   * DictionaryWord nodes from the current node to the deepest leaf in the subtree
   * rooted at current
   */
  private static int heightHelper(DictionaryWord current) {
    if (current == null) { // if current is null
      return 0;
    }
    return 1
        + Math.max(heightHelper(current.getLeftChild()), heightHelper(current.getRightChild()));
  }



  /**
   * Recursive Helper method that returns a list of all the words stored in 
   * the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
    ArrayList<String> Dictionary = new ArrayList<String>(); // creates new array list
    if (current == null) { // if the current is null
      Dictionary.add("Dictionary is empty");
    }
    if (current.getLeftChild() != null) {
      Dictionary.addAll(getAllWordsHelper(current.getLeftChild())); // gets the left child and adds
                                                                    // to array list
    }
    if (current != null) {
      Dictionary.add(current.getWord()); // adds the word pointed to the current to array list
    }
    if (current.getRightChild() != null) {
      Dictionary.addAll(getAllWordsHelper(current.getRightChild())); // gets the right child and
                                                                     // adds to array list
    }
    return Dictionary;
  }
}
