package com.concurrency;

//Less common practice to extend from Thread
public class ReadInventoryThread extends Thread {

  @Override
  public void run() {
    System.out.println("Printing zoo inventory");
  }

  public static void main(String[] args) {
    System.out.println("Begin");
    (new ReadInventoryThread()).start();
    (new Thread(new PrintData())).start();
    (new ReadInventoryThread()).start();
    System.out.println("end");
  }
}
