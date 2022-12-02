package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/main/input.txt"));
        int som = 0;
        int[] top3 = new int[3];
        String line = "";
        while (sc.hasNextLine()){
                line = sc.nextLine();
                if (line.equals("")) {
                    putInArray(som, top3);
                    som = 0;
                }
                else {
                    int x = Integer.parseInt(line);
                    som += x;
                }
        }
        putInArray(som, top3);
        int arraysom = top3[0] + top3[1] + top3[2];
        System.out.println("aantal calorien van de elfmax: " + arraysom + Arrays.toString(top3));
    }

    private static void putInArray(int som, int[] top3) {
        if (som>=top3[0]&&som<top3[1]){
            top3[0] = som;
        } else if (som>=top3[1]&&som<top3[2]){
            top3[0] = top3[1];
            top3[1] = som;
        } else if (som>=top3[2]) {
            top3[1] = top3[2];
            top3[2] = som;
        }
    }
}