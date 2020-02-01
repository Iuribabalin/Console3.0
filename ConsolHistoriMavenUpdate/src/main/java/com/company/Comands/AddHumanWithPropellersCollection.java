package com.company.Comands;

import com.company.App.Console;
import com.company.App.Dispatcher;
import com.company.lab_4.HumanwithPropeller;
import com.google.inject.Inject;

import java.io.IOException;

public class AddHumanWithPropellersCollection extends CommandsAbstract {

    private final Console console;
    private HumanwithPropeller human;

    @Inject
    AddHumanWithPropellersCollection(Console console, HumanwithPropeller human){
        this.console = console;
        this.human = human;
    }

    @Override
    public void doCommand(Dispatcher dispatcher, String element) throws IOException {
        human.setName(element);
        dispatcher.nameObject.addLast(human.getName());
        dispatcher.AllInfo.addLast("HumanWithPropeller");
        dispatcher.AllInfo.addLast(human.getName());
        console.printPrompt(element + " Добавлен успешно");
    }
}
