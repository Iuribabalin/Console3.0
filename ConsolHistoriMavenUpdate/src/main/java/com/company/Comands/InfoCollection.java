package com.company.Comands;


import com.company.App.Console;
import com.company.App.Dispatcher;
import com.google.inject.Inject;


public class InfoCollection extends CommandsAbstract{

    private final Console console;

    @Inject
    InfoCollection(Console console){
        this.console = console;
    }

    @Override
    public void doCommand(Dispatcher dispatcher, String element) {
        int kidCnt = 0,humanCnt = 0, placeCnt = 0;
        for(String e: dispatcher.AllInfo){
            if(e.equals("Kid"))
                kidCnt = kidCnt + 1;
            else if(e.equals("HumanWithPropeller"))
                humanCnt = humanCnt + 1;
            else if(e.equals("Place"))
                placeCnt = placeCnt + 1;
        }

        String param = String.valueOf(kidCnt);
        console.printPrompt("Объектов Kid " + param);
        param = String.valueOf(humanCnt);
        console.printPrompt("Объектов Human with Propeller " + param);
        param = String.valueOf(placeCnt);
        console.printPrompt("Объектов Place " + param);
    }
}
