package com.gmail.morozowau;

import com.gmail.morozowau.controller.controller.Controller;

import java.io.IOException;

public class Main {
    static Controller controller = new Controller();

    public static void main(String[] args) throws IOException {
        controller.execute();
    }

}
