package draw;

import java.util.Scanner;

public class Menu {

    //TODO: make sure that int is less than array size
    private static int drawMenu(String[] options) {
        int i = 1;
        Scanner scanner = new Scanner(System.in);
        for (String option : options) {
            System.out.println("[" + i + "] " + option);
            i++;
        }
        return scanner.nextInt();
    }

    public static int startMenu() {
        String [] startMenu = {
                "Start Game",
                "Quit"
        };
       return drawMenu(startMenu);
    }


}
