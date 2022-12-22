import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countChar = 0;
        String name = "";
        String colour = "";
        boolean err = true;
        do {
            System.out.println("Введите кол-во символов");
            countChar = scanner.nextInt();
        } while ( countChar < 1 || countChar > 100  );

        do {
            err = true;
            System.out.println("Введите название отдела");
            name = scanner.nextLine();
            if (name.replaceAll(" ", "").length() != 0 & name.replaceAll(" ", "").length() == countChar) {
                err = false;
            }
        } while ( err );

        do {
            err = true;
            System.out.println("Введите цвета");
            colour = scanner.nextLine();

            if (colour.length() == countChar) {
                err = false;
            }
        } while (err);

        String[] spla1 = name.split(" ");
        int error = 0;
        int startIndex = 0;
        for (String entry : spla1) {
            String chb1 = colour.substring(startIndex, startIndex + entry.length());
            char[] chb1Char = chb1.toCharArray();
            for (int i = 0; i < entry.length() - 2; i++) {
                if (chb1Char[i] == chb1Char[i + 1]) {
                    error++;
                    startIndex =  (startIndex + (entry.length() - 1));
                    break;
                }
            }
        }
        System.out.println(error);
    }
}
