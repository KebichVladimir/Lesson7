import java.util.ArrayList;

public class Building {
    private String name;
    private ArrayList<Room> roomsList = new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    public void addRoom(String name, double area, int windows) throws IlluminationLimitException {
        roomsList.add(new Room(name, area, windows));
    }

    public void add(int roomIndex, Bulb bulb) throws IlluminationLimitException {
        roomsList.get(roomIndex).addBulb(bulb);
    }

    public void add(int roomIndex, Furniture furniture) throws AreaLimitException {
        roomsList.get(roomIndex).addFurniture(furniture);
    }

    public void getInfo() {
        System.out.println(name);
        for (Room room : roomsList) {
            System.out.println(room.getName());
            System.out.print("Освещённость = " + (room.qetLuminosityWindows() + room.qetLuminosityBulbs()) + " лк (" + room.getWindows() + " окна по 700 лк, лампочки ");
            for (Bulb bulb : room.getBulbsList()) {
                System.out.print(bulb.getLuminosity() + " лк ");
            }
            System.out.print(")");
            System.out.println("\nПлощадь = " + room.getArea() + "м2 (занято " + room.getSumFurnitureArea() + "м2, свободно " + (room.getArea() - room.getSumFurnitureArea()) + "м2 или " + (room.getArea() - room.getSumFurnitureArea()) / room.getArea() * 100 + "% площади)");
            System.out.println("Мебель:");
            if (!room.getFurnitureList().isEmpty()) {
                for (Furniture furniture : room.getFurnitureList())
                    System.out.println(furniture.getName() + " (площадь" + furniture.getArea() + "м2)");
            } else System.out.println("Мебели нет");
        }
    }
}


