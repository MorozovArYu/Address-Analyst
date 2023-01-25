package com.gmail.morozowau.model.initialization;

import com.gmail.morozowau.model.entities.Address;
import com.gmail.morozowau.model.exceptions.WrongFormatException;
import com.gmail.morozowau.model.interfaces.Init;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CSVInitLayer implements Init<Address> {
    private String path;
    private final Pattern pattern = Pattern.compile("[^;\"]+");
    private Matcher matcher;

    public CSVInitLayer(String path) {
        this.path = path;
    }

    @Override
    public List<Address> getData() throws IOException {
        List<Address> addresses = new ArrayList<>();
        List<String> data;

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            while (reader.ready()) {
                final String line = reader.readLine();
                if (line.startsWith("\"city")) continue;
                data = new ArrayList<>();
                matcher = pattern.matcher(line);

                while (matcher.find()) {
                    data.add(matcher.group());
                }
                try {
                    addresses.add(new Address(line, data.get(0), data.get(1), data.get(2), data.get(3)));
                } catch (Exception e) {
                    throw new WrongFormatException(String.format("Неверный формат данных; строка: [%s]", line));
                }
            }

        }
        return addresses;
    }
}
