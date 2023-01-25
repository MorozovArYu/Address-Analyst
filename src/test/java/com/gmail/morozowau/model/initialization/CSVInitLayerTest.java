package com.gmail.morozowau.model.initialization;

import com.gmail.morozowau.model.entities.Address;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.random;
import static java.lang.Math.round;

class CSVInitLayerTest {
    private List<Address> expected = new ArrayList<>();
    private String testPath = "src/test/resources/com/gmail/morozowau/model/initialization/CSVInitTest/Addresses.csv";
    private final int numberOfTests = 1_000;
    private CSVInitLayer csvInitLayer = new CSVInitLayer(testPath);

    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testPath))) {
            for (int i = 0; i < numberOfTests; i++) {
                String city = createRandomString((int) round(random() * 3 + 4));
                String street = createRandomString((int) round(random() * 10 + 6));
                int house = (int) round(random() * 89 + 32);
                int floor = (int) round(random() * 10 + 1);
                String initData = String.format("\"%s\";\"%s\";%d;%d",
                        city,
                        street,
                        house,
                        floor);
                if (i == numberOfTests - 1) writer.write(initData);
                else writer.write(initData + "\n");
                expected.add(new Address(initData, city, street, String.valueOf(house), String.valueOf(floor)));
            }

        } catch (IOException e) {

        }
    }

    @Test
    void WhenParsingStringThenDataTakeFromQuotes() throws IOException {
        /*
        * запрещенные символы: '"', ';'
        * */
        Assert.assertEquals(expected, csvInitLayer.getData());
    }


    private String createRandomString(int length) {
        char[] result = new char[length];

        for (int i = 0; i < result.length; i++) {
            result[i] = createRandomChar();
        }
        return String.valueOf(result);
    }

    private char createRandomChar() {
        int num = (int) round(random() * 4);

        switch (num) {
            case 1:
                return (char) (int) round(random() * 31 + 1040);
            case 2:
                return (char) (int) round(random() * 31 + 1072);
            case 3:
                return (char) (int) round(random() + 32);
            case 4:
                return (char) (int) round(random() * 23 + 35);
        }
        return 'А';
    }
}
