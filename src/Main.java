public class Main {
    public static void main(String[] args) {
        Building building = new Building("Жилое здание");
        try {
            building.addRoom("Жилая комната", 100, 2);
            building.addRoom("Кухня", 20, 1);
            building.add(0, new Bulb(150));
            building.add(0, new Bulb(250));
            building.add(1, new Bulb(500));
        } catch (IlluminationLimitException e) {
            e.printStackTrace();
        }
        try {
            building.add(0, new Table("Стол письменный", 13));
            building.add(0, new Armchair("Кресло мягкое и пушистое", 10));
            building.add(1, new Table("стол обеденный", 5));
            building.add(1, new Armchair("Кресло кожаное", 5));
        } catch (AreaLimitException e) {
            e.printStackTrace();
        }
        building.getInfo();
    }
}