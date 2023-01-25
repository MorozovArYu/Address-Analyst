package com.gmail.morozowau.model.interfaces;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface Init<T> {
    List<T> getData() throws IOException;

}
