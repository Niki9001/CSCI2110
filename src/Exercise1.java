import java.util.Scanner;
// Full Name: Niki Zheng
// ID number: B00932128

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
            //int[][] rect = new int[2][4]; -- no need 2d array
            int[] rect = new int[4];
            //int[] rect = new int[4];
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
                        if (!input[j].matches("-?\\d+")) {  // 检查是否为整数
                            validInput = false;
                            break;
                        }
                    }

                    if (validInput) {
                        for (int j = 0; j < 4; j = j + 1) {
                            rect[j] = Integer.parseInt(input[j]);  // 转换为整数并存储
                        }
                        rectangles[i] = new Rectangle1(rect[0], rect[1], rect[2], rect[3]);  // 创建Rectangle1对象
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
//        Rectangle1 r1 = new Rectangle1(rect[0], rect[1], rect[2], rect[3]);
//        Rectangle1 r2 = new Rectangle1(rect[0], rect[1], rect[2], rect[3]);
//        Rectangle1 r1 = rectangles[0];
//        Rectangle1 r2 = rectangles[1];
//        System.out.println("Test case: 1");
//        System.out.println("Rectangle 1: (" + r1.getX1() + ", " + r1.getY1() + ", " + r1.getX2() + ", " + r1.getY2() + ")");
//        System.out.println("Rectangle 2: (" + r2.getX1() + ", " + r2.getY1() + ", " + r2.getX2() + ", " + r2.getY2() + ")");
        for (int i = 1; i < inputNumPar; i++) {
            Rectangle1 r1 = rectangles[0];  // 第一个矩形
            Rectangle1 r2 = rectangles[i];  // 其他矩形

            System.out.println("Test case: " + i);
            System.out.println("Rectangle 1: (" + r1.getX() + ", " + r1.getY() + ", " + r1.getWidth() + ", " + r1.getHeight() + ")");
            System.out.println("Rectangle 2: (" + r2.getX() + ", " + r2.getY() + ", " + r2.getWidth() + ", " + r2.getHeight() + ")");

            boolean ifContain = r1.contains(r2);
            System.out.println("Is Rectangle 2 contained in Rectangle 1? " + ifContain);
        }

//            System.out.println("Rectangle 1: " + r1);
//            System.out.println("Rectangle 2: " + r2);
//
//            // use contains function
//            boolean ifContain = (r1.contains(r2) == true);
//            System.out.println("Is Rectangle 2 contained in Rectangle 1? " + ifContain);
//        for (int i = 1; i < inputNumPar; i++) {
//            boolean ifContain = rectangles[0].contains(rectangles[i]);
//            System.out.println("Is Rectangle " + (i + 1) + " contained in Rectangle 1? " + ifContain);
//        }
//        boolean ifContain = (r1.contains(r2) == true);
//        System.out.println("Is Rectangle 2 contained in Rectangle 1? " + ifContain);
//
//
        scanner.close();
    }
}