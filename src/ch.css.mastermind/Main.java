package ch.css.mastermind;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){


        String[] color = {"red", "orange", "yellow", "green", "blue", "purple", "pink", "white"};
        String[] generatedColors = new String[4];
        for (int i = 0; i <4 ; i++) {
            int random = (int) (4*  Math.random());
            generatedColors[i] = color[random];
            System.out.println(generatedColors[i]);
            System.out.println("Runde " + (i+1));

            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Type in color:");
            x = myObj.nextInt(); // Read user input
            System.out.println("Type in another color:");
            y = myObj.nextInt(); // Read user input



        }
    }

    
}
