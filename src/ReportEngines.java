import java.util.ArrayList;
import java.util.Scanner;

public class ReportEngines {

    static YearlyReport yearlyReport;
    static ArrayList<MonthlyReport> monthlyReports = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void loadMouths() {
        int userInput;
        System.out.println("За какой год загрузить все месячные отчёты ? ex.(2021)");
        userInput = scanner.nextInt();
        if (userInput == 2021) {

            monthlyReports = new ArrayList<>(12);
            ReportEngines reportEngines = new ReportEngines();

            for (int i = 0; i < 12; i++) {
                if (i < 9) {
                    monthlyReports.add(reportEngines.getMReports("m." + userInput + "0" + (i + 1) + ".csv"));
                    monthlyReports.get(i).setNameOfMonth(getMonth(i));
                } else {
                    monthlyReports.add(reportEngines.getMReports("m." + userInput +""+ (i + 1) + ".csv"));
                    monthlyReports.get(i).setNameOfMonth(getMonth(i));
                }
                if (monthlyReports.get(i).isExpense.isEmpty()) {
                    monthlyReports.remove(i);
                    break;
                }
            }
            System.out.println("Готово!\n");
        }
        else System.out.println("Нет отчётов за этот год\n");
    }

    public void loadYear() {

        int userInput;
        System.out.println("За какой год загрузить годовой отчёт ? ex.(2021)");
        userInput = scanner.nextInt();
        if (userInput == 2021) {
            ReportEngines reportEngines = new ReportEngines();
            yearlyReport = reportEngines.getYReports("y." + userInput + ".csv");
            yearlyReport.setYear(userInput);
            System.out.println("Готово!\n");
        }
        else System.out.println("Нет отчётов за этот год\n");
    }

    public MonthlyReport getMReports(String s) {

        FileReader fileReader = new FileReader();
        ArrayList<String> lines = fileReader.readFileContents(s);
        ArrayList<Transaction> transactArray = new ArrayList<>(lines.size());
        if (!(lines.isEmpty())){
            for (int i = 1; i < lines.size(); i++) {
                String[] lineContents = lines.get(i).split(",");
                Transaction transaction = new Transaction(lineContents[0],Boolean.valueOf(lineContents[1]),
                Integer.valueOf(lineContents[2]),Integer.valueOf(lineContents[3]));
                transactArray.add(transaction);

            }
        }
        return new MonthlyReport(transactArray);
    }

    public YearlyReport getYReports(String s) {

        FileReader fileReader = new FileReader();

        ArrayList<String> lines = fileReader.readFileContents(s);

        ReportEngines reportEngines = new ReportEngines();
        ArrayList<Transaction> transactArray = new ArrayList<>(lines.size());

        if (!(lines.isEmpty())){
            for (int i = 1; i < lines.size(); i++) {
                String[] lineContents = lines.get(i).split(",");
                Transaction transaction = new Transaction(reportEngines.getMonth(Integer.parseInt(lineContents[0])-1),
                        Integer.valueOf(lineContents[1]),Boolean.valueOf(lineContents[2]));
                transactArray.add(transaction);
            }
        }
        return new YearlyReport(transactArray);
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

    public String getMonth(int nameMonth) {
        String[] nameOfMonths = {"Январь", "Февраль", "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"};
        return nameOfMonths[nameMonth];
    }

}
