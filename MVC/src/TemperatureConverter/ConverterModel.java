package TemperatureConverter;

import TemperatureConverter.observer.Publisher;

public class ConverterModel extends Publisher{

    private double Celsius;
    private double Fahrenheit;

    public void convertC2F(double c){
        this.Celsius = c * (double)9/5 + 32;
        CelsiusChanged();
    }

    public void convertF2C(double f){
        this.Fahrenheit = (f - 32) * (double)5/9;
        FahrenheitChanged();
    }

    public double getCelsius(){
        return Celsius;
    }

    public double getFahrenheit() {
        return Fahrenheit;
    }

    
    public void CelsiusChanged(){
        notifyCelsius();
    }

    public void FahrenheitChanged(){
        notifyFahrenheit();
    }
}
