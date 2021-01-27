package com.concurrency;

public class Basic {
  //Runnable define de task o work that a Thread will execute.
  Runnable sloth = () -> System.out.println("Hello");
  Runnable snake =
      () -> {
        int i = 10;
        i++;
      };
  Runnable beaver =
      () -> {
        return;
      };
  Runnable coyote = () -> {};
}
