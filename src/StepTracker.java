public class StepTracker {

    private int purpose = 10000;
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


    public int getPurpose() {
        return purpose;
    }

    public int total(int month) {
        int total = 0;
        for (int step : steps[month]) {
            total += step;
        }
        return total;
    }

    public void printMonthReport(int month) {

        System.out.println("Количество пройденных шагов по дням за месяц: " + stepsPerMonth(month));
        System.out.println("Общее колическтов шагов за месяц: " + total(month));
        System.out.println("Максимальное количество шагов за месяц: " + getMax(month));
        System.out.println("Среднее количество шагов за месяц: " + getAverage(month));
        System.out.println("Пройденная дистанция в км за месяц: " + getDistance(month));
        System.out.println("Количество сожженных калорий за месяц: " + getCalories(month));
        System.out.println("Лучшая серия за месяц: " + bestSegment(month));
    }

    public double getDistance(int month) {
        Converter converter = new Converter();
        int total = total(month);
        return converter.convertToKm(total);
    }

    public double getCalories(int month) {
        Converter converter = new Converter();
        int total = total(month);
        return converter.convertToCalories(total);
    }

    public String stepsPerMonth(int month) {
        StringBuilder sb = new StringBuilder();
        for (int day = 0; day < 30; day++) {
            sb.append(day + 1).append(" день: ").append(steps[month][day]).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }

    public int getMax(int month) {
        int max = 0;
        for (int day = 0; day < 30; day++) {
            max = Math.max(max, steps[month][day]);
        }
        return max;
    }

    public int getAverage(int month) {
        return total(month) / 30;
    }

    public int bestSegment(int month) {
        int counter = 0;
        int maxx = 0;
        for (int day = 0; day < 30; day++) {
            if (steps[month][day] > purpose) {
                counter++;
            } else {
                maxx = Math.max(maxx, counter);
                counter = 0;
            }
        }
        maxx = Math.max(maxx, counter);
        return maxx;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
    }
}


