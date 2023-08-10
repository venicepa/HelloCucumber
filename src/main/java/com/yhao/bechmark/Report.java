package com.yhao.bechmark;

public class Report {

  private int qps;

  private int totalTimeInSeq;

  private int successCount;

  private int errorCount;

  public Report(int qps, int totalTimeInSeq, int successCount, int errorCount) {
    this.qps = qps;
    this.totalTimeInSeq = totalTimeInSeq;
    this.successCount = successCount;
    this.errorCount = errorCount;
  }

  public int getQps() {
    return qps;
  }

  public int getTotalTimeInSeq() {
    return totalTimeInSeq;
  }

  public int getSuccessCount() {
    return successCount;
  }

  public int getErrorCount() {
    return errorCount;
  }
}
