import java.util.ArrayList;

public class YearlyReport {
    ArrayList<String> monthName = new ArrayList<>();
    ArrayList<Boolean> isExpense = new ArrayList<>();
    ArrayList<Integer> unitPrice = new ArrayList<>();
    ArrayList<Transaction> transactArray;
    private int year;

    public YearlyReport(ArrayList<Transaction> transactArray) {
        this.transactArray = transactArray;
        for (Transaction transaction : transactArray) {
            monthName.add(transaction.name);
            isExpense.add(transaction.isExp);
            unitPrice.add(transaction.unit);
        }
    }

    public void getProfitPerMonthReport () {
        for (int i = 0; i < isExpense.size(); i += 2) {
            int profit = 0;
            for (int j = 0; j < 2; j++) {
                if (isExpense.get(j + i)) {
                    profit -= unitPrice.get(j + i);
                } else profit += unitPrice.get(j + i);
            }
                System.out.println("Прибыль за " + (monthName.get(i)) + ": " + profit);
        }

    }

    public void getAverageOperationPerYear () {

        int averageProfit = 0;
        int averageWaste = 0;

        for (int i = 0; i < isExpense.size(); i++) {
            if (isExpense.get(i)) {
                averageWaste += unitPrice.get(i);
            } else averageProfit += unitPrice.get(i);
        }

        System.out.println("\n" + "Средний расход за все имеющиеся операции в году: " + averageWaste / (isExpense.size() / 2));
        System.out.println("Средний доход за все имеющиеся операции в году: " + averageProfit / (isExpense.size() / 2) + "\n");

    }
    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

}

