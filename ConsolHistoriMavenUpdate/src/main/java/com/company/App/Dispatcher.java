package com.company.App;

import com.company.Comands.*;
import com.company.WorkWithJSON.JSON_Reader;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

import java.io.IOException;
import java.util.*;

/**
 * Класс отвечает за диспетчеризацию (исполняет команды)
 */
public class Dispatcher implements IDispatcher{
    /** карта объектов команд для исполнения*/
    HashMap<String, CommandsAbstract> commandMap = new HashMap<String, CommandsAbstract>();
    /**Две коллекции для хранения информации nameObject имена объектов, а AllInfo вся информация об объекте*/
    public Deque<String> nameObject = new ArrayDeque<String>();
    public Deque<String> AllInfo = new ArrayDeque<String>();

    private final Console console;

    /**Флаг состояния работы программы*/
    public boolean flagWork = true;

    @Inject
    public Dispatcher(Console console, ShowCollection show,
                      RemoveElementCollection remove, AddPlaceCollection addPlaceElement, AddKidCollection addKidElement,
                      AddHumanWithPropellersCollection addHumanElement ,RemoveLastElement remove_last, InfoCollection info,
                      SaveCollection save, ComandOffWork off){
        commandMap.put("show", show);
        commandMap.put("remove", remove);
        commandMap.put("add_place", addPlaceElement);
        commandMap.put("add_hwp", addHumanElement);
        commandMap.put("add_kid", addKidElement);
        commandMap.put("remove_last", remove_last);
        commandMap.put("info", info);
        commandMap.put("save", save);
        commandMap.put("off", off);
        this.console = console;
    }

    /**
     * Функция получает введенную команду и исполняет её
     */
    @Override
    public void Dispatch(String value) throws IOException {
        String[] ComandArr = value.split(":");
        value = ComandArr[0].trim().toLowerCase();
        if(commandMap.get(value) != null){
            CommandsAbstract command = commandMap.get(value);
            command.doCommand(this, ComandArr[1].trim());
        }else if(!value.equals(""))
            console.printPrompt("Такой команды не существует :>");

    }

    /**
     * Запись в коллекцию значений из файла json
     */
    public void updateCollection() throws IOException {
        Injector injector = Guice.createInjector(new Config());
        JSON_Reader reader = injector.getInstance(JSON_Reader.class);
        reader.readJASON();
        this.nameObject.addAll(reader.nameObject);
        this.AllInfo.addAll(reader.AllInfo);
    }
}
