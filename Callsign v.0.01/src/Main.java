import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "E:/TEMP/Pet-project/file_table.txt";

        Pozivnie c = new Pozivnie();
        c.findingIndex(c.getFirstLine(), c.getSecondLine()); // Находит индексы четырех букв по таблице 35 на 35
        c.readTable(); //считываем содержимое файла file_table.txt в список строк
        c.splitTable();
        c.finding();
    }
}
