package com.exceptions;

public class MyFileReader implements AutoCloseable {
  private String tag;

  public MyFileReader(String tag) {
    this.tag = tag;
  }

  public void close() {
    System.out.println("Close " + tag );
  }
}
