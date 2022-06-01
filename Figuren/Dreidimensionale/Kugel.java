package Dreidimensionale;

public class Kugel extends DreidimensionaleFigur
{
    private double radius;

    public Kugel(double radius)
    {
        this.radius = radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double oberflaeche() {
        return 4 * Math.PI * (this.radius * this.radius);
    }

    @Override
    public double volumen() {
        return 4 / (3 * Math.PI * (this.radius * this.radius));
    }
}
