import java.util.Scanner;

public class Converter {
    Scanner scanner = new Scanner(System.in);

    public void KiloMiters(int allStepsPerMonth) {
        System.out.println("Пройденная дистанция в км. составляет: " + (allStepsPerMonth * 0.00075));
    }

    public void KilocaLories(int allStepsPerMonth) {
        System.out.println("Количество сожжённых килокалорий составляет: " + (allStepsPerMonth * 0.05) );
    }
}
