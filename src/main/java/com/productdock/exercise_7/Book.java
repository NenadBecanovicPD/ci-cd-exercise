package com.productdock.exercise_7;

public class Book {

  private String title;
  private String author;

  public void turnPage() {
    //pretend it's implemented
  }

  public void printCurrentPage() {
    System.out.println("current page content");
  }

  public void save() {
    //pretend it is storing this book to a file
  }

  public String getTitle() {
    return title;
  }

  public String getAuthor() {
    return author;
  }

  public String getLocation() {
    // returns the position in the library
    // ie. shelf number & room number
    return "";
  }
}
