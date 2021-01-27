package com.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ZooInfo {
  public static void main(String[] args) {
    ExecutorService service = null;
    Runnable task1 = () -> System.out.println("Print zoo inventory");
    Runnable task2 =
        () -> {
          for (int i = 0; i < 3; i++) {
            System.out.println("Print record " + i);
          }
        };

    try {
      service = Executors.newSingleThreadExecutor();
      System.out.println("Begin");
      service.execute(task1);
      service.execute(task2);
      service.execute(task1);
      System.out.println("END");
    } finally {
      if (service != null) {
        service.shutdown();
      }
    }
  }
}
