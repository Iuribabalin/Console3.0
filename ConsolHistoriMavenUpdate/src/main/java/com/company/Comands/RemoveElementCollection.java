package com.company.Comands;

import com.company.App.Console;
import com.company.App.Dispatcher;
import com.google.inject.Inject;

public class RemoveElementCollection extends CommandsAbstract {

    private final Console console;

    @Inject
    RemoveElementCollection(Console console){
        this.console = console;
    }


    @Override
    public void doCommand(Dispatcher dispatcher, String element) {
        if(searchElementInCollection(element,dispatcher)) {
            dispatcher.nameObject.remove(element);
            dispatcher.AllInfo.remove(searchObject(element, dispatcher));
            dispatcher.AllInfo.remove(element);
            console.printPrompt(element + " - удален успешно");
        }else{
            console.printPrompt(element + " - не существует");
        }
    }

     private String searchObject(String search, Dispatcher dispatcher) {
         String element = null;
         for (String e : dispatcher.AllInfo) {
             if (e.equals(search))
                 break;
             else
                 element = e;
         }
         return element;
     }

    private boolean searchElementInCollection(String element, Dispatcher dispatcher){
         for (String e : dispatcher.nameObject) {
             if(e.equals(element)){
                 return true;
             }
         }
         return false;
     }
}
