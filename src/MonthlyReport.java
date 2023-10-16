import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<String> itemName = new ArrayList<>();
    ArrayList<Boolean> isExpense= new ArrayList<>();
    ArrayList<Integer> quantity= new ArrayList<>();
    ArrayList<Integer> unitPrice= new ArrayList<>();
    ArrayList<Transaction> transactArray;
    private String nameOfMonth;
                                                                    // Благодарю за ревью, класс мейн так смотрится лучше)
    public MonthlyReport(ArrayList<Transaction> transactArray) {  // Могу сделать, чтобы значения брались с транзакции, но уже есть готовая реализация под 4 списка
        this.transactArray = transactArray;                     // и меня ждёт долгожданный отпуск) Прошу понять и простить) И так пришлось задержаться на день дольше в городе, чтобы сделать правки :)
        for (Transaction transaction : transactArray) {
            itemName.add(transaction.name);
            isExpense.add(transaction.isExp);
            quantity.add(transaction.quan);
            unitPrice.add(transaction.unit);
        }
    }

    public String getNameOfMonth() {
        return nameOfMonth;
    }

    public void setNameOfMonth(String nameOfMonth) {
        this.nameOfMonth = nameOfMonth;
    }

    public String getMostProfitProduct() {
        int mostProfit = 0;
        String mostProfitName = "";

        for (int i = 0; i < isExpense.size(); i++) {
            if (!(isExpense.get(i))) {
                int profit = quantity.get(i) * unitPrice.get(i);
                if (profit > mostProfit) {
                    mostProfit = profit;
                    mostProfitName = itemName.get(i);
                }

            }
        }
        return mostProfitName+". Сумма: "+mostProfit;
    }

    public String getMostWasteProduct() {
        int mostWaste = 0;
        String mostWasteName = "";
        for (int i = 0; i < isExpense.size(); i++) {
            if (isExpense.get(i)) {
                int waste = quantity.get(i)* unitPrice.get(i);
                if (waste>mostWaste) {
                    mostWaste = waste;
                    mostWasteName = itemName.get(i);
                }
            }
        }
        return mostWasteName+". Сумма: "+mostWaste+"\n";
    }
}
