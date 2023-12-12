package pl.coderslab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] tasks = new String[2][3];

        String[] menu = new String[4];
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 4) {
            menuArray(menu);
            option = getUserOption(scanner);

            switch (option) {
                case 1:
                    addTask(scanner, tasks);
                    break;
                case 2:
                    deleteTask();
                    break;
                case 3:  // odczyt/wylistowanie danych z pliku
                    readFromFile();
                    break;
                case 4:
                    exit(); // wyjście z programu
                    break;
                default:
                    System.out.println("Niepoprawna opcja. Wybierz numer od 1 do 4.");
                    break;
            }
        }
        scanner.close();
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
            System.out.println("Zawartość pliku:");
            System.out.println(reading);
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie został znaleziony. " + e);
        }
    }

    public static void addTask(Scanner scanner, String[][] tasks) {
        System.out.println("Dodawanie nowego zadania...");

        // Pobieranie szczegółów zadania od użytkownika
        System.out.print("Podaj opis zadania: ");
        String taskDescription = scanner.nextLine(); // Używamy nextLine() do pobrania całej linii

        System.out.print("Podaj date do wykonania zadania (w formacie YYYY-MM-DD): ");
        String taskDueDate = scanner.nextLine();

        System.out.print("Podaj czy zadanie jest wazne true/false: ");
        boolean taskImportant = Boolean.parseBoolean(scanner.nextLine());

        // Dodanie nowego zadania do tablicy
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i][0] == null) { // Jeśli miejsce w tablicy jest puste
                tasks[i][0] = taskDescription;
                tasks[i][1] = taskDueDate;
                tasks[i][2] = String.valueOf(taskImportant);
                break;
            }
        }


        System.out.println("Zadanie dodane!");
    }

    public static void deleteTask() {

    }

}