import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<MonthlyReport> monthlyReports;

    //    FileReader fileReader = new FileReader();

        //fileName – имя файла в папке resources
        //   ArrayList<String> lines = fileReader.readFileContents("m.202101.csv");

    //    System.out.println(lines);
     //   String[] lineContents = lines.get(1).split(",");
     //   System.out.println(lineContents[0]);

        //    String[] lineContents = line.split(",");


        while (true) {
            // Вывод доступных пунктов меню в консоль
            printMenu();
            int userInput = scanner.nextInt();
            if (userInput == 1) {
                System.out.println("За какой год считать все месячные отчёты ? ex.(2021)");
                userInput = scanner.nextInt();
                if (userInput == 2021) {
                    monthlyReports = new ArrayList<>(12);
                for (int i = 0; i < 12; i++) {
                    if (i < 9) {
                        MonthlyReport monthlyReport = new MonthlyReport("m." + userInput + "0" + (i + 1) +".csv");
                        monthlyReports.add(monthlyReport);
                    } else {
                        MonthlyReport monthlyReport = new MonthlyReport("m." + userInput + (i + 1) + ".csv");
                        monthlyReports.add(monthlyReport);
                    }
                    if (monthlyReports.get(i).lines.isEmpty()){
                        break;
                    }
                }
                    System.out.println("Готово!\n");
                } else System.out.println("Нет отчётов за этот год\n");


                //  m.202101.csv
                //   m.202102.csv
                //   m.202103.csv
            }

            else if (userInput == 2){
                System.out.println("Считать годовой отчёт");
            //    y.2021.csv
            }

            else if (userInput == 3) {
                System.out.println("Сверить отчёты");
            }

            else if (userInput == 4) {
            System.out.println("Вывести информацию обо всех месячных отчётах");
            }

            else if (userInput == 5) {
            System.out.println("Вывести информацию о годовом отчёте");
            }

            else if (userInput == 6) {
            System.out.println("Выйти");
                scanner.close();
                return;
            }
            else System.out.println("нет команды");


        }
    }
    private static void printMenu(){
        System.out.println("Выберите пункт меню и введите его номер:");
        System.out.println("'1' -Считать все месячные отчёты");
        System.out.println("'2' -Считать годовой отчёт");
        System.out.println("'3' -Сверить отчёты");
        System.out.println("'4' -Вывести информацию обо всех месячных отчётах");
        System.out.println("'5' -Вывести информацию о годовом отчёте");
        System.out.println("'6' -Выйти");


    }
}

