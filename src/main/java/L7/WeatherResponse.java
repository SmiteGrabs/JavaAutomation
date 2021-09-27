package L7;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class WeatherResponse
{

    private String city = "Санкт-Петербург"; //создана статическая переменная города, поскольку в api называние города не предусмотрено
    private String condition;
    private String temp;
    private String date;

    public void setCondition(String src){
        switch (src){
            case ("clear"):
                this.condition="ясно";
                break;
            case ("partly-cloudy")    :
                this.condition="малооблачно";
                break;
            case ("cloudy"):
                this.condition="облачно с прояснениями";
                break;
            case ("overcast"):
                this.condition="пасмурно";
                break;
            case("drizzle"):
                this.condition="морось";
                break;
            case ("light-rain"):
                this.condition="небольшой дождь";
                break;
            case("rain"):
                this.condition="дождь";
                break;
            case ("moderate-rain"):
                this.condition="умеренно сильный дождь";
                break;
            case("heavy-rain"):
                this.condition="сильный дождь";
                break;
            case ("continuous-heavy-rain"):
                this.condition="длительный сильный дождь";
                break;
            case ("showers"):
                this.condition="ливень";
                break;
            case ("wet-snow"):
                this.condition="дождь со снегом";
                break;
            case("light-snow"):
                this.condition="небольшой снег";
                break;
            case("snow"):
                this.condition="снег";
                break;
            case("snow-showers"):
                this.condition="снегопад";
                break;
            case("hail"):
                this.condition="град";
                break;
            case("thunderstorm"):
                this.condition="гроза";
                break;
            case("thunderstorm-with-rain"):
                this.condition="дождь с грозой";
                break;
            case("thunderstorm-with-hail"):
                this.condition="гроза с градом";
                break;
            default:break;
        }
    }
    public String getCondition(){return condition;}
    public void setTemp(String temp){this.temp=temp;}
    public String getTemp(){return temp;}
    public void setDate(String src){this.date=src;}
    public String getDate(){return date;}
    public void setCity(String city){this.city=city;}

    public void show()
    {
        System.out.println("В городе "+city+" на дату " +date+" ожидается "+condition+", температура - "+temp+"");
    }
}
