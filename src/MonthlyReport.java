import java.util.ArrayList;

public class MonthlyReport {

    final ArrayList<String> itemName ;
    final ArrayList<Boolean> isExpense;
    final ArrayList<Integer> quantity;
    final ArrayList<Integer> unitPrice;

    private String nameOfMonth;

    public MonthlyReport(ArrayList<String> itemName, ArrayList<Boolean> isExpense, ArrayList<Integer> quantity, ArrayList<Integer> unitPrice) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
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
