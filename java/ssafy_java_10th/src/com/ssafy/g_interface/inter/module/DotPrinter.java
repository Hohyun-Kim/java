package com.ssafy.g_interface.inter.module;

public class DotPrinter implements Printer {

    @Override
    public void print(String fileName) {
        System.out.println("Dot Printer로 프린트 한다.");
    }

}
