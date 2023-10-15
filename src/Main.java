import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
    static YearlyReport yearlyReport;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {

            printMenu();

          int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("За какой год загрузить все месячные отчёты ? ex.(2021)");
                userInput = scanner.nextInt();
                    if (userInput == 2021) {
                        getMonthlyReports(userInput);
                    }
                    else System.out.println("Нет отчётов за этот год\n");
            }

            else if (userInput == 2) {
                System.out.println("За какой год загрузить годовой отчёт ? ex.(2021)");
                userInput = scanner.nextInt();
                    if (userInput == 2021) {
                        getYearReport(userInput);
                    }
                    else System.out.println("Нет отчётов за этот год\n");
            }


            else if (userInput == 3) {
                System.out.println("Сверить отчёты");
            }

            else if (userInput == 4) {
                outputOfMonth();
            }

            else if (userInput == 5) {

                System.out.println("\n"+"Отчётный год: "+yearlyReport.getYear());
                yearlyReport.getProfitPerMonthReport();
                yearlyReport.getAverageOperationPerYear();


            }

            else if (userInput == 6) {
                scanner.close();
                return;
            }
            else System.out.println("Ошибка выбора пункта меню");

        }
    }

    private static void getYearReport(int userInput) {
        ReportEngines reportEngines = new ReportEngines();
        yearlyReport = (YearlyReport) reportEngines.getReports("y." + userInput + ".csv");
        yearlyReport.setYear(userInput);
        System.out.println("Готово!\n");
    }

    private static void outputOfMonth() {
        if (monthlyReports.isEmpty()) {
            System.out.println("Сначала надо загрузить в программу месячные отчёты\n");
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
                monthlyReports.add((MonthlyReport) reportEngines.getReports("m." + userInput + "0" + (i + 1) + ".csv"));
                monthlyReports.get(i).setNameOfMonth(getMonth(i));
            } else {
                monthlyReports.add((MonthlyReport) reportEngines.getReports("m." + userInput + "0" + (i + 1) + ".csv"));
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
        System.out.println("'1' -Загрузить в программу все месячные отчёты");
        System.out.println("'2' -Загрузить в программу годовой отчёт");
        System.out.println("'3' -Сверить отчёты");
        System.out.println("'4' -Вывести информацию обо всех месячных отчётах");
        System.out.println("'5' -Вывести информацию о годовом отчёте");
        System.out.println("'6' -Выйти");


    }
    public static String getMonth(int nameMonth) {
        String[] nameOfMonths = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return nameOfMonths[nameMonth];
    }
}

