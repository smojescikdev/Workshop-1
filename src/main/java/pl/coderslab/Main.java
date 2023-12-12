package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String[] menu = new String[4];
        Scanner scanner = new Scanner(System.in);
        int option = 0;



        while (option != 4) {
            menuArray(menu);
            option = getUserOption(scanner);

            switch (option) {
                case 1:
                    addTask();
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:
                    readFromFile();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Niepoprawna opcja. Wybierz numer od 1 do 4.");
                    break;
            }
        }
        scanner.close(); // Zamykamy Scanner po zakończeniu
    }

    public static int getUserOption(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Niepoprawna opcja. Wybierz numer od 1 do 4.");
            scanner.next(); // Odrzucamy nieprawidłowe dane wejściowe
        }
        return scanner.nextInt();
    }

    private static void exit() {
    }



    public static String[] menuArray(String[] menu) {
        System.out.println(ConsoleColors.BLUE + "Proszę wybrać opcję:" + ConsoleColors.RESET);
        menu[0] = "1: Add";
        menu[1] = "2: Remove";
        menu[2] = "3: List";
        menu[3] = "4: Exit";

        for (String menuItem : menu) {
            System.out.println(menuItem);
        }
        return menu;
    }

    public static void readFromFile() {
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

    public static void addTask() {

    }

    public static void deleteTask() {

    }

}