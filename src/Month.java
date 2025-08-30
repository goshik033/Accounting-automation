public enum Month {
    ЯНВАРЬ(0), ФЕВРАЛЬ(1), МАРТ(2), АПРЕЛЬ(3), МАЙ(4),
    ИЮНЬ(5), ИЮЛЬ(6), АВГУСТ(7), СЕНТЯБРЬ(8), ОКТЯБРЬ(9), НОЯБРЬ(10), ДЕКАБРЬ(11);

    private final int number;

    Month(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    public static int parseMonth(String s) {
        if (s == null || s.isBlank()) throw new IllegalArgumentException("Пустое значение месяца");
        String t = s.trim().toUpperCase();


        try {
            int num = Integer.parseInt(t);
            if (1 <= num && num <= 12) return num - 1;
        } catch (NumberFormatException ignore) {
        }

        for (Month m : values()) {
            if (t.equals(m.name()) || t.startsWith(m.name().substring(0, 3))) {
                return m.number;
            }
        }
        throw new IllegalArgumentException("Неизвестный месяц: " + s);
    }
}