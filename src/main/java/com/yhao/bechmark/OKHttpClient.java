package com.yhao.bechmark;

import com.google.common.util.concurrent.RateLimiter;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OKHttpClient implements HttpClient {

  private final static String ENDPOINT = "http://localhost:3000/api/postdata";
  private final OkHttpClient okHttpClient;

  public OKHttpClient() {
    okHttpClient = new OkHttpClient.Builder()
        .connectTimeout(3000, TimeUnit.MILLISECONDS).build();
//    okHttpClient = new OkHttpClient();
  }

  public Report attack(int maxQps, int times) throws InterruptedException {

    RateLimiter rateLimiter = RateLimiter.create(maxQps);
    final AtomicInteger errorCount = new AtomicInteger(0);
    final AtomicInteger successCount = new AtomicInteger(0);

    final CountDownLatch countDownLatch = new CountDownLatch(times);

    long startTs = System.currentTimeMillis();

    for (int i = 0; i < times; i++) {

      rateLimiter.acquire();

      RequestBody payload = new FormBody.Builder().add("name", "Eason").build();

      final Request request = new Request.Builder()
          .url(ENDPOINT)
          .post(payload)
          .build();

      Call call = okHttpClient.newCall(request);

      call.enqueue(new Callback() {
        public void onResponse(Call call, Response response)
            throws IOException {
          successCount.incrementAndGet();
          countDownLatch.countDown();
        }

        public void onFailure(Call call, IOException e) {
          errorCount.incrementAndGet();
          countDownLatch.countDown();
          System.out.println();
        }
      });
    }

    countDownLatch.await();

    long endTs = System.currentTimeMillis();
    int totalTime = (int) (endTs - startTs) / 1000;
    int qps = times / totalTime;

    return new Report(qps, totalTime, successCount.intValue(), errorCount.intValue());
  }
}
