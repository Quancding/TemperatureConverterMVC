package TemperatureConverter.observer;

import java.util.LinkedList;
import java.util.List;

public class Publisher{

    private List<Subcriber> subcribers = new LinkedList<>();

    public void subcribe(Subcriber subcriber) {
        subcribers.add(subcriber);
    }

    public void unSubcriber(Subcriber subcriber) {
        subcribers.remove(subcriber);
    }

    public void notifyCelsius() {
        for (Subcriber subcriber : subcribers) {
            subcriber.updateCelsius();
        }
    }

    public void notifyFahrenheit(){
        for (Subcriber subcriber : subcribers) {
            subcriber.updateFahrenheit();
        }
    }
}
