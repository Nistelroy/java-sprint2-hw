import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("Считать все месячные отчёты");
        //  m.202101.csv
        //   m.202102.csv
        //   m.202103.csv

        FileReader fileReader = new FileReader();

        //fileName – имя файла в папке resources
        ArrayList<String> lines = fileReader.readFileContents("m.202101.csv");



    //    String[] lineContents = line.split(",");
        while (true) {
            // Вывод доступных пунктов меню в консоль
            int userInput = scanner.nextInt();

            if (userInput = 1){
                System.out.println("Считать годовой отчёт");
            //    y.2021.csv
            }

            else if (userInput = 2) {
                System.out.println("Сверить отчёты");
            }

            else if (userInput = 3) {
            System.out.println("Вывести информацию обо всех месячных отчётах");
            }

            else if (userInput = 4) {
            System.out.println("Вывести информацию о годовом отчёте");
            }

            else if (userInput = 5) {
            System.out.println("Выйти");
                scanner.close();
                return;
            }
            else System.out.println("нет команды");


        }
    }
}

