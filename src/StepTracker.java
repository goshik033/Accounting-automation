public class StepTracker {

    private int dailyGoal = 10000;
    private static final int MONTHS = 12;
    private static final int DAYS_IN_MONTH = 30;
    private final int[][] steps = new int[MONTHS][DAYS_IN_MONTH];
    private final Converter converter = new Converter();

    public boolean addSteps(int month, int day, int value) {
        if (!isValidMonth(month) || !isValidDay(day) || value < 0) return false;
        steps[month][day] = value;
        return true;
    }

    private static boolean isValidMonth(int m) {
        return 0 <= m && m < MONTHS;
    }

    private static boolean isValidDay(int d) {
        return 0 <= d && d < DAYS_IN_MONTH;
    }


    public int getDailyGoal() {
        return dailyGoal;
    }

    public int getTotalForMonth(int month) {
        int total = 0;
        for (int step : steps[month]) {
            total += step;
        }
        return total;
    }

    public void printMonthStatistics(int month) {

        System.out.println("Количество пройденных шагов по дням за месяц: " + formatStepsByDays(month));
        System.out.println("Общее количестов шагов за месяц: " + getTotalForMonth(month));
        System.out.println("Максимальное количество шагов за месяц: " + getMaxForMonth(month));
        System.out.printf("Среднее количество шагов за месяц: %.2f%n", getAverageForMonth(month));
        System.out.println("Пройденная дистанция в км за месяц: " + getDistanceKmForMonth(month));
        System.out.println("Количество сожженных калорий за месяц: " + getCaloriesForMonth(month));
        System.out.println("Лучшая серия за месяц: " + getBestStreak(month));
    }

    public double getDistanceKmForMonth(int month) {
        Converter converter = new Converter();
        int total = getTotalForMonth(month);
        return converter.convertToKm(total);
    }

    public double getCaloriesForMonth(int month) {
        Converter converter = new Converter();
        int total = getTotalForMonth(month);
        return converter.convertToCalories(total);
    }

    public String formatStepsByDays(int month) {
        StringBuilder sb = new StringBuilder();
        for (int day = 0; day < 30; day++) {
            sb.append(day + 1).append(" день: ").append(steps[month][day]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public int getMaxForMonth(int month) {
        int max = 0;
        for (int day = 0; day < 30; day++) {
            max = Math.max(max, steps[month][day]);
        }
        return max;
    }

    public double getAverageForMonth(int month) {

        return getTotalForMonth(month) / (double) DAYS_IN_MONTH;
    }

    public int getBestStreak(int month) {
        int counter = 0;
        int maxx = 0;
        for (int day = 0; day < 30; day++) {
            if (steps[month][day] >= dailyGoal) {
                counter++;
            } else {
                maxx = Math.max(maxx, counter);
                counter = 0;
            }
        }
        maxx = Math.max(maxx, counter);
        return maxx;
    }

    public void setDailyGoal(int dailyGoal) {
        this.dailyGoal = dailyGoal;
    }
}


