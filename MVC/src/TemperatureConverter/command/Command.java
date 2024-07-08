package TemperatureConverter.command;

import TemperatureConverter.ConverterModel;

public abstract class Command {
    protected ConverterModel converterModelRemote;

    public Command(ConverterModel converterControllerRemote) {
        this.converterModelRemote = converterControllerRemote;
    }

    public abstract void execute();
}
