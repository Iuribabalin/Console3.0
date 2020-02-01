package com.company.WorkWithJSON;

import com.google.gson.stream.JsonWriter;
import com.company.App.Dispatcher;

import java.io.FileWriter;
import java.io.IOException;

public class JSON_Writer implements Writer{
    /**Путь к Json файлу*/
    private static final String FILENAME = "C:\\Users\\babal\\IdeaProjects\\ConsolHistoriMavenUpdate\\src\\main\\java\\com\\company\\JSONfiles\\Info.JSON";

    /**
     * Запись в Json файл
     * @param dispatcher
     * @throws IOException
     */
    public void writeJSON(Dispatcher dispatcher) throws IOException {
        try (JsonWriter writer = new JsonWriter(new FileWriter(FILENAME))) {
            writer.beginObject();
            for(String e: dispatcher.AllInfo) {
                if (e.equals("Kid") || e.equals("HumanWithPropeller") || e.equals("Place")) {
                    writer.name("Object").value(e);
                } else {
                    writer.name("name").value(e);
                }
            }
            writer.endObject();
        }
    }
}