import java.util.ArrayList;
import java.util.Scanner;

public class ReportEngines {
    static YearlyReport yearlyReport;
    static ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public Object getMReports(String s) {

        FileReader fileReader = new FileReader();
        Transaction transaction = new Transaction();


        ArrayList<String> lines = fileReader.readFileContents(s);
        transaction.getTransfectionMonth(lines);

        return new MonthlyReport(transaction.nameEntity, transaction.isExpense, transaction.quantity, transaction.unit_price);
    }
    public Object getYReports(String s) {
        FileReader fileReader = new FileReader();
        Transaction transaction = new Transaction();

        ArrayList<String> lines = fileReader.readFileContents(s);
        transaction.getTransfectionYear(lines);

        return new YearlyReport(transaction.nameEntity,transaction.isExpense,transaction.unit_price);


    }

    public void loadMouths() {
        int userInput;
        System.out.println("За какой год загрузить все месячные отчёты ? ex.(2021)");
        userInput = scanner.nextInt();
        if (userInput == 2021) {
            getMonthlyReports(userInput);
        }
        else System.out.println("Нет отчётов за этот год\n");
    }

    public void getMonthlyReports(int userInput) {
        monthlyReports = new ArrayList<>(12);
        ReportEngines reportEngines = new ReportEngines();

        for (int i = 0; i < 12; i++) {
            if (i < 9) {
                monthlyReports.add((MonthlyReport) reportEngines.getMReports("m." + userInput + "0" + (i + 1) + ".csv"));
                monthlyReports.get(i).setNameOfMonth(getMonth(i));
            } else {
                monthlyReports.add((MonthlyReport) reportEngines.getMReports("m." + userInput +""+ (i + 1) + ".csv"));
                monthlyReports.get(i).setNameOfMonth(getMonth(i));
            }
            if (monthlyReports.get(i).isExpense.isEmpty()) {
                monthlyReports.remove(i);
                break;
            }
        }
        System.out.println("Готово!\n");
    }
    public String getMonth(int nameMonth) {
        String[] nameOfMonths = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return nameOfMonths[nameMonth];
    }
    public void getYearReport(int userInput) {
        ReportEngines reportEngines = new ReportEngines();
        yearlyReport = (YearlyReport) reportEngines.getYReports("y." + userInput + ".csv");
        yearlyReport.setYear(userInput);
        System.out.println("Готово!\n");
    }

    public void loadYear() {
        int userInput;
        System.out.println("За какой год загрузить годовой отчёт ? ex.(2021)");
        userInput = scanner.nextInt();
        if (userInput == 2021) {
            getYearReport(userInput);
        }
        else System.out.println("Нет отчётов за этот год\n");
    }


    public void outputCheckMonthPerYear() {
        if (monthlyReports.isEmpty()) {
            System.out.println("Сначала надо загрузить в программу все отчёты\nОтчёт по месяцам не загружен\n");
        }
        else if (yearlyReport == null) {
            System.out.println("Сначала надо загрузить в программу все отчёты\nОтчёт за год не загружен\n");
        }
        else {
            MonthTotalPerYear monthTotalPerYear = new MonthTotalPerYear(monthlyReports,yearlyReport);
            monthTotalPerYear.getCollation();
        }
    }

    public void outputOfYear() {
        if (yearlyReport == null) {
            System.out.println("Сначала надо загрузить в программу отчёт за год\n");
        }
        else {
            System.out.println("\n"+"Отчётный год: "+yearlyReport.getYear());
            yearlyReport.getProfitPerMonthReport();
            yearlyReport.getAverageOperationPerYear();
        }
    }


    public void outputOfMonth() {
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

}
