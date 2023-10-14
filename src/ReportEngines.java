import java.util.ArrayList;

public class ReportEngines {
    ArrayList<String> lines;



    public MonthlyReport getMonthlyReport(String s) {
        FileReader fileReader = new FileReader();
        lines = fileReader.readFileContents(s);
        Transaction transaction = new Transaction();
        transaction.getTransfection(lines);

       return new MonthlyReport(transaction.itemName,transaction.isExpense,transaction.quantity,transaction.unit_price);

    }
}
