public record Rectangle(double height, double base) implements GeometricForm {

    @Override
    public double getArea() {
        return height * base;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "height=" + height +
                ", base=" + base +
                '}';
    }

}
