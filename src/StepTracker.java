public class StepTracker {
    private int[][] steps = new int[12][30];
    private int purpose = 10000;

    public void addSteps(int step, int day, String month) {
        int monthNum = Month.fromString(month);
        if (step >= 0 && day >= 0 && day < 30 && monthNum >= 0 && monthNum < 12) {
            steps[monthNum][day] = step;
        }
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

    public void printMonthReport(String month) {
        int monthNum = Month.fromString(month);
        System.out.println("Количество пройденных шагов по дням за месяц: " + stepsPerMonth(monthNum));
        System.out.println("Общее колическтов шагов за месяц: " + total(monthNum));
        System.out.println("Максимальное количество шагов за месяц: " + getMax(monthNum));
        System.out.println("Среднее количество шагов за месяц: " + getAverage(monthNum));
        System.out.println("Пройденная дистанция в км за месяц: " + getDistance(monthNum));
        System.out.println("Количество сожженных калорий за месяц: " + getCalories(monthNum));
        System.out.println("Лучшая серия за месяц: " + bestSegment(monthNum));
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
            sb.append(day).append(" день: ").append(steps[month][day]).append(", ");
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
        return maxx;
    }

    public void setPurpose(int purpose) {
        this.purpose = purpose;
    }
}

enum Month {
    ЯНВАРЬ(0), ФЕВРАЛЬ(1), МАРТ(2), АПРЕЛЬ(3), МАЙ(4),
    ИЮНЬ(5), ИЮЛЬ(6), АВГУСТ(7), СЕНТЯБРЬ(8),
    ОКТЯБРЬ(9), НОЯБРЬ(10), ДЕКАБРЬ(11);

    private final int number;

    Month(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static int fromString(String s) {
        return Month.valueOf(s.toUpperCase()).getNumber();
    }
}
