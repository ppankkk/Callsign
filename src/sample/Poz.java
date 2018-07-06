package sample;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Poz {


    public String pozivnoi;
    List<String> allLines;
    char ch1;
    char ch2;
    char ch3;
    char ch4;
    int v1 = 0;
    int v2 = 0;
    int h1 = 0;
    int h2 = 0;
    public String firstLine;
    public String secondLine;

    String[][] stringsLines = new String[35][35];

//    String fileName = "/home/vovan/Projects/Pet-project callsign/file_table_old.txt";
    String fileName = String.valueOf(Main.class.getResource("file_table_old.txt"));
    String result1 = "";
    String result2 = "";


    Poz() throws IOException {
    }

    public void init(String pozivnoii) {
        pozivnoi = pozivnoii;
        ch1 = pozivnoi.charAt(0);
        ch2 = pozivnoi.charAt(1);
        ch3 = pozivnoi.charAt(2);
        ch4 = pozivnoi.charAt(3);
    }

    public void findingIndex(String s1, String s2) {
        v1 = s1.indexOf(ch1);
        h1 = s2.indexOf(ch2);
        v2 = s1.indexOf(ch3);
        h2 = s2.indexOf(ch4);
        //System.out.println("Индекс для первой половины позывного:" + (v1+1)  + "/" + (h1+1));
        //System.out.println("Индекс для второй половины позывного:" + (v2+1)  + "/" + (h2+1));
    }

    public void kluch() throws IOException {

        System.out.println("Введите первую строку секретной таблицы:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        firstLine = reader.readLine();

        System.out.println("Введите вторую строку секретной таблицы:");
        secondLine = reader.readLine();
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }


    public void readTable(String fileName) throws IOException {

        Path path = Paths.get(fileName);
        //convert file_table_old.txt to the List<String>
        allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

    }

    public void splitTable() {
        // new part
        for (int i = 0; i < stringsLines.length; i++) {
            stringsLines[i] = allLines.get(i).split("/");
        }
    }


        public String finding() {
            for (int i = 0; i < stringsLines.length; i++) {
                if (v1 == i) {
                    result1 = "" + stringsLines[i][h1].charAt(0) + stringsLines[i][h1].charAt(1);
                }

                if (v2 == i) {
                    result2 = "" + stringsLines[i][h2].charAt(2) + stringsLines[i][h2].charAt(3);
                }
            }
            return result1 + result2;
        }

        public String resultCallsign () {
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

