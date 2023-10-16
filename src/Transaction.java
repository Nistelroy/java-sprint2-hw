import java.util.ArrayList;

public class Transaction {
    String name;
    Boolean isExp;
    Integer quan;
    Integer unit;

    public Transaction( String name, Boolean isExp, Integer quan, Integer unit) {
        this.name = name;
        this.isExp = isExp;
        this.quan = quan;
        this.unit = unit;
    }

    public Transaction(String month, Integer sum, Boolean exp) {
        this.name = month;
        this.isExp = exp;
        this.unit = sum;
    }
}
