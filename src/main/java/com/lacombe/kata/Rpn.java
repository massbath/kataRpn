package com.lacombe.kata;

public class Rpn {


    private final String input;

    public Rpn(String input) {

        this.input = input;
    }

    public String calculate() {

        String[] tmp = input.split(" ");


        if (tmp.length == 3) {
            return String.valueOf(Integer.valueOf(tmp[0]) + Integer.valueOf(tmp[1]));
        }


        return input;
    }
}
