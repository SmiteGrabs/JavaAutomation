package L6;


import L7.WeatherResponse;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.*;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;


public class Weather {


    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        HttpUrl yaWeather = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("forecast")
                .addQueryParameter("lat", "59.9386300")
                .addQueryParameter("lon", "30.3141300")
                .addQueryParameter("lang", "ru_RU")
                .addQueryParameter("limit", "5")
                .addQueryParameter("hours","false")
                .addQueryParameter("extra","false")
                .build();

        Request weatherRequest = new Request.Builder().url(yaWeather).addHeader("X-Yandex-API-Key", "55f85a16-08fc-4cd3-95a1-2e0a0019becc").get().build();
        Response weatherResponse = client.newCall(weatherRequest).execute();

        WeatherResponse day1 = new WeatherResponse();
        WeatherResponse day2 = new WeatherResponse();
        WeatherResponse day3 = new WeatherResponse();
        WeatherResponse day4 = new WeatherResponse();
        WeatherResponse day5 = new WeatherResponse();
        List<WeatherResponse> forecast =new ArrayList<>();
        forecast.add(day1);
        forecast.add(day2);
        forecast.add(day3);
        forecast.add(day4);
        forecast.add(day5);


        String responseLine = weatherResponse.body().string();
        ObjectMapper objectMapper = new ObjectMapper();
        for(int i=0;i<5;i++)
        {
            JsonNode jsonNode = objectMapper.readTree(responseLine).at("/geo_object/province/name");
            forecast.get(i).setCity(jsonNode.asText());
            jsonNode =objectMapper.readTree(responseLine).at("/forecasts/"+i+"/date");
            forecast.get(i).setDate(jsonNode.asText());
            jsonNode =objectMapper.readTree(responseLine).at("/forecasts/"+i+"/parts/day/temp_avg");
            forecast.get(i).setTemp(jsonNode.asText());
            jsonNode =objectMapper.readTree(responseLine).at("/forecasts/"+i+"/parts/day/condition");
            forecast.get(i).setCondition(jsonNode.asText());

        }
        for(int i=0;i<5;i++)
        {
            forecast.get(i).show();
        }











    }


}
