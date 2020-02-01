package com.company.App;

import com.company.ControlInput;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.Scanner;

public class App implements IApp{

    private final Console console;
    private final ControlInput control;

    @Inject
    App(Console console, ControlInput control){
        this.console = console;
        this.control = control;
    }

    private Scanner scan = new Scanner(System.in);


    /**
     * Функция отвечающая за ввод команд
     * @throws IOException
     */
    @Override
    public void StartWork() throws IOException {
        Injector injector = Guice.createInjector(new Config());
        Dispatcher dispatcher = injector.getInstance(Dispatcher.class);

        dispatcher.updateCollection();
        while (dispatcher.flagWork) {
            console.printPrompt("");
            String value = scan.nextLine();
            value = control.sanitize(value);
            dispatcher.Dispatch(value);
        }
    }
}
