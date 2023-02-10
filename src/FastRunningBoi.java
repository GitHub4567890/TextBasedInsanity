import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class FastRunningBoi {
    public static void main(String[] args) {
        ArrayList<String> aAAAAAAAAA = new ArrayList<String>(Arrays.asList("R1", "R2", "R3", "R4", "_", "_", "B1", "B2", "B3", "B4"));
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to this random game in Mr.Folwell's aunt's can.");
        String userMove = "";
        String userDirection = "";
        int hops = 0;
        while (!userMove.equalsIgnoreCase("X")) {
            System.out.println(aAAAAAAAAA);
            System.out.print("Which piece would you like to move? X to exit: ");
            userMove = scan.nextLine();
            if (aAAAAAAAAA.indexOf(userMove) == -1) {
                System.out.println("Please enter R/B1, R/B2, R/B3, or R/B4");
                continue;
            }
            if (userMove.contains("R")) {
                userDirection = "R";
            } else {
                userDirection = "L";
            }
            System.out.println("Number of hops? (1/2)");
            hops = scan.nextInt();
            if (hops != 1 && hops != 2) {
                System.out.println("Please enter 1 or 2");
                continue;
            }
            move(aAAAAAAAAA, userMove, userDirection, hops);
            if (won(aAAAAAAAAA)) {
                System.out.println("Congrats you won!");
                break;
            }
        }
    }
    public static void move(ArrayList<String> a, String item, String direction, int hops) {
        int itemLoc = a.indexOf(item);
        int destinationPos = 0;
        if (direction.equals("R")) {
            destinationPos = itemLoc + hops;
        } else if (direction.equals("L")) {
            destinationPos = itemLoc - hops;
        }
        if (destinationPos != -1 && destinationPos != a.size()) {
            if (a.get(destinationPos).equals("_")) {
                a.set(destinationPos, a.get(itemLoc));
                a.set(itemLoc, "_");
            } else {
                System.out.println("Space already filled!");
            }
        } else {
            System.out.println("Can not move outside of board!");
        }
    }

    public static boolean won(ArrayList<String> aaa) {
        boolean won = true;
        for (int i = 0; i <= 3; i++) {
            if (aaa.get(i).contains("R") || aaa.get(i).contains("_")) {
                return false;
            }
        }
        return won;
    }
}
