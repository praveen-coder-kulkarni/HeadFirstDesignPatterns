import interfaces.DisplayElement;
import interfaces.Observer;

public class ForecastDisplay implements Observer, DisplayElement {
   private float currentPressure = 29.92f;
   private float lastPressure;
   private WeatherData weatherData;

   public ForecastDisplay(WeatherData weatherData) {

      this.weatherData = weatherData;
      weatherData.registerObserver(this);
   }

   @Override
   public void display() {
      System.out.print("Forecast: ");
      if(currentPressure > lastPressure)
         System.out.println("Improving weather on the way!");
      else if(currentPressure == lastPressure)
         System.out.println("More on the same");
      else if(currentPressure < lastPressure)
         System.out.println("Watchout for cooler, rainy weather!");
   }

   @Override
   public void update() {
      float pressure = weatherData.getPressure();
      lastPressure = currentPressure;
      currentPressure = pressure;
      display();
   }
}
