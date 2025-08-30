import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = -1;
        StepTracker st = new StepTracker();
        while (choice != 0) {
            printMenu();
            choice = readIntInRange(sc,"Выберите пункт: ",0,4);
            switch (choice) {
                case 1:
                    int month = readMonth(sc, "Введите месяц (1-12 / название / сокращение): ");
                    int day = readIntInRange(sc, "Введите день (1-30): ", 1, 30) - 1;
                    int steps = readIntMin(sc, "Введите количество шагов (>=0): ", 0);
                    boolean ok = st.addSteps(month, day, steps);
                    System.out.println(ok ? "Записано." : "Данные не приняты.");
                    break;
                case 2:
                    int m = readMonth(sc, "Введите месяц (1-12 / название / сокращение): ");
                    st.printMonthStatistics(m);
                    break;

                case 3:
                    int newPurpose = readIntMin(sc, "Новая цель по шагам в день (>=0): ", 0);
                    st.setDailyGoal(newPurpose);
                    System.out.println("Цель обновлена: " + st.getDailyGoal());
                    break;

                case 4:
                    System.out.println("Текущая цель: " + st.getDailyGoal());
                    break;

                case 0:
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неизвестная команда, попробуйте снова.");

            }
        }


    }

    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Вывести статистику за месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Показать текущую цель");
        System.out.println("0 - Выйти");

    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return sc.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Нужно ввести число.");
                sc.nextLine();
            }
        }
    }


    private static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        while (true) {
            int v = readInt(sc, prompt);
            if (v >= min && v <= max) return v;
            System.out.printf("Число должно быть в диапазоне [%d..%d].%n", min, max);
        }
    }

    private static String readToken(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (sc.hasNext()) {
                return sc.next().trim();
            }
            sc.nextLine();
            System.out.println("Нужно ввести значение.");
        }
    }

    private static int readMonth(Scanner sc, String prompt) {
        int month;
        while (true) {
            String monthInput = readToken(sc, prompt);
            try {
                month = Month.parseMonth(monthInput);
                return month;
            } catch (IllegalArgumentException e) {
                System.out.println("Месяц не распознан. Примеры: 8, авг, август.");
            }
        }
    }

    private static int readIntMin(Scanner sc, String prompt, int min) {
        while (true) {
            int v = readInt(sc, prompt);
            if (v >= min) return v;
            System.out.printf("Число должно быть не меньше %d.%n", min);
        }
    }
}


