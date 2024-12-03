import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DayOneTwo{
    public static void main(String[] args) {
        ArrayList<Integer> column1 = new ArrayList<>();
        ArrayList<Integer> column2 = new ArrayList<>();

        String filePath = "data.txt"; 

        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split("\\s+");
                column1.add(Integer.parseInt(columns[0]));
                column2.add(Integer.parseInt(columns[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
            e.printStackTrace();
        }
        for (int i = 1; i < column1.size(); i++) {
            int key = column1.get(i);
            int j = i - 1;

            while (j >= 0 && column1.get(j) > key) {
                column1.set(j + 1, column1.get(j));
                j--;
            }
            column1.set(j + 1, key);
        }
        for (int i = 1; i < column2.size(); i++) {
            int key = column2.get(i);
            int j = i - 1;

            while (j >= 0 && column2.get(j) > key) {
                column2.set(j + 1, column2.get(j));
                j--;
            }
            column2.set(j + 1, key);
        }
        int sim = 0;
        for(int i=0; i<column1.size(); i++){
            int num = column1.get(i);
            int count = 0;
            for(int k=0; k<column2.size(); k++){
                if(num==(column2.get(k))){
                    count++;
                }
            }
            sim += (num*count);
        }
        System.out.println(sim);
    }
}
