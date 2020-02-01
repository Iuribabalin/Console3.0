package com.company.Comands;

import com.company.App.App;
import com.company.App.Dispatcher;

import java.io.IOException;

public interface Commands {
    /**
     * Функция отвечает за выполение команд
     * @param dispatcher
     * @param element
     * @throws IOException
     */
    void doCommand(Dispatcher dispatcher,String element) throws IOException;
}
