package pl.coderslab;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


        String[] menu = new String[4];
        Arrays.toString(menuArray(menu));
    }

    public static String[] menuArray(String[] menu) {
        System.out.println(ConsoleColors.BLUE + "Please select an option:" + ConsoleColors.RESET);
        menu[0] = "add";
        menu[1] = "remove";
        menu[2] = "list";
        menu[3] = "exit";

        for (int i = 0; i < menu.length; i++) {
            System.out.println(menu[i]);
        }
        return null;
    }
}