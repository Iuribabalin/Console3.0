package com.company.Comands;

import com.company.App.Dispatcher;
import com.company.WorkWithJSON.JSON_Writer;
import com.google.inject.Inject;

import java.io.IOException;

public class ComandOffWork extends CommandsAbstract{

    private final JSON_Writer save;

    @Inject
    ComandOffWork(JSON_Writer save){
        this.save = save;
    }

    @Override
    public void doCommand(Dispatcher dispatcher, String element) throws IOException {
        dispatcher.flagWork = false;
        save.writeJSON(dispatcher);
    }
}
