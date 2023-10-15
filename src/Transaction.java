import java.util.ArrayList;

public class Transaction {
    ArrayList<String> name = new ArrayList<>();
    ArrayList<Boolean> isExpense = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    ArrayList<Integer> unit_price = new ArrayList<>();

    public void getTransfectionMonth(ArrayList<String> lines) {
        if (!(lines.isEmpty())){
            for (int i = 1; i < lines.size(); i++) {
                String[] lineContents = lines.get(i).split(",");
                 name.add(lineContents[0]);
                 isExpense.add(Boolean.valueOf(lineContents[1]));
                 quantity.add(Integer.valueOf(lineContents[2]));
                 unit_price.add(Integer.valueOf(lineContents[3]));
            }
        }
    }

    public void getTransfectionYear(ArrayList<String> lines) {
        if (!(lines.isEmpty())){
            for (int i = 1; i < lines.size(); i++) {
                String[] lineContents = lines.get(i).split(",");
                name.add(lineContents[0]);
                unit_price.add(Integer.valueOf(lineContents[1]));
                isExpense.add(Boolean.valueOf(lineContents[2]));
            }
    }
}
}
