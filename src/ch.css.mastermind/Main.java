package ch.css.mastermind;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String[] color = {"red", "orange", "yellow", "green", "blue", "purple", "pink", "white"};
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        boolean startNew = true;
        while (startNew == true) {


            start();

            String[] generatedColors = generateRandomColors();

            for (int i = 0; i < 12; i++) {
                System.out.println("________________________________________________________________________________________");
                System.out.println("Round " + (i + 1));
                int totalCorrectPlaces = 0;
                int totalWrongPlaces = 0;


                String[] input = new String[4];


                for (int currentColor = 0; currentColor < 4; currentColor++) {
                    colorReader(input, currentColor);
                }
                String[] colorCopy = {generatedColors[0], generatedColors[1], generatedColors[2], generatedColors[3]};
                totalCorrectPlaces = correctPlace(colorCopy, input);
                totalWrongPlaces = wrongPlace(colorCopy, input);
                if (winLoose(totalWrongPlaces, totalCorrectPlaces,i,generatedColors )){
                    break;
                }
            }
            boolean playAgain = startAgain();
            if(!playAgain){
                startNew = false;
            }
        }
    }


    public static String[] generateRandomColors() {
        String[] generatedColors = new String[4];
        for (int r = 0; r < 4; r++) {
            int samecolors = 2;
            int randomNumber = 0;
            while (samecolors >= 2) {
                samecolors = 0;
                randomNumber = generateRandomNumber();
                for (int c = 0; c < 4; c++) {
                    if (color[randomNumber].equals(generatedColors[c])) {
                        samecolors++;
                    }
                }
            }
            generatedColors[r] = color[randomNumber];
           // System.out.println(generatedColors[r]);
        }
        return generatedColors;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(8);
    }

    static Scanner myObj = new Scanner(System.in);

    public static boolean startAgain() {
        String playAgain;


        System.out.println("Would you like to play again? answer with no to exit or press enter to play again.");
        playAgain = myObj.nextLine();
        if ("no".equals(playAgain.toLowerCase().trim())) {
            System.out.println("Ok.");
            boolean startNew = false;
            return false;
        }
        else {
            return true;
        }
    }
    public static void start(){
        System.out.println("For gameInstruction press i");
        System.out.println("Press enter to start.");
        String gameInstruction = myObj.nextLine();

        if ("i".equals(gameInstruction.toLowerCase().trim())) {
            System.out.println("In this game, there are 8 colors choices: red, orange, yellow, green, blue, purple, pink and white.\nThe Game generates a random assortment of 4 colors. The games objective is to guess all of the colors in the right order.\nYou have 12 rounds to guess the colors and if you can't guess them correctly in those 12 rounds ... YOU LOOSE! Press enter to start.");
        } else {
            System.out.println("Alright then lets start.");
        }

    }
    public static boolean winLoose(int totalWrongPlaces, int totalCorrectPlaces, int runden, String[] generatedColors){
        System.out.println("Amount of colors in the right place:" + totalCorrectPlaces);
        System.out.println("Amount of colors that are the right color but in the wrong place:" + totalWrongPlaces);
        if (totalCorrectPlaces == 4) {
            System.out.println("You won, congratulations.");
            return true;
        }

        if (runden == 11) {
            System.out.println("You lost, try better next time." +", "+ generatedColors[0]+ ", " + generatedColors[1] +", "+ generatedColors[2]+", " + generatedColors[3]);

        }
        return false;
    }

    public static int wrongPlace(String[] colorCopy, String[] input){
        int wrongplace = 0;
        for (int j = 0; j < 4; j++) {
            for (int v = 0; v < 4; v++) {
                if (colorCopy[v].equals(input[j])) {
                    wrongplace++;
                    colorCopy[v] = "";
                }
            }

        }
        return wrongplace;
    }
    public static int correctPlace(String[] colorCopy, String[] input){
        int correctplace = 0;
        for (int j = 0; j < 4; j++) {

            if (colorCopy[j].equals(input[j])) {

                correctplace++;
                colorCopy[j] = "";
            }
        }
        return correctplace;
    }
    public static void colorReader(String[] input, int currentColor){

        boolean correctcolor = false;
        while (!correctcolor) {
                System.out.println("Type in " + (currentColor + 1) + ". color:");
                String userInput = myObj.next();
                for (String s : color) {
                    if (s.equals(userInput.toLowerCase().trim())) {
                        correctcolor = true;
                        break;
                    }
                }
                if (!correctcolor) {
                    System.out.println("This color does not exist");
                }

                else {
                    input[currentColor] = userInput;
                }
        }
    }










}



