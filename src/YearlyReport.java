import java.util.ArrayList;

public class YearlyReport {
    final ArrayList<String> monthName;
    final ArrayList<Boolean> isExpense;
    final ArrayList<Integer> unitPrice;
    private int year;

    public YearlyReport(ArrayList<String> monthName, ArrayList<Boolean> isExpense, ArrayList<Integer> unitPrice) {
        this.monthName = monthName;
        this.isExpense = isExpense;
        this.unitPrice = unitPrice;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    public void getProfitPerMonthReport() {
        for (int i = 0; i < isExpense.size(); i+=2) {
            int profit = 0;
            for (int j = 0; j < 2; j++) {
                if (isExpense.get(j+i)) {
                profit -= unitPrice.get(j+i);
                } else profit += unitPrice.get(j+i);
            }
            System.out.println("Прибыль за "+(monthName.get(i))+": "+profit);
        }

    }


    public void getAverageOperationPerYear() {

        int averageProfit = 0;
        int averageWaste = 0;

        for (int i = 0; i < isExpense.size(); i++) {
                if (isExpense.get(i)) {
                    averageWaste += unitPrice.get(i);
                } else averageProfit += unitPrice.get(i);
        }

        System.out.println("\n"+"Средний расход за все имеющиеся операции в году: "+ averageWaste/(isExpense.size()/2));
        System.out.println("Средний доход за все имеющиеся операции в году: "+ averageProfit/(isExpense.size()/2)+"\n");

    }
}
