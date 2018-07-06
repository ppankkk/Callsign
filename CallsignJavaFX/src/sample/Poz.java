package sample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import sample.Controller;

public class Poz {

    Controller contr = new Controller();
    String pozivnoi = contr.getCallsignTextField();
     List<String> allLines;
     char ch1;
     char ch2;
     char ch3;
     char ch4;
     int v1 = 0;
     int v2 = 0;
     int h1 = 0;
     int h2 = 0;
     String firstLine;
     String secondLine;

     String[] s0, s1, s2, s3, s4;

    String fileName = "/home/vovan/Projects/Pet-project callsign/file_table.txt";
     String result1 = "";
     String result2 = "";


    Poz () throws IOException {
       // System.out.println("Введите исходный позывной:");
        //BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        //pozivnoi = r.readLine();




    }



    void init() {

        ch1 = pozivnoi.charAt(0);
        ch2 = pozivnoi.charAt(1);
        ch3 = pozivnoi.charAt(2);
        ch4 = pozivnoi.charAt(3);
    }

     void findingIndex(String s1, String s2) {
        v1 = s1.indexOf(ch1);
        h1 = s2.indexOf(ch2);
        v2 = s1.indexOf(ch3);
        h2 = s2.indexOf(ch4);
        //System.out.println("Индекс для первой половины позывного:" + (v1+1)  + "/" + (h1+1));
        //System.out.println("Индекс для второй половины позывного:" + (v2+1)  + "/" + (h2+1));
    }

     void kluch() throws IOException {

        System.out.println("Введите первую строку секретной таблицы:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        firstLine = reader.readLine();

        System.out.println("Введите вторую строку секретной таблицы:");
        secondLine = reader.readLine();
    }
    public  String getFirstLine() {
        return firstLine;
    }

    public  String getSecondLine() {
        return secondLine;
    }


     void readTable(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        //считываем содержимое файла в список строк
        allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

    }
     void splitTable() {

        s0 = allLines.get(0).split("/");
        s1 = allLines.get(1).split("/");
        s2 = allLines.get(2).split("/");
        s3 = allLines.get(3).split("/");
        s4 = allLines.get(4).split("/");
    }

     void finding() {

        for (int i = 0; i < 35; i++) {
            if (v1 == 0) {
                result1 = "" + s0[h1].charAt(0) + s0[h1].charAt(1);
            } else if (v1 == 1) {
                result1 = "" + s1[h1].charAt(0) + s1[h1].charAt(1);
            } else if (v1 == 2) {
                result1 = "" + s2[h1].charAt(0) + s2[h1].charAt(1);
            } else if (v1 == 3) {
                result1 = "" + s3[h1].charAt(0) + s3[h1].charAt(1);
            } else if (v1 == 4) {
                result1 = "" + s4[h1].charAt(0) + s4[h1].charAt(1);
            }

            if (v2 == 0) {
                result2 = "" + s0[h2].charAt(2) + s0[h2].charAt(3);
            } else if (v2 == 1) {
                result2 = "" + s1[h2].charAt(2) + s1[h2].charAt(3);
            } else if (v2 == 2) {
                result2 = "" + s2[h2].charAt(2) + s2[h2].charAt(3);
            } else if (v2 == 3) {
                result2 = "" + s3[h2].charAt(2) + s3[h2].charAt(3);
            } else if (v2 == 4) {
                result2 = "" + s4[h2].charAt(2) + s4[h2].charAt(3);
            }
        }
        System.out.println("Набранный позывной: " + result1 + result2);

    }

    public String resultCallsign() {
        init();
        findingIndex(firstLine, secondLine);
        try {
            readTable(fileName);
        } catch (IOException e) {
            System.out.println("Ошибка здесь!!!");
            e.printStackTrace();
        }
        splitTable();
        finding();

        return result1 + result2;
    }
}
