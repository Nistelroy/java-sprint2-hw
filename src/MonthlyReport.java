import java.util.ArrayList;

public class MonthlyReport {
    ArrayList<String> lines;

    public MonthlyReport(String s) {
        FileReader fileReader = new FileReader();
        lines = fileReader.readFileContents(s);



    }
    //  название месяца;
   // самый прибыльный товар, название товара и сумму;
   // самую большую трату, название товара и сумму.
    //        🔥 Перед выполнением подсчётов необходимо проверить, что месячные отчёты были считаны из файла. В случае если этого сделано не было, нужно предложить сначала считать данные.





}
