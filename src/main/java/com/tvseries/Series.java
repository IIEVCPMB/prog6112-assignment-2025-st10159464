
package com.tvseries;

import java.util.Scanner;

public class Series {
    public static SeriesModel[] seriesArray = new SeriesModel[100];
    public static int count = 0;
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("LATEST SERIES - 2025");
            System.out.println("******************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");

            String input = scanner.nextLine();
            if (!input.equals("1")) break;

            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new series.");
            System.out.println("(2) Search for a series.");
            System.out.println("(3) Update series age restriction");
            System.out.println("(4) Delete a series.");
            System.out.println("(5) Print series report - 2025");
            System.out.println("(6) Exit Application.");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1: CaptureSeries(); break;
                case 2: SearchSeries(); break;
                case 3: UpdateSeries(); break;
                case 4: DeleteSeries(); break;
                case 5: SeriesReport(); break;
                case 6: ExitSeriesApplication(); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    public static void CaptureSeries() {
        SeriesModel s = new SeriesModel();
        System.out.print("Enter the series id: ");
        s.seriesId = scanner.nextLine();

        System.out.print("Enter the series name: ");
        s.seriesName = scanner.nextLine();

        while (true) {
            try {
                System.out.print("Enter the series age restriction: ");
                s.seriesAge = Integer.parseInt(scanner.nextLine());
                if (s.seriesAge < 2 || s.seriesAge > 18) throw new Exception();
                break;
            } catch (Exception e) {
                System.out.println("You have entered an incorrect series age!!!");
            }
        }

        System.out.print("Enter the number of episodes: ");
        s.numberOfEpisodes = Integer.parseInt(scanner.nextLine());

        seriesArray[count++] = s;
        System.out.println("Series processed successfully!!!");
    }

    public static void SearchSeries() {
        System.out.print("Enter the series id to search: ");
        String id = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (seriesArray[i].seriesId.equals(id)) {
                System.out.println("SERIES ID: " + seriesArray[i].seriesId);
                System.out.println("SERIES NAME: " + seriesArray[i].seriesName);
                System.out.println("SERIES AGE RESTRICTION: " + seriesArray[i].seriesAge);
                System.out.println("NUMBER OF EPISODES: " + seriesArray[i].numberOfEpisodes);
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    public static void UpdateSeries() {
        System.out.print("Enter the series id to update: ");
        String id = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (seriesArray[i].seriesId.equals(id)) {
                System.out.print("Enter the series name: ");
                seriesArray[i].seriesName = scanner.nextLine();
                System.out.print("Enter the age restriction: ");
                seriesArray[i].seriesAge = Integer.parseInt(scanner.nextLine());
                System.out.print("Enter the number of episodes: ");
                seriesArray[i].numberOfEpisodes = Integer.parseInt(scanner.nextLine());
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    public static void DeleteSeries() {
        System.out.print("Enter the series id to delete: ");
        String id = scanner.nextLine();
        for (int i = 0; i < count; i++) {
            if (seriesArray[i].seriesId.equals(id)) {
                System.out.print("Are you sure you want to delete series " + id + " from the system? Yes (y) to delete: ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("y")) {
                    for (int j = i; j < count - 1; j++) {
                        seriesArray[j] = seriesArray[j + 1];
                    }
                    count--;
                    System.out.println("Series with Series Id: " + id + " WAS deleted!");
                }
                return;
            }
        }
        System.out.println("Series with Series Id: " + id + " was not found!");
    }

    public static void SeriesReport() {
        for (int i = 0; i < count; i++) {
            System.out.println("Series " + (i + 1));
            System.out.println("-----------------------------------------");
            System.out.println("SERIES ID: " + seriesArray[i].seriesId);
            System.out.println("SERIES NAME: " + seriesArray[i].seriesName);
            System.out.println("SERIES AGE RESTRICTION: " + seriesArray[i].seriesAge);
            System.out.println("NUMBER OF EPISODES: " + seriesArray[i].numberOfEpisodes);
            System.out.println("-----------------------------------------");
        }
    }

    public static void ExitSeriesApplication() {
        System.out.println("Exiting application...");
    }
}
