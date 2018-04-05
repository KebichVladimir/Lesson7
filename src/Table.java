public class Table extends Furniture {
    private String name;
    private double area;

    public Table(String name, double area) {
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