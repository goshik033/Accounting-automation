public class Converter {
    public double convertToKm(int steps) {
        return steps * 75.0 / 100000;
    }

    public double convertToCalories(int steps) {
        return steps * 50.0 / 1000;
    }
}
