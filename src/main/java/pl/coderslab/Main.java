package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] array = new String[2][3];
        readFromFile(array);

        String[] menu = new String[4];
        menu = menuArray(menu);
        System.out.println(Arrays.toString(menu));
    }

    public static String[] menuArray(String[] menu) {
        System.out.println(ConsoleColors.BLUE + "Proszę wybrać opcję:" + ConsoleColors.RESET);
        menu[0] = "Dodaj";
        menu[1] = "Usuń";
        menu[2] = "Lista";
        menu[3] = "Wyjdź";

        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
        return menu;
    }

    public static void readFromFile(String[][] tasks) {
        StringBuilder reading = new StringBuilder();
        File file = new File("C:\\Users\\Mojescik\\IdeaProjects\\TaskManager\\src\\main\\resources\\tasks.csv");
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                reading.append(scanner.nextLine()).append("\n");
            }
            // Tutaj możesz dalej przetwarzać odczytaną zawartość, np. podzielić na linie
            // lub wykonać inne operacje zgodnie z potrzebami twojego programu
            System.out.println("Zawartość pliku:");
            System.out.println(reading.toString());
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie został znaleziony. " + e);
        }
    }
}