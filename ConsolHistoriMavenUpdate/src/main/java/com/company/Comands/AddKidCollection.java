package com.company.Comands;

import com.company.App.Console;
import com.company.App.Dispatcher;
import com.company.lab_4.Kid;
import com.google.inject.Inject;

import java.io.IOException;

public class AddKidCollection extends CommandsAbstract{
    private final Console console;
    private Kid kid;

    @Inject
    AddKidCollection(Console console, Kid kid){
        this.console = console;
        this.kid = kid;
    }
    @Override
    public void doCommand(Dispatcher dispatcher, String element) throws IOException {
        kid.setName(element);
        dispatcher.nameObject.addLast(kid.getName());
        dispatcher.AllInfo.addLast("Kid");
        dispatcher.AllInfo.addLast(kid.getName());
        console.printPrompt(element + " Добавлен успешно");
    }
}
