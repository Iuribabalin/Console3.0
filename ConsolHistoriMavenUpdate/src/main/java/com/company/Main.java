package com.company;

import com.company.App.App;
import com.company.App.Config;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.io.IOException;

/**
 * @autor Юрий Бабалин
 * @vervion 3.0
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Guice.createInjector().getInstance(App.class);

        Injector injector = Guice.createInjector(new Config());
        App app = injector.getInstance(App.class);

        app.StartWork();
    }
}