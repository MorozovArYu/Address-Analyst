package com.gmail.morozowau.controller.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

class ControllerTest {
    Controller controller = new Controller();
    private ByteArrayOutputStream output = new ByteArrayOutputStream();
    private String initialDataPathCsv = "src/test/resources/com/gmail/morozowau/controller/controller/ControllerTest/initialData/Address.csv";
    private String initialDataPathXml = "src/test/resources/com/gmail/morozowau/controller/controller/ControllerTest/initialData/Address.xml";
    private StringBuilder expectedCsv = new StringBuilder();
    private StringBuilder expectedXml = new StringBuilder();
    private PrintStream outBackUp = System.out;
    private InputStream sysInBackup = System.in;

    {
        try (
                BufferedReader readerCsv = new BufferedReader(new FileReader("src/test/resources/com/gmail/morozowau/controller/controller/ControllerTest/expected/AddressCsv"));
                BufferedReader readerXml = new BufferedReader(new FileReader("src/test/resources/com/gmail/morozowau/controller/controller/ControllerTest/expected/AddressXml"))
        ) {
            while(readerCsv.ready()){
                expectedCsv.append(readerCsv.readLine() + "\n");
            }
            while(readerXml.ready()){
                expectedXml.append(readerXml.readLine() + "\n");
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
    }

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    void whenInputPathCsvThenOutputMatchesExpectedCsv() throws IOException {
        controller.executableScript(initialDataPathCsv);
        assertEquals(expectedCsv.toString(), output.toString());
    }

    @Test
    void whenInputPathXmlThenOutputMatchesExpectedXml() throws IOException {
        controller.executableScript(initialDataPathXml);
        assertEquals(expectedXml.toString(), output.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(outBackUp);
    }

}