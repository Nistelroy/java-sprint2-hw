import java.util.ArrayList;

public class ReportEngines {

    public Object getReports(String s) {

        FileReader fileReader = new FileReader();
        Transaction transaction = new Transaction();

        char first = s.charAt(0);

        if (Character.toString(first).equals("m")) {
            ArrayList<String> lines = fileReader.readFileContents(s);
            transaction.getTransfectionMonth(lines);

          return new MonthlyReport(transaction.nameEntity,transaction.isExpense,transaction.quantity,transaction.unit_price);
        }

        else if (Character.toString(first).equals("y")) {
            ArrayList<String> lines = fileReader.readFileContents(s);
            transaction.getTransfectionYear(lines);

          return new YearlyReport(transaction.nameEntity,transaction.isExpense,transaction.unit_price);
        } else
            return null;

    }
}
