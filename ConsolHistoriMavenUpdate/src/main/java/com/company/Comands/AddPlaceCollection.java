package com.company.Comands;

import com.company.App.Console;
import com.company.App.Dispatcher;
import com.company.lab_4.Place;
import com.google.inject.Inject;

public class AddPlaceCollection extends CommandsAbstract{
    private final Console console;
    private Place place;

    @Inject
    AddPlaceCollection(Console console, Place place){
        this.console = console;
        this.place = place;
    }

    @Override
    public void doCommand(Dispatcher dispatcher, String element) {
        place.setNamePlace(element);
        dispatcher.nameObject.addLast(place.getName());
        dispatcher.AllInfo.addLast("Place");
        dispatcher.AllInfo.addLast(place.getName());
        console.printPrompt(element + " Добавлен успешно");
    }
}
