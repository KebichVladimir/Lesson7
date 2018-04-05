public class Armchair extends Furniture {
    private String name;
    private double area;

    public Armchair(String name, double area) {
        this.name = name;
        this.area = area;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getArea() {
        return area;
    }
}
