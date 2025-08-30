import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = 1;

        StepTracker st = new StepTracker();
        while (choice != 0) {
            printMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Введите месяц");
                    String month = sc.next();
                    System.out.print("Введите день");
                    int day = sc.nextInt();
                    System.out.print("Введите количество шагов: ");
                    int steps = sc.nextInt();
                    st.addSteps(steps, day, month);
                    System.out.print("Записано");

                    break;
                case 2:
                    System.out.print("Введите месяц : ");
                    String m = sc.next();
                    st.printMonthReport(m);
                    break;

                case 3:
                    System.out.print("Введите новую цель по шагам: ");
                    int newPurpose = sc.nextInt();
                    st.setPurpose(newPurpose);
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
        System.out.print("Выберите пункт: ");
    }
}

