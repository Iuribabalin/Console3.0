package com.company.WorkWithJSON;

import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class JSON_Reader implements Reader{
    private static final String FILENAME = "C:\\Users\\babal\\IdeaProjects\\ConsolHistoriMavenUpdate\\src\\main\\java\\com\\company\\JSONfiles\\Info.JSON";
    /**
     * Коллекции с информацией об объектах
     */
    public Deque<String> nameObject = new ArrayDeque<String>();
    public Deque<String> AllInfo = new ArrayDeque<String>();

    /**
     * Чтение из json файла
     * @throws IOException
     */
    public void readJASON() throws IOException {
        try (JsonReader reader = new JsonReader(new FileReader(FILENAME))) {
            reader.beginObject();
            while (reader.hasNext()) {
                String name = reader.nextName();
                if (name.equals("name")) {
                    nameObject.addLast(reader.nextString());
                    AllInfo.addLast(nameObject.getLast());
                }else if(name.equals("Object")){
                    AllInfo.addLast(reader.nextString());
                }else{
                    reader.skipValue();
                }
            }
            reader.endObject();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
