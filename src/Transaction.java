import java.util.ArrayList;
import java.util.Arrays;

public class Transaction {
    ArrayList<String> itemName = new ArrayList<>();
    ArrayList<Boolean> isExpense = new ArrayList<>();
    ArrayList<Integer> quantity = new ArrayList<>();
    ArrayList<Integer> unit_price = new ArrayList<>();

    public void getTransfection(ArrayList<String> lines) {
        if (!(lines.isEmpty())){
            for (int i = 1; i < lines.size(); i++) {
                String[] lineContents = lines.get(i).split(",");
                 itemName.add(lineContents[0]);
                 isExpense.add(Boolean.valueOf(lineContents[1]));
                 quantity.add(Integer.valueOf(lineContents[2]));
                 unit_price.add(Integer.valueOf(lineContents[3]));
        }

        }

    }
}
