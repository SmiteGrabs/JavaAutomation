package Lesson6HT;

import okhttp3.*;
import okio.BufferedSink;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class Ht1
{
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        String weatherData ="";
        HttpUrl gismeteo = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
               .addPathSegment("v2")
                .addPathSegment("forecast")
              .addQueryParameter("lat","59.9386300")
                .addQueryParameter("lon","30.3141300")
                .addQueryParameter("lang","ru_RU")
                .addQueryParameter("limit","5")
                .build();

        Request tokenRequest = new Request.Builder().url(gismeteo).addHeader("X-Yandex-API-Key","55f85a16-08fc-4cd3-95a1-2e0a0019becc").get().build();
        Response responseCity = client.newCall(tokenRequest).execute();
        System.out.println(tokenRequest);
        System.out.println(responseCity.body().string());
    }


}
