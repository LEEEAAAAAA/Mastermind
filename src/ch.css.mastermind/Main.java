package ch.css.mastermind;

public class Main {
    public static void main(String[] args){


        String[] color = {"red", "orange", "yellow", "green", "blue", "purple", "pink", "white"};
        String[] generatedColors = new String[4];
        for (int i = 0; i <4 ; i++) {
            int random = (int) (4*  Math.random());
            generatedColors[i] = color[random];
            System.out.println(generatedColors[i]);
            System.out.println("Runde " + (i+1));





        }
    }

    
}
