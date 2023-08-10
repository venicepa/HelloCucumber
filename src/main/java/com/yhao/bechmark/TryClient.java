package com.yhao.bechmark;

import okhttp3.OkHttpClient;

public class TryClient {

  public static void main(String[] args) throws Exception {

    OKHttpClient okHttpClient = new OKHttpClient();

    Report report = okHttpClient.attack(2, 10);

    System.out.println("=============================");
    System.out.println("QPS : " + report.getQps());
    System.out.println("success : " + report.getSuccessCount());
    System.out.println("error :" + report.getErrorCount());
    System.out.println("total time in sec : " + report.getTotalTimeInSeq());
    System.out.println("=============================");

    System.exit(0);
  }

}
