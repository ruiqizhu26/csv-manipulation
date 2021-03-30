import java.util.*;
import java.util.stream.*;
import java.io.*;

public class Interview {

    public static List<String[]> data;

    public static void main(String[] args) {
        readCSV("dodgertest.csv");
        writeCSV("ruiqidodger.csv");
    }

    public static void readCSV(String filePath) {
        data = new LinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            Object[] lines = br.lines().toArray();
            for (Object line: lines) {
                String[] entries = ((String) line).split(",");
                data.add(entries);
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void writeCSV(String filePath) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
            StringBuilder sb = new StringBuilder();
            for (String[] entries: data) {
                for (int i = entries.length - 1; i >= 0; i--) {
                    sb.append(entries[i]);
                    sb.append(",");
                }
                sb.append("\n");
            }
            bw.write(sb.toString());
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}