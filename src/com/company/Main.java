package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    Container container = createContainer();
    container.run();
  }

  public static Container createContainer() {
    List<ServiceConfig> serviceConfigs = new ArrayList<>();
    serviceConfigs.add(new ServiceConfig("a", 1000, ""));
    serviceConfigs.add(new ServiceConfig("b", 500, "a"));
    serviceConfigs.add(new ServiceConfig("c", 100, "a"));
    serviceConfigs.add(new ServiceConfig("d", 10, "a"));
    return new Container(3, serviceConfigs);
  }
}
