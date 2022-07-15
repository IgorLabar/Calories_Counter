import java.util.Scanner;
import java.util.HashMap;

public class StepTracker {

    Scanner scanner = new Scanner(System.in);
    int stepPerDay = 10000; // Количество шагов по умолчанию.
    static HashMap<Integer, String> monthToData = new HashMap<>();
    int[] stepOfEachDay = new int[360];

    public StepTracker() {
        monthToData.put(0, " Январь");
        monthToData.put(1, " Февраль");
        monthToData.put(2, " Март");
        monthToData.put(3, " Апрель");
        monthToData.put(4, " Май");
        monthToData.put(5, " Июнь");
        monthToData.put(6, " Июль");
        monthToData.put(7, " Август");
        monthToData.put(8, " Сентябрь");
        monthToData.put(9, " Октябрь");
        monthToData.put(10, " Ноябрь");
        monthToData.put(11, " Декабрь");
    }

    int dayStep(Scanner scanner) { // Метод для регистрации шагов в массив.
        System.out.println("За какой месяц вы хотите ввести шаги?" + monthToData);
        int month = scanner.nextInt();
        if (month < 0) {
            System.out.println("Месяц не может быть отрицательным.");
            return 0;
        } else if (month > 11) {
            System.out.println("Месяцев может быть только 12, больше быть не может.");
            return 0;
        }
        System.out.println("Месяц " + monthToData.get(month) + " .За какое число этого месяца вы хотите ввести шаги?");
        int day = scanner.nextInt();
        if (day < 1) {
            System.out.println("День не может быть отрицательным.");
        } else if (day > 30) {
            System.out.println("Дней всего 30, больше быть не может");
            return 0;
        }
        System.out.println("День " + day + " усвоен. Введите количество шагов.");
        int stepThisDay = scanner.nextInt();
        if (stepThisDay < 0) {
            System.out.println("Шаги не могут быть отрицательными.");
            return 0;
        }
        stepOfEachDay[(month - 1) * 30 + (day - 1)] = stepOfEachDay[(month - 1) * 30 + (day - 1)] + stepThisDay;
        System.out.println("Значение в " + stepOfEachDay[(month - 1) * 30 + (day - 1)] + " шагов, проделанных " + day + monthToData.get(month) + " сохранено в календарь!");
        if (stepThisDay >= stepPerDay) {
            System.out.println("Цель достигнута.");
        } else {
            System.out.println("Цель не достигнута.");
        }
        return 0;
    }
    public int showMeEveryDay(Scanner scanner) {

        System.out.println("За какой месяц вы хотите получить статистику?" + monthToData);
        int month = scanner.nextInt();
        if (month > 11) {
            System.out.println("Месяцев может быть только 12, больше быть не может.");
        } else if (month < 0) {
            System.out.println("Месяц не может быть отрицательным.");
        } else {
            System.out.println("Количество пройденных шагов по дням:");
            for (int i = 1; i < 30; i++) {
                if (stepOfEachDay[i + (month + 1) * 30] >= stepPerDay) {
                    System.out.println("Цель достигнута!");
                }else {
                    System.out.println("День " + i + " было сделано " + stepOfEachDay[i + (month - 1) * 30] + " шагов.");
                }
            }
        }
                return month;
    }
    public int MonthStatic(int month) {
        int allStepsPerMonth = 0;
        for (int i = 0; i < 30; i++){
            allStepsPerMonth = allStepsPerMonth + stepOfEachDay[i + (month - 1) * 30];
        }
        System.out.println("Количество шагов за весь месяц составляет " + allStepsPerMonth);

        int maxDayStep = 0;
        for (int i = 0; i < 30; i++) {
            if ((stepOfEachDay[i + (month - 1) * 30]) > maxDayStep) {
                maxDayStep = stepOfEachDay[i + (month - 1) * 30];
            }
        }
        System.out.println("Максимальное количество шагов в одном дне месяца составляет: " + maxDayStep);
        System.out.println("Среднее количество шагов в " + monthToData.get(month) + " составляет: " + (allStepsPerMonth / 30));

        return allStepsPerMonth;
    }
}