import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        PasswordChecker passCheck = new PasswordChecker();
        Scanner scannerInt = new Scanner(System.in);

        try {
            System.out.println("Введите мин. длину пароля:");
            passCheck.setMinLenght(scannerInt.nextInt());
            System.out.println("Введите макс. допустимое количество повторений символа подряд: ");
            passCheck.setMaxLength(scannerInt.nextInt());
        } catch (IllegalArgumentException e){
            System.out.print("Ошибка: " + e.getMessage());
            return;
        }

        while (true){
            Scanner scannerStr = new Scanner(System.in);
            System.out.println("Введите пароль или end: ");
            String password = scannerStr.nextLine();
            if (password.equals("end")){
                System.out.print("Программа завершена");
                break;
            }
            if (passCheck.verify(password)){
                System.out.println("Подходит!");
            }
            else {
                System.out.println("Не подходит!");
            }
        }
    }
}