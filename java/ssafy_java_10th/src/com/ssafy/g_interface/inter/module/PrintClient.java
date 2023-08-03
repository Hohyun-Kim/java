package com.ssafy.g_interface.inter.module;

public class PrintClient {
    private Printer printer;

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public void printThis(String fileName) {
        printer.print(fileName);
    }
}
