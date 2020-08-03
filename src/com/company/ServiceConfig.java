package com.company;


public class ServiceConfig {
  private final String name;
  private final int timeout;
  private final String dependence;

  public ServiceConfig(String name, int timeout, String dependence) {
    this.name = name;
    this.timeout = timeout;
    this.dependence = dependence;
  }

  public String getName() {
    return name;
  }

  public int getTimeout() {
    return timeout;
  }

  public String getDependence() {
    return dependence;
  }
}
