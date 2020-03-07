package com.console;

import java.util.Scanner;

public class Main {
    static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        String expression = scn.nextLine();
        Calculator calc = new Calculator();
        System.out.println(calc.calculate(expression));
    }
}
