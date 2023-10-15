import java.util.ArrayList;

public class MonthTotalPerYear {

    private final ArrayList<MonthlyReport> monthlyReports;
    private final YearlyReport yearlyReport;

    public MonthTotalPerYear(ArrayList<MonthlyReport> monthlyReports, YearlyReport yearlyReport) {
        this.monthlyReports = monthlyReports;
        this.yearlyReport = yearlyReport;
    }

    public void getCollation() {

        int noErrorsMonth = 0;

        for (int i = 0; i < monthlyReports.size(); i++) {


            int profitPerMonthFromMontRep = 0;
            int wastePerMonthFromMontRep = 0;

            for (int j = 0; j < monthlyReports.get(i).isExpense.size(); j++) {
                if (monthlyReports.get(i).isExpense.get(j)) {                   //расход
                    wastePerMonthFromMontRep += monthlyReports.get(i).quantity.get(j) * monthlyReports.get(i).unitPrice.get(j);
                } else
                    profitPerMonthFromMontRep += monthlyReports.get(i).quantity.get(j) * monthlyReports.get(i).unitPrice.get(j);
            }



            int profitPerMonthFromYearRep = 0;
            int wastePerMonthFromYearRep = 0;

            for (int j = 0; j < yearlyReport.isExpense.size(); j++) {
                if (yearlyReport.monthName.get(j).equals(monthlyReports.get(i).getNameOfMonth())) {
                    if (yearlyReport.isExpense.get(j)) {
                        wastePerMonthFromYearRep = yearlyReport.unitPrice.get(j);
                    } else
                        profitPerMonthFromYearRep = yearlyReport.unitPrice.get(j);
                }
            }



            if (profitPerMonthFromMontRep != profitPerMonthFromYearRep) {
                System.out.println("Обноружено расхождение в доходах за " +monthlyReports.get(i).getNameOfMonth());
            }
            else if (wastePerMonthFromMontRep != wastePerMonthFromYearRep) {
                System.out.println("Обноружено расхождение в расходах за " +monthlyReports.get(i).getNameOfMonth());
            }
            else noErrorsMonth++;
        }


        if (noErrorsMonth == monthlyReports.size()) {
            System.out.println("\nСверка прошла успешно\n");
        }

    }
}