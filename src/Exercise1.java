import java.util.Scanner;

public class Exercise1{
    public static void main(String[] args){
        // new a scanner
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many rectangles would you like to input?");
        // parse input to int
        int inputNumPar = Integer.parseInt(scanner.nextLine());
        // new a rect
        Rectangle1[] rectangles = new Rectangle1[inputNumPar];


        for (int i = 0; i < inputNumPar; i = i + 1){
            // use array to input
            //int[] rect1 = new int[4];
            //int[] rect2 = new int[4];
            //int[][] rect = new int[2][4]; --no need 2d array
            int[] rect = new int[4];
            // use for loop to use those code twice no need to use k anymore
            //for (int k = 0; k < 2; k++) {
                // use while true to allow user input, if there is a typo
            while (true) {
                System.out.println("Please input rectangle " + (i + 1) + " (format: x1 y1 x2 y2): ");
                String[] input = scanner.nextLine().split(" ");
                // check input length
                if (input.length == 4) {
                    boolean validInput = true;
                    for (int j = 0; j < 4; j++) {
                        if (!input[j].matches("-?\\d+")) {
                            validInput = false;
                            break;
                        }
                    }

                    if (validInput) {
                        for (int j = 0; j < 4; j = j + 1) {
                            rect[j] = Integer.parseInt(input[j]);
                        }
                        rectangles[i] = new Rectangle1(rect[0], rect[1], rect[2], rect[3]);
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
//            Rectangle1 r1 = new Rectangle1(rect[0], rect[1], rect[2], rect[3]);
//            Rectangle1 r2 = new Rectangle1(rect[0], rect[1], rect[2], rect[3]);

//            System.out.println("Rectangle 1: " + r1);
//            System.out.println("Rectangle 2: " + r2);
//
//            // use contains function
//            boolean ifContain = (r1.contains(r2) == true);
//            System.out.println("Is Rectangle 2 contained in Rectangle 1? " + ifContain);
        for (int i = 1; i < inputNumPar; i++) {
            boolean ifContain = rectangles[0].contains(rectangles[i]);
            System.out.println("Is Rectangle " + (i + 1) + " contained in Rectangle 1? " + ifContain);
        }

        scanner.close();
    }
}