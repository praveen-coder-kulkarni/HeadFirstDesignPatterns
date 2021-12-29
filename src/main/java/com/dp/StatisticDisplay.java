import interfaces.DisplayElement;
import interfaces.Observer;

public class StatisticDisplay implements Observer, DisplayElement {

   private float maxTemp = 0.0f;
   private float minTemp = 200;
   private float tempSum = 0.0f;
   private int numOfReadings = 0;
   private WeatherData weatherData;

   public StatisticDisplay(WeatherData weatherData) {

      this.weatherData = weatherData;
      weatherData.registerObserver(this);
   }

   @Override
   public void display() {
      System.out.println("Avg/Max/Min temperature = " + (tempSum / numOfReadings)
       + "/" + maxTemp + "/" + minTemp);
   }

   @Override
   public void update() {
      float temp = weatherData.getTemperature();
      numOfReadings++;
      tempSum += temp;
      if(temp < minTemp)   minTemp = temp;
      if(temp > maxTemp)   maxTemp = temp;
      display();
   }
}
