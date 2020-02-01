package com.company.Comands;

import com.company.App.App;
import com.company.App.Console;
import com.company.App.Dispatcher;
import com.google.inject.Inject;

import java.io.IOException;

public class ShowCollection extends CommandsAbstract{
    private final Console console;

    @Inject
    ShowCollection(Console console, App app){
        this.console = console;
    }

    @Override
    public void doCommand(Dispatcher dispatcher, String element) throws IOException {
        for(String e: dispatcher.nameObject){
            console.printPrompt(e);
        }
    }
}
