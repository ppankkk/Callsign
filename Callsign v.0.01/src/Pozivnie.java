import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class Pozivnie {
    String pozivnoi;
    List<String> allLines;
    char char1, char2, char3, char4;
    int verticalInt1 = 0;
    int verticalInt2 = 0;
    int horizontalInt1 = 0;
    int horizontalInt2 = 0;
    String firstLine = "йцуке";
    String secondLine = "екуцй";
    String [] string0, string1, string2, string3, string4;

    Pozivnie() throws IOException {
        System.out.println("Введите исходный позывной:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        pozivnoi = reader.readLine();
        char1 = pozivnoi.charAt(0);
        char2 = pozivnoi.charAt(1);
        char3 = pozivnoi.charAt(2);
        char4 = pozivnoi.charAt(3);
    }

    void findingIndex(String s1, String s2) {
        verticalInt1 = s1.indexOf(char1);
        horizontalInt1 = s2.indexOf(char2);
        verticalInt2 = s1.indexOf(char3);
        horizontalInt2 = s2.indexOf(char4);
        System.out.println("Индекс для первой половины позывного:" + (verticalInt1 + 1) + "/" + (horizontalInt1 + 1));
        System.out.println("Индекс для второй половины позывного:" + (verticalInt2 + 1) + "/" + (horizontalInt2 + 1));
    }

    void kluchi2Lines() throws IOException {
        // Эти две строчки ключей должны меняться каждый день, иначе нет смысла...
    }

    public String getFirstLine() {
        return firstLine;
    }

    public String getSecondLine() {
        return secondLine;
    }


    void readTable() throws IOException {

        String pathStr = new File("").getAbsolutePath() + "\\resources\\file_table.txt";
        Path path = Paths.get(pathStr);

        // File newFile = new File(pathStr + "\file_table.txt");
        System.out.println("Расположение таблицы индексов: " + pathStr);
        //считываем содержимое файла в список строк
        allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

    }

    // Разбивает "List<String> allLines" на массивы с первой по пятую строку
    void splitTable() {

        string0 = allLines.get(0).split("/");
        string1 = allLines.get(1).split("/");
        string2 = allLines.get(2).split("/");
        string3 = allLines.get(3).split("/");
        string4 = allLines.get(4).split("/");
    }

    void finding() {
        String result1 = "";
        String result2 = "";
        for (int i = 0; i < 35; i++) {
            if (horizontalInt1 == 0) {
                result1 = "" + string0[verticalInt1].charAt(0) + string0[verticalInt1].charAt(1);
            } else if (horizontalInt1 == 1) {
                result1 = "" + string1[verticalInt1].charAt(0) + string1[verticalInt1].charAt(1);
            } else if (horizontalInt1 == 2) {
                result1 = "" + string2[verticalInt1].charAt(0) + string2[verticalInt1].charAt(1);
            } else if (horizontalInt1 == 3) {
                result1 = "" + string3[verticalInt1].charAt(0) + string3[verticalInt1].charAt(1);
            } else if (horizontalInt1 == 4) {
                result1 = "" + string4[verticalInt1].charAt(0) + string4[verticalInt1].charAt(1);
            }

            if (horizontalInt2 == 0) {
                result2 = "" + string0[verticalInt2].charAt(2) + string0[verticalInt2].charAt(3);
            } else if (horizontalInt2 == 1) {
                result2 = "" + string1[verticalInt2].charAt(2) + string1[verticalInt2].charAt(3);
            } else if (horizontalInt2 == 2) {
                result2 = "" + string2[verticalInt2].charAt(2) + string2[verticalInt2].charAt(3);
            } else if (horizontalInt2 == 3) {
                result2 = "" + string3[verticalInt2].charAt(2) + string3[verticalInt2].charAt(3);
            } else if (horizontalInt2 == 4) {
                result2 = "" + string4[verticalInt2].charAt(2) + string4[verticalInt2].charAt(3);
            }

        }
        System.out.println("Набранный позывной: " + result1 + result2);
    }

}