package com.yhao.bechmark;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpClientRetryInterceptor implements Interceptor {
  private final int maxRetries;

  OkHttpClientRetryInterceptor(int maxRetries) {
    this.maxRetries = maxRetries;
  }

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    Response response = null;

    // 進行重試
    for (int retry = 0; retry <= maxRetries; retry++) {
      try {
        response = chain.proceed(request);
        if (response.isSuccessful() || retry == maxRetries) {
          break;
        }
      } catch (IOException e) {
        if (retry == maxRetries) {
          throw e;
        }
      }
    }

    return response;
  }
}