package com.concurrency;

public class CheckResults {
  private static int counter = 0;

  public static void main(String[] args) {
    new Thread(() -> {
      for(int i = 0; i < 500000; i++) {
        CheckResults.counter++;
      }
    }).start();

    while (CheckResults.counter < 10000){
      System.out.println("Not reach yet");
    }

    System.out.println("Reached");
  }
}
