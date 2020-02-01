package com.company.Comands;

import com.company.App.Console;
import com.company.App.Dispatcher;
import com.google.inject.Inject;

public class RemoveLastElement extends CommandsAbstract {
    private final Console console;

    @Inject
    RemoveLastElement(Console console){
        this.console = console;
    }

    private void toString(String element){
        console.printPrompt(element + " последний элемент удален успешно");
    }

    @Override
    public void doCommand(Dispatcher dispatcher, String element) {
        String NameElement;
        NameElement = dispatcher.nameObject.getLast();
        dispatcher.nameObject.removeLast();
        dispatcher.AllInfo.removeLast();
        dispatcher.AllInfo.removeLast();
        toString(NameElement);
    }
}
