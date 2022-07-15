import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        StepTracker StepTracker = new StepTracker();
        Converter Converter = new Converter();
        Scanner scanner = new Scanner(System.in);

        printMenu();
        int userInput = scanner.nextInt();

        while(userInput != 0) {
            if (userInput == 1) {
                StepTracker.dayStep(scanner);
            } else if (userInput == 2) {
                int month = StepTracker.showMeEveryDay(scanner);
                int allStepsPerMonth = StepTracker.MonthStatic(month);
                Converter.KiloMiters(allStepsPerMonth);
                Converter.KilocaLories(allStepsPerMonth);
            }
            printMenu(); // печатем меню ещё раз перед завершением предыдущего действия
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена.");
    }
    private static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}
