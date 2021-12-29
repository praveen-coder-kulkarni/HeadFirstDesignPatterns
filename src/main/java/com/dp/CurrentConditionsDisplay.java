import interfaces.DisplayElement;
import interfaces.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

   private float temperature;
   private float humidity;
   WeatherData weatherData;

   public CurrentConditionsDisplay(WeatherData weatherData) {

      this.weatherData = weatherData;
      weatherData.registerObserver(this);
   }

   public float getTemperature() {

      return temperature;
   }

   public float getHumidity() {

      return humidity;
   }

   @Override
   public void display() {
      System.out.println("Current conditions: " + temperature
      + "F degrees and " + humidity + "% humidity");
   }

   @Override
   public void update() {
      this.temperature = weatherData.getTemperature();
      this.humidity = weatherData.getHumidity();
      display();
   }
}
