package ch.css.mastermind;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static String[] color = {"red", "orange", "yellow", "green", "blue", "purple", "pink", "white"};
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        boolean startNew = true;
        while (startNew == true) {



            System.out.println("For gameInstruction press i");
            System.out.println("Press enter to start.");
            String gameInstruction = myObj.nextLine();

            if ("i".equals(gameInstruction.toLowerCase().trim())) {
                System.out.println("In this game, there are 8 colors choices: red, orange, yellow, green, blue, purple, pink and white. The Game" +
                        " generates a random assortment of 4 colors. The games objective is to guess all of the colors in the right order." +
                        "You have 12 rounds to guess the colors and if you can't guess them correctly in those 12 rounds ... YOU LOOSE! Press enter to start." );
            } else {
                System.out.println("Alright then lets start.");
            }


            String[] generatedColors = generateRandomColors();

            for (int i = 0; i < 12; i++) {
                System.out.println("Round " + (i + 1));
                int totalCorrectPlaces = 0;
                int totalWrongPlaces = 0;

                String[] input = new String[4];


                for (int currentcolor = 0; currentcolor < 4; currentcolor++) {
                    boolean correctcolor = false;
                    while (!correctcolor) {
                        System.out.println("Type in " + (currentcolor + 1) + ". color:");
                        String userInput = myObj.nextLine();
                        for (String s : color) {
                            if (s.equals(userInput.toLowerCase().trim())) {
                                correctcolor = true;
                                break;
                            }
                        }
                        if (!correctcolor) {
                            System.out.println("This color does not exist");

                        } else {
                            input[currentcolor] = userInput;
                        }

                        int wrongplace = 0, correctplace = 0;
                        String[] colorCopy = {generatedColors[0], generatedColors[1], generatedColors[2], generatedColors[3]};
                        for (int j = 0; j < 4; j++) {

                            if (colorCopy[j].equals(input[j])) {

                                correctplace++;
                                colorCopy[j] = "";
                            }
                        }
                        for (int j = 0; j < 4; j++) {
                            for (int v = 0; v < 4; v++) {
                                if (colorCopy[v].equals(input[j])) {
                                    wrongplace++;
                                    colorCopy[v] = "";
                                }
                            }
                        }
                        totalWrongPlaces = wrongplace;
                        totalCorrectPlaces = correctplace;
                    }
                }
                System.out.println("Amount of colors in the right place:" + totalCorrectPlaces);
                System.out.println("Amount of colors that are the right color but in the wrong place:" + totalWrongPlaces);

                if (totalCorrectPlaces == 4) {
                    System.out.println("You won, congratulations.");
                    break;
                }
                if (i == 11) {
                    System.out.println("You lost, try better next time.");

                }


            }
            String playAgain;
            System.out.println("Would you like to play again? answer with no to exit or press enter to play again.");
            playAgain = myObj.nextLine();

            if ("no".equals(playAgain.toLowerCase().trim())) {

                System.out.println("Ok.");
                startNew = false;
                break;


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
            System.out.println(generatedColors[r]);
        }
        return generatedColors;
    }

    public static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(8);
    }
}


