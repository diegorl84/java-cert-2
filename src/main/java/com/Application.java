package com;

import com.exceptions.MyFileReader;

public class Application {
  public static void main(String[] args) {
    // This calls an implicit finally to exec close() before any call to catch of finally
    try (var bookReader = new MyFileReader("1");
        var movieReader = new MyFileReader("2");
        var tvReader = new MyFileReader("3")) {
      System.out.println("Try block");
    } finally {
      // Explicit finally
      System.out.println("Finally block");
    }

    /*
    It is possible to use resources previously created but they have to be marked final or be effectively final
    like the following movieReader as is assigned only ONCE
     */

    final var bookReader = new MyFileReader("4");
    MyFileReader movieReader = new MyFileReader("5");
    try (bookReader;
        var tvReader = new MyFileReader("6");
        movieReader; ) {
      System.out.println("Try block");
    } finally {
      System.out.println("2nd finally");
    }
  }
}
