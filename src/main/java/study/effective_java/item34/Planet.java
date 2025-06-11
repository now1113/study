package study.effective_java.item34;

public enum Planet {
    MERCURY(3.302e+23, 2.439e6),
    VENUS(4.869e+24, 6.052e6),
    EARTH(5.975e+24, 6.378e6)
    ;

    private final double mess;
    private final double radius;
    private final double surfaceGravity;

    private static final double G = 6.67300E-11;

    Planet(double mess, double radius) {
        this.mess = mess;
        this.radius = radius;
        this.surfaceGravity = G * mess / (radius * radius);
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity;
    }
}
