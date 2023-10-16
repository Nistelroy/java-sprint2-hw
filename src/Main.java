import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ReportEngines reportEngines = new ReportEngines();

        while (true) {

        printMenu();

        int userInput = scanner.nextInt();

            if (userInput == 1) {
                reportEngines.loadMouths();
            }
            else if (userInput == 2) {
                reportEngines.loadYear();
            }

            else if (userInput == 3) {
                reportEngines.outputCheckMonthPerYear();
            }

            else if (userInput == 4) {
                reportEngines.outputOfMonth();
            }

            else if (userInput == 5) {
                reportEngines.outputOfYear();
            }

            else if (userInput == 6) {
                scanner.close();
                return;
            }

            else System.out.println("Ошибка выбора пункта меню");

        }
    }

    private static void printMenu() {
        System.out.println("Выберите пункт меню и введите его номер:");
        System.out.println("'1' -Загрузить в программу все месячные отчёты");
        System.out.println("'2' -Загрузить в программу годовой отчёт");
        System.out.println("'3' -Сверить отчёты");
        System.out.println("'4' -Вывести информацию обо всех месячных отчётах");
        System.out.println("'5' -Вывести информацию о годовом отчёте");
        System.out.println("'6' -Закончить работу");
    }
}

