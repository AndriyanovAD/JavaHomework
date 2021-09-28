public class HomeWorkApps {
            public static void main(String[] args) {
            printThreeWords();

            System.out.println("*********************");

            if (checkSumSign(12, 0)) {
                System.out.println("Сумма отрицательная");
            } else {
                System.out.println("Сумма положительная");
            }
            System.out.println("*********************");
            printcolor(99);

            System.out.println("*********************");

            compareNumbers(35, 25);
        }

        // №2
        public static void printThreeWords() {
            System.out.println("_Orange");
            System.out.println("_Banana");
            System.out.println("_Apple");
        }

        // №3
        public static boolean checkSumSign(int a, int b) {
            return (a + b) < 0;
        }

        // №4
        public static void printcolor(int a) {
            if (a <= 0) {
                System.out.println("Red");
            } else if (a > 100) {
                System.out.println("Green");
            } else {
                System.out.println("Yellow");
            }
        }

        // №5
        public static void compareNumbers(int a, int b) {
            if (a < b) {
                System.out.println("a < b");
            } else {
                System.out.println("a >= b");
            }
        }
}


