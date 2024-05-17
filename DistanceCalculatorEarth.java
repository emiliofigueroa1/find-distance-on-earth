public class DistanceCalculatorEarth {
    private double DISTANCE;
    private static final double EARTH = 6371;

    private void haversineFormula(double latA, double lonA, double latB, double lonB) {
        latA = Math.toRadians(latA);
        lonA = Math.toRadians(lonA);
        latB = Math.toRadians(latB);
        lonB = Math.toRadians(lonB);

        double latDiff = latA - latB;
        double lonDiff = lonA - lonB;

        double formulaA = Math.pow(Math.sin(latDiff / 2), 2)
                + Math.cos(latA) * Math.cos(latB) * Math.pow(Math.sin(lonDiff / 2), 2);

        double formulaB = Math.sqrt(formulaA);

        DISTANCE = EARTH * 2 * Math.asin(formulaB);
    }

    public double getDistanceKilometers() {
        return DISTANCE;
    }

    public double getDistanceMiles() {
        return DISTANCE / 1.609;
    }

    public DistanceCalculatorEarth(double lat1, double lat2, double lon1, double lon2) {
        haversineFormula(lat1, lon1, lat2, lon2);
    }
}
