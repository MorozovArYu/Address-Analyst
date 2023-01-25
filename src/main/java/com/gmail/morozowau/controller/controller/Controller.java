package com.gmail.morozowau.controller.controller;

import com.gmail.morozowau.controller.exceptions.ImpossibleFileNameException;
import com.gmail.morozowau.controller.exceptions.NoSuchFileExtensionException;
import com.gmail.morozowau.model.entities.Address;
import com.gmail.morozowau.model.exceptions.ImpossibleFloorException;
import com.gmail.morozowau.model.exceptions.WrongFormatException;
import com.gmail.morozowau.model.initialization.CSVInitLayer;
import com.gmail.morozowau.model.initialization.XMLInitLayer;
import com.gmail.morozowau.model.interfaces.Init;
import com.gmail.morozowau.model.interfaces.Logic;
import com.gmail.morozowau.model.logic.CountOfFloorsAndDuplicateEntriesLogic;
import com.gmail.morozowau.view.interfaces.ShowView;
import com.gmail.morozowau.view.view.View;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    private Scanner scanner = new Scanner(System.in);
    private Init<Address> init;
    private Logic logic;
    private ShowView view;

    public void execute() {
        System.out.println("Program started, input file path:");
        String path = scanner.nextLine();
        while (!path.equals("stop")) {
            System.out.println("Starting logic ...\n");
            long time = System.currentTimeMillis();
            try {
                executableScript(path);
            } catch (IOException | NoSuchFileExtensionException i) {
                System.out.println(i.getMessage());
            } catch (ImpossibleFloorException ife) {
                System.out.println(ife.getMessage());
            } catch (WrongFormatException wf) {
                System.out.println(wf.getMessage());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.printf("\nLogic stop; time has passed: %d ms\nInput file path:\n", System.currentTimeMillis() - time);
                path = scanner.nextLine();
            }

        }
    }

    public void executableScript(String path) throws IOException {
        init = createDataInit(path);
        this.logic = new CountOfFloorsAndDuplicateEntriesLogic(init.getData());
        view = new View(logic.findCountOfFloorsInCity(), logic.findDuplicate());
        view.showCountOfFloors();
        view.showDuplicateEntries();
    }

    private Init<Address> createDataInit(String path) {
        if (!path.contains("."))
            throw new ImpossibleFileNameException("Имя файла должно содержать точку\nВведенный путь: " + path);
        if (path.endsWith(".csv")) return new CSVInitLayer(path);
        else if (path.endsWith(".xml")) return new XMLInitLayer(path);
        else
            throw new NoSuchFileExtensionException("Нет возможности получения данных из файла " + path.substring(path.lastIndexOf(".")));
    }


}
