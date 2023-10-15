import java.util.ArrayList;

public class ReportEngines {


    public Object getReports(String s) {
        char first = s.charAt(0);

        if (Character.toString(first).equals("m")) {
        FileReader fileReader = new FileReader();
        ArrayList<String> lines = fileReader.readFileContents(s);
        Transaction transaction = new Transaction();
        transaction.getTransfectionMonth(lines);

       return new MonthlyReport(transaction.name,transaction.isExpense,transaction.quantity,transaction.unit_price);


        } else if (Character.toString(first).equals("y")) {
            FileReader fileReader = new FileReader();
            ArrayList<String> lines = fileReader.readFileContents(s);
            Transaction transaction = new Transaction();
            transaction.getTransfectionYear(lines);

            return new YearlyReport(transaction.name,transaction.isExpense,transaction.unit_price);
        }
        System.out.println("Ошибка чтения отчёта");
        return null;
    }
}
