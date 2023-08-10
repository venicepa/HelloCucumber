package com.yhao.bechmark;

public interface HttpClient {

  Report attack(int maxQps, int times) throws InterruptedException;

}
