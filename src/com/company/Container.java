package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Container {
  private final int count;
  private final List<ServiceConfig> services;
  private final List<String> launched = new ArrayList<>();

  public Container(int count, List<ServiceConfig> services) {
    this.count = count;
    this.services = services;
  }

  public void run() {
    ExecutorService executor = Executors.newFixedThreadPool(count);
    while (true) executor.submit(this::runServices);
  }

  private void runServices() {
    if (launched.size() < services.size()) {
      services.forEach(s -> {
        try {
          if (!launched.contains(s.getName())) {//если сервис не исполняется
            if (launched.size() == 0L || launched.stream().anyMatch(s1 -> s.getDependence().contains(s1))) {
              synchronized (launched) {
                launched.add(s.getName());
                new Service().run(s.getName(), s.getTimeout());
                launched.remove(s.getName());
              }
            }
          }
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      });
    }
  }
}
