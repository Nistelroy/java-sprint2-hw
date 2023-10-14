import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();

          int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("За какой год считать все месячные отчёты ? ex.(2021)");
                userInput = scanner.nextInt();
                    if (userInput == 2021) {
                    getMonthlyReports(userInput);
                    }
                    else System.out.println("Нет отчётов за этот год\n");
            }

            else if (userInput == 2) {
                System.out.println("Считать годовой отчёт");
            }

            else if (userInput == 3) {
                System.out.println("Сверить отчёты");
            }

            else if (userInput == 4) {
                outputOfMonth();
            }

            else if (userInput == 5) {
            System.out.println("Вывести информацию о годовом отчёте");
            }

            else if (userInput == 6) {
                scanner.close();
                return;
            }
            else System.out.println("нет команды");

        }
    }

    private static void outputOfMonth() {
        if (monthlyReports.isEmpty()) {
            System.out.println("Сначала надо считать месячные отчёты\n");
        } else {
            for (MonthlyReport monthlyReport : monthlyReports) {
                System.out.println(monthlyReport.getNameOfMonth());
                System.out.println("Наибольшая прибыль : " + monthlyReport.getMostProfitProduct());
                System.out.println("Наибольшая трата   : " + monthlyReport.getMostWasteProduct());

            }
        }
    }

    private static void getMonthlyReports(int userInput) {
        monthlyReports = new ArrayList<>(12);
        ReportEngines reportEngines = new ReportEngines();
        for (int i = 0; i < 12; i++) {
            if (i < 9) {
                monthlyReports.add(reportEngines.getMonthlyReport("m." + userInput + "0" + (i + 1) + ".csv"));
                monthlyReports.get(i).setNameOfMonth(getMonth(i));
            } else {
                monthlyReports.add(reportEngines.getMonthlyReport("m." + userInput + "0" + (i + 1) + ".csv"));
            }
              if (monthlyReports.get(i).isExpense.isEmpty()) {
              monthlyReports.remove(i);
                break;
            }


        }
        System.out.println("Готово!\n");
    }

    private static void printMenu(){
        System.out.println("Выберите пункт меню и введите его номер:");
        System.out.println("'1' -Загрузить все месячные отчёты");
        System.out.println("'2' -Загрузить годовой отчёт");
        System.out.println("'3' -Сверить отчёты");
        System.out.println("'4' -Вывести информацию обо всех месячных отчётах");
        System.out.println("'5' -Вывести информацию о годовом отчёте");
        System.out.println("'6' -Выйти");


    }
    private static String getMonth(int nameMonth) {
        String[] nameOfMonths = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return nameOfMonths[nameMonth];
    }
}

