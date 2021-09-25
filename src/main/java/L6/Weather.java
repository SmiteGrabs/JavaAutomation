package L6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Weather
{
        public static void main(String[] args) throws IOException {
            OkHttpClient client = new OkHttpClient().newBuilder().build();
            HttpUrl yaWeather = new HttpUrl.Builder()
                    .scheme("https")
                    .host("api.weather.yandex.ru")
                    .addPathSegment("v2")
                    .addPathSegment("forecast")
                    .addQueryParameter("lat","59.9386300")
                    .addQueryParameter("lon","30.3141300")
                    .addQueryParameter("lang","ru_RU")
                    .addQueryParameter("limit","5")
                    .build();

            Request weatherRequest = new Request.Builder().url(yaWeather).addHeader("X-Yandex-API-Key","55f85a16-08fc-4cd3-95a1-2e0a0019becc").get().build();
            Response weatherResponse = client.newCall(weatherRequest).execute();
            System.out.println(weatherRequest);
            System.out.println(weatherResponse.body().string());
        }


}
