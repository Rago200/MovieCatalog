//////////////// FILE HEADER ///////////////////////////////////////////////////
//
// Title:    Movie Tree Tester
// Course:   CS 300 Spring 2021
//
// Author:   Rago Senthilkumar
// Email:    rsenthilkuma@wisc.edu
// Lecturer: Hobbes LeGault
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Hobbes LeGault: Provided instructions to create
//
///////////////////////////////////////////////////////////////////////////////
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * This class checks the correctness of the implementation of the methods defined in the class
 * MovieTree.
 *
 */

public class MovieTreeTester {

  /**
   * Checks the correctness of the implementation of both addMovie() and toString() methods
   * implemented in the MovieTree class. This unit test considers at least the following scenarios.
   * (1) Create a new empty MovieTree, and check that its size is 0, it is empty, and that its
   * string representation is an empty string "". (2) try adding one movie and then check that the
   * addMovie() method call returns true, the tree is not empty, its size is 1, and the .toString()
   * called on the tree returns the expected output. (3) Try adding another movie which is smaller
   * that the movie at the root, (4) Try adding a third movie which is greater than the one at the
   * root, (5) Try adding at least two further movies such that one must be added at the left
   * subtree, and the other at the right subtree. For all the above scenarios, and more, double
   * check each time that size() method returns the expected value, the add method call returns
   * true, and that the .toString() method returns the expected string representation of the
   * contents of the binary search tree in an increasing order from the smallest to the greatest
   * movie with respect to year, rating, and then name. (6) Try adding a movie already stored in the
   * tree. Make sure that the addMovie() method call returned false, and that the size of the tree
   * did not change.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testAddMovieToStringSize() {
    try {
      //(1) Empty movie tree
      MovieTree movieTree = new MovieTree();
      if (movieTree.size() != 0) {
        System.out.println("The size of the tree was supposed to 0, but resulted in: " + movieTree.size());
        return false;
      }
      if (!movieTree.isEmpty()) {
        System.out.println("The isEmpty function was supposed to be true : " + movieTree.isEmpty());
        return false;
      }
      if (!movieTree.toString().equals("")) {
        System.out.println("The toString method was supposed to be \"\" but that was not it");
        return false;
      }

      //(2) Adding one Movie into the tree
      if (!movieTree.addMovie(new Movie(2010, 7, "Avengers"))) {
        System.out.println("(2)When the movie was added it did not return true.");
        return false;
      }

      if (movieTree.isEmpty() != false) {
        System.out.println("(2)The movie was not added properly as the"
                + " isEmpty method returned: " + movieTree.isEmpty());
        return false;
      }

      if (movieTree.size() != 1) {
        System.out.println("(2)The movie may not have been added properly as" +
                " the size was not one, but was: " + movieTree.size());
        return false;
      }

      if (!movieTree.toString().equals("[(Year: 2010) (Rate: 7.0) (Name: Avengers)]\n")) {
        System.out.println("(2)The movie may not have been added properly as " +
                "the string method returned: " + movieTree.toString());
        return false;
      }

      //(3)Adding move that is smaller than the root movie
      if (!movieTree.addMovie(new Movie(2008, 6, "DR.Strange"))) {
        System.out.println("(3)The movie was not added successfully as it returned false");
        return false;
      }

      if (movieTree.size() != 2) {
        System.out.println("(3)The size was not incremented properly as the size was supposed" +
                " to be 2 but was: " + movieTree.size());
        return false;
      }

      if (!movieTree.toString().equals("[(Year: 2008) (Rate: 6.0) (Name: DR.Strange)]\n" +
              "[(Year: 2010) (Rate: 7.0) (Name: Avengers)]\n")) {
        System.out.println("(3)The toString method may have some issues as the string was incorrect: \n" +
                movieTree.toString());
        return false;
      }

      //(4)Adding move that is greater than the root movie
      if (!movieTree.addMovie(new Movie(2013, 8, "Hulk"))) {
        System.out.println("(4)The movie was not added successfully as it returned false");
        return false;
      }

      if (movieTree.size() != 3) {
        System.out.println("(4)The size variable was not incremented properly as it was not" +
                " three, but was: " + movieTree.size());
        return false;
      }

      if (!movieTree.toString().equals("[(Year: 2008) (Rate: 6.0) (Name: DR.Strange)]\n" +
              "[(Year: 2010) (Rate: 7.0) (Name: Avengers)]\n" +
              "[(Year: 2013) (Rate: 8.0) (Name: Hulk)]\n")) {
        System.out.println("(4)The toString method may have some issues as the string was incorrect: \n"
                + movieTree.toString());

        return false;
      }

      //(5)Adding two additional movies one in left adn other in right subtree
      if (!movieTree.addMovie(new Movie(2015, 4.5, "Shutter Island"))) {
        System.out.println("(5)Movie may not have been added properly as it returned false.");
        return false;
      }

      if (!movieTree.addMovie(new Movie(2006, 4, "Superbad"))) {
        System.out.println("(5)Movie may not have been added properly as it returned false.");
        return false;
      }

      if (movieTree.size() != 5) {
        System.out.println("(5)The size may not have been incremented correctly as the " +
                "size was supposed to be 5, but was: " + movieTree.size());
        return false;
      }

      if (!movieTree.toString().equals("[(Year: 2006) (Rate: 4.0) (Name: Superbad)]\n" +
              "[(Year: 2008) (Rate: 6.0) (Name: DR.Strange)]\n" +
              "[(Year: 2010) (Rate: 7.0) (Name: Avengers)]\n" +
              "[(Year: 2013) (Rate: 8.0) (Name: Hulk)]\n" +
              "[(Year: 2015) (Rate: 4.5) (Name: Shutter Island)]\n")) {
        System.out.println("(5)The string was not added properly as the String returned: \n"
                + movieTree.toString());
        return false;
      }

      //(6)Adding a movie that already exists
      if (movieTree.addMovie(new Movie(2006, 4.0, "Superbad")) != false) {
        System.out.println("(6)When adding a movie already in the movie tree it should return" +
                " false but that was not the case.");
        return false;
      }

      if (movieTree.size() != 5) {
        System.out.println("(6)The size of the movie tree was incremented when it should not " +
                "have been.");
        return false;
      }
    }catch (Exception e){
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * This method checks mainly for the correctness of the MovieTree.contains() method. It must
   * consider at least the following test scenarios. (1) Create a new MovieTree. Then, check that
   * calling the contains() method on an empty MovieTree returns false. (2) Consider a MovieTree of
   * height 3 which contains at least 5 movies. Then, try to call contains() method to search for the
   * movie having a match at the root of the tree. (3) Then, search for a movie at the right and
   * left subtrees at different levels considering successful and unsuccessful search operations.
   * Make sure that the contains() method returns the expected output for every method call.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testContains() {
    try {
      //(1)Using the contains method on an empty tree
      MovieTree movieTree = new MovieTree();
      if (movieTree.contains(2010, 7, "Avengers") != false) {
        System.out.println("(1)The method returned true when it was supposed to return false.");
        return false;
      }

      //(2)Calling the contains method on the root of the tree.
      movieTree.addMovie(new Movie(2010, 7, "Avengers"));
      movieTree.addMovie(new Movie(2008, 6, "DR.Strange"));
      movieTree.addMovie(new Movie(2013, 8, "Hulk"));
      movieTree.addMovie(new Movie(2015, 4.5, "Shutter Island"));
      movieTree.addMovie(new Movie(2006, 4, "Superbad"));

      if (movieTree.contains(2010, 7, "Avengers") != true) {
        System.out.println("(2)The method did not correctly get the movie it was looking for as it returned false.");
        return false;
      }

      //(3)Calling the contains method on a movie in the right in level 2 and a movie on the left in level 3
      // and testing for something that is not in there
      if (movieTree.contains(2013, 8, "Hulk") != true) {
        System.out.println("(3)The method did not correctly get the movie it was looking for as it returned false.");
        return false;
      }

      if (movieTree.contains(2006, 4, "Superbad") != true) {
        System.out.println("(3)The method did not correctly get the movie it was looking for as it returned false.");
        return false;
      }

      if (movieTree.contains(2005, 5, "Not") != false) {
        System.out.println("This movie is not contained in the movie tree but the method returned true. ");
        return false;
      }
    } catch (Exception e){
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Checks for the correctness of MovieTree.height() method. This test must consider several
   * scenarios such as, (1) ensures that the height of an empty movie tree is zero. (2) ensures that
   * the height of a tree which consists of only one node is 1. (3) ensures that the height of a
   * MovieTree with the following structure for instance, is 4.
   *       (*)
   *     /    \
   *  (*)      (*)
   *    \     /  \
   *    (*) (*)  (*)
   *             /
   *           (*)
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testHeight() {
    try {
      //(1)Calling the height method on an empty subtree
      MovieTree movieTree = new MovieTree();
      if (movieTree.height() != 0) {
        System.out.println("(1)The method did not work correctly as it returned: " + movieTree.height());
        return false;
      }

      //(2)When the height of a tree which consists of only one node is 1
      movieTree.addMovie(new Movie(2010, 7, "Avengers"));
      if (movieTree.height() != 1) {
        System.out.println("(2)The method did not work correctly as it returned: " + movieTree.height());
        return false;
      }

      //(3)When the height of the tree is 4 and follows the structure above.
      movieTree.addMovie(new Movie(2010, 7, "Avengers"));
      movieTree.addMovie(new Movie(2008, 6, "DR.Strange"));
      movieTree.addMovie(new Movie(2013, 8, "Hulk"));
      movieTree.addMovie(new Movie(2015, 4.5, "Shutter Island"));
      movieTree.addMovie(new Movie(2009, 4, "Superbad"));
      movieTree.addMovie(new Movie(2012, 5, "Poo"));
      movieTree.addMovie(new Movie(2014, 6, "LOL"));
      if (movieTree.height() != 4) {
        System.out.println("(2)The method did not work correctly as it returned: " + movieTree.height());
        return false;
      }
    }catch (Exception e){
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Checks for the correctness of MovieTree.getBestMovie() method.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testGetBestMovie() {
    try {
      //(1)The method is called for an empty list
      MovieTree movieTree = new MovieTree();
      if (movieTree.getBestMovie() != null) {
        System.out.println("(1)The method was supposed to return null.");
        return false;
      }

      //(2)The method is called for a list with 1 node.
      Movie movie = new Movie(2010, 7, "Avengers");
      movieTree.addMovie(movie);
      if (movieTree.getBestMovie().compareTo(movie) != 0) {
        System.out.println("(2)The method returned the wrong movie.");
        return false;
      }

      //(3)The method is called for a list with multiple movies
      movieTree.addMovie(new Movie(2008, 6, "DR.Strange"));
      movieTree.addMovie(new Movie(2013, 8, "Hulk"));
      Movie movie1 = new Movie(2015, 4.5, "Shutter Island");
      movieTree.addMovie(movie1);
      movieTree.addMovie(new Movie(2009, 4, "Superbad"));
      movieTree.addMovie(new Movie(2012, 5, "Poo"));
      movieTree.addMovie(new Movie(2014, 6, "LOL"));
      if (movieTree.getBestMovie().compareTo(movie1) != 0) {
        System.out.println("(3)The method returned the wrong movie.");
        return false;
      }
    }catch (Exception e){
      e.printStackTrace();
      return false;
    }

    return true;
  }

  /**
   * Checks for the correctness of MovieTree.lookup() method. This test must consider at least 3
   * test scenarios. (1) Ensures that the MovieTree.lookup() method throws a NoSuchElementException
   * when called on an empty tree. (2) Ensures that the MovieTree.lookup() method returns an array
   * list which contains all the movies satisfying the search criteria of year and rating, when called
   * on a non empty movie tree with one match, and two matches and more. Vary your search criteria
   * such that the lookup() method must check in left and right subtrees. (3) Ensures that the
   * MovieTree.lookup() method throws a NoSuchElementException when called on a non-empty movie tree
   * with no search results found.
   *
   * @return true when this test verifies a correct functionality, and false otherwise
   */
  public static boolean testLookup() {
    try {
      //(1)Calling the lookup method on an empty tree to see if it throws the NoSuchElementException
      MovieTree movieTree = new MovieTree();
      try {
        movieTree.lookup(2019, 9);
      } catch (NoSuchElementException e) {
        System.out.println("The exception was caught for testLookup.");
        return false;
      }

      //(2)Calling the lookup method to to see if it satisfies one result, and two and more as well.
      movieTree.addMovie(new Movie(2010, 7, "Avengers"));
      movieTree.addMovie(new Movie(2008, 6, "DR.Strange"));
      movieTree.addMovie(new Movie(2013, 8, "Hulk"));
      movieTree.addMovie(new Movie(2015, 4.5, "Shutter Island"));
      movieTree.addMovie(new Movie(2009, 4, "Superbad"));
      movieTree.addMovie(new Movie(2015, 5, "Iorn Man"));
      movieTree.addMovie(new Movie(2015, 3, "Thor"));
      ArrayList<Movie> movies = movieTree.lookup(2015, 4);
      //(1)
      if (movies.get(0).compareTo(new Movie(2015, 4.5, "Shutter Island")) != 0) {
        System.out.println("(2a)The lookup method returned the wrong movies, it was: " + movies);
        return false;
      }
      //(2)
      ArrayList<Movie> movies1 = movieTree.lookup(2015, 1);
      if (movies1.get(1).compareTo(new Movie(2015, 3, "Thor")) != 0 &&
              movies1.get(0).compareTo(new Movie(2015, 4.5, "Shutter Island")) != 0) {
        System.out.println("(2b)The lookup method returned the wrong movies, it was: " + movies1);
        return false;
      }
      //(3)
      ArrayList<Movie> movies2 = movieTree.lookup(2015, 3);
      if (movies2.get(1).compareTo(new Movie(2015, 3, "Thor")) != 0 &&
              movies2.get(0).compareTo(new Movie(2015, 4.5, "Shutter Island")) != 0 &&
              movies2.get(2).compareTo(new Movie(2015, 5, "Iorn Man")) != 0) {
        System.out.println("(2c)The lookup method returned the wrong movies, it was: " + movies2);
        return false;
      }
    }catch (Exception e){
     e.printStackTrace();
     return false;
    }
    return true;
  }

  /**
   * Calls the test methods
   *
   * @param args input arguments if any
   */
  public static void main(String[] args) {
    System.out.println("testAddMovieToStringSize(): " + testAddMovieToStringSize());
    System.out.println("testContains(): " + testContains());
    System.out.println("testHeight(): " + testHeight());
    System.out.println("testGetBestMovie(): " + testGetBestMovie());
    System.out.println("testLookup(): " + testLookup());
  }

}
