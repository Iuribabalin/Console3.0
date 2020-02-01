package com.company.WorkWithJSON;



import com.company.App.Dispatcher;

import java.io.IOException;

public interface Writer {
    void writeJSON(Dispatcher dispatcher) throws IOException;
}
