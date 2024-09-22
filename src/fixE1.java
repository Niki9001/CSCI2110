import java.util.Scanner;

public class fixE1{
    public static void main(String[] args){
        // new a scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many time would you like to compare: ");

        // parse input to int
        int inputNumPar = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= inputNumPar; i = i + 1){
            System.out.println("Test case: " + i);
            // use array to input
            //int[] rect1 = new int[4];
            //int[] rect2 = new int[4];
            int[][] rect = new int[2][4];
            // use for loop to use those code twice
            for (int k = 0; k < 2; k++) {
                // use while true to allow user input, if there is a typo

                while (true) {
                    System.out.println("Please input for rectangle " + (k + 1) + ": ");
                    String[] input = scanner.nextLine().split(" ");
                    // check length
                    if (input.length == 4) {
                        boolean lengthValid = true;
                        // check if input is int
                        for (int j = 0; j < 4;j = j + 1) {
                            if (!input[j].matches("-?\\d+")) {
                                lengthValid = false;
                                break;
                            }
                        }

                        // if valid
                        if (lengthValid == true) {
                            for (int j = 0; j < 4; j++) {
                                rect[k][j] = Integer.parseInt(input[j]);
                            }
                            break;
                        } else {
                            System.out.println("Please re-input valid integers.");
                        }
                    } else {
                        System.out.println("Please input exactly 4 integers.");
                    }
                }
            }

            // new 2 rectangele objects
            Rectangle1 r1 = new Rectangle1(rect[0][0], rect[0][1], rect[0][2], rect[0][3]);
            Rectangle1 r2 = new Rectangle1(rect[1][0], rect[1][1], rect[1][2], rect[1][3]);

//            System.out.println("Rectangle 1: " + r1);
//            System.out.println("Rectangle 2: " + r2);
            boolean isContained = (r1.contains(r2) == true);
            System.out.println("Is Rectangle 2 contained in Rectangle 1? " + isContained);
            System.out.println("\n");

        }

        scanner.close();
    }
}