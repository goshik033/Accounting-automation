public class Converter {
    private static final double STEP_CM = 75.0;
    private static final double CM_IN_KM = 100_000.0;
    private static final double CAL_PER_STEP = 50.0;
    private static final double CAL_IN_KCAL = 1_000.0;


    public double convertToKm(int steps) {
        return (steps * STEP_CM) / CM_IN_KM;
    }

    public double convertToCalories(int steps) {
        return (steps * CAL_PER_STEP) / CAL_IN_KCAL;
    }
}
