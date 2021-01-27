package com.concurrency;

//Runnable define de task o work that a Thread will execute.
public class CalculateAverage implements Runnable {
  private double[] scores;

  public CalculateAverage(double[] scores){
    this.scores = scores;
  }

  @Override
  public void run() {

  }
}
