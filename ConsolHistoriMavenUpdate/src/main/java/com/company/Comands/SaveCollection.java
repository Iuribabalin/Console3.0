package com.company.Comands;

import com.company.App.App;
import com.company.App.Console;
import com.company.App.Dispatcher;
import com.company.WorkWithJSON.JSON_Writer;
import com.google.inject.Inject;


import java.io.IOException;

public class SaveCollection extends  CommandsAbstract {

    private final JSON_Writer save;
    private final Console console;

    @Inject
    SaveCollection(JSON_Writer save, Console console){
        this.save = save;
        this.console = console;
    }

    @Override
    public void doCommand(Dispatcher dispatcher, String element) throws IOException {
        save.writeJSON(dispatcher);
        console.printPrompt("Сохранение прошло успешно");
    }


}


