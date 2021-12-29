import interfaces.Observer;
import interfaces.Subject;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {

   private float temperature;
   private float humidity;
   private float pressure;

   private List<Observer> observers;

   public WeatherData() {
      observers = new ArrayList<Observer>();
   }

   public float getTemperature() {

      return temperature;
   }

   public float getHumidity() {

      return humidity;
   }

   public float getPressure() {

      return pressure;
   }

   public void measurementsChanged(){
      notifyObservers();
   }

   public void setMeasurements(float temperature, float humidity, float pressure){
      this.temperature = temperature;
      this.humidity = humidity;
      this.pressure = pressure;
      measurementsChanged();
   }

   @Override
   public void registerObserver(Observer observer) {
      observers.add(observer);
   }

   @Override
   public void removeObserver(Observer observer) {
      observers.remove(observer);
   }

   @Override
   public void notifyObservers() {
      for(Observer observer : observers)
         observer.update();
   }
}
