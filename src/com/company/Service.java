package com.company;

public class Service {
  public void run(String name, long timeout) throws InterruptedException {
    System.out.println("Service: " + name + " started.");
    Thread.sleep(timeout);
    System.out.println("Service: " + name + " finished.");
  }
}
