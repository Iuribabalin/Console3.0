package com.company.App;

import com.company.Comands.ComandOffWork;
import com.company.Comands.Commands;
import com.company.WorkWithJSON.JSON_Reader;
import com.company.WorkWithJSON.JSON_Writer;
import com.company.WorkWithJSON.Reader;
import com.company.WorkWithJSON.Writer;
import com.google.inject.AbstractModule;

public class Config extends AbstractModule {
    @Override
    protected void configure() {
        bind(IApp.class).to(App.class);
        bind(IDispatcher.class).to(Dispatcher.class);
        bind(Reader.class).to(JSON_Reader.class);
        bind(Writer.class).to(JSON_Writer.class);
        bind(Commands.class).to(ComandOffWork.class);
    }
}