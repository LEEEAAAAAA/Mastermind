package ch.css.mastermind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String[] color = {"red", "orange", "yellow", "green", "blue", "purple", "pink", "white"};


        String[] generatedColors = new String[4];
        for (int i = 0; i < 4; i++) {
            int random = (int) (4 * Math.random());
            generatedColors[i] = color[random];
            System.out.println(generatedColors[i]);
        }
        for (int i = 0; i < 12; i++) {
            System.out.println("Round " + (i + 1));


            String[] input = new String[4];

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object

            for (int currentcolor = 0; currentcolor < 4; currentcolor++) {
                boolean correctcolor = false;
                while (!correctcolor) {
                    System.out.println("Type in " + (currentcolor + 1) + ". color:");
                    String userInput = myObj.nextLine();
                    for (int c = 0; c < color.length; c++) {
                        if (color[c].equals(userInput.toLowerCase())) {
                            correctcolor = true;
                        }
                    }
                    if (!correctcolor) {
                        System.out.println("This color does not exist");

                    } else {
                        input[currentcolor] = userInput;
                    }

                }
            }

            int correctcolor = 0, correctplace = 0;
            for (int j = 0; j < 4; j++){
                if (input[j].equals(generatedColors[j])) {
                    correctplace++;
                }
                for (int v = 0; v < 4; v++) {
                if (input[j].equals(generatedColors[v])) {
                    correctcolor++;
                }

            }
        }

        System.out.println(correctplace);
        System.out.println(correctcolor);

    }


}
}


