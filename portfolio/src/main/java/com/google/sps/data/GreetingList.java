package com.google.sps.data;

/** Class containing server statistics. */
public final class GreetingList {

  private final String enGreeting;
  private final String spGreeting;
  private final String cnGreeting;
  private final String fraGreeting;

  public GreetingList(String enGreeting, String spGreeting, String cnGreeting, String fraGreeting) {
    this.enGreeting = enGreeting;
    this.spGreeting = spGreeting;
    this.cnGreeting = cnGreeting;
    this.fraGreeting = fraGreeting;
  }

  public String getEn() {
    return enGreeting;
  }

  public String getSp() {
    return spGreeting;
  }

  public String getCn() {
    return cnGreeting;
  }

  public String getFra() {
    return fraGreeting;
  }
}
