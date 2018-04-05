import java.util.ArrayList;

public class Room {
    private String name;
    private double area;
    private int windows;
    private ArrayList<Bulb> bulbsList = new ArrayList<>();
    private ArrayList<Furniture> furnitureList = new ArrayList<>();

    public Room(String name, double area, int windows) {
        this.name = name;
        this.area = area;
        this.windows = windows;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public int getWindows() {
        return windows;
    }

    public ArrayList<Bulb> getBulbsList() {
        return bulbsList;
    }

    public ArrayList<Furniture> getFurnitureList() {
        return furnitureList;
    }

    public void illuminationTest() throws IlluminationLimitException {
        int sumLuminosity = 0;
        for (Bulb bulb : bulbsList) {
            sumLuminosity += bulb.getLuminosity();
        }
        sumLuminosity = sumLuminosity + windows * 700;
        if (windows == 0 && sumLuminosity < 300 || sumLuminosity > 4000) {
            throw new IlluminationLimitException("Достигнут лимит по освещенности в комнате - " + name);
        }
    }

    public void areaTest() throws AreaLimitException {
        double sumArea = 0;
        for (Furniture furniture : furnitureList) {
            sumArea += furniture.getArea();
        }
        if (sumArea > area * 0.7) throw new AreaLimitException("Достигнут лимит по площади в комнате -" + name);
    }

    public void addBulb(Bulb bulb) throws IlluminationLimitException {
        bulbsList.add(bulb);
        illuminationTest();
    }

    public void addFurniture(Furniture furniture) throws AreaLimitException {
        furnitureList.add(furniture);
        areaTest();
    }

    public int qetLuminosityWindows() {
        return windows * 700;
    }

    public int qetLuminosityBulbs() {
        int sumLuminosityBulbs = 0;
        for (Bulb bulb : bulbsList)
            sumLuminosityBulbs += bulb.getLuminosity();
        return sumLuminosityBulbs;
    }

    public int getSumFurnitureArea() {
        int SumFurnitureArea = 0;
        for (Furniture furniture : furnitureList)
            SumFurnitureArea += furniture.getArea();
        return SumFurnitureArea;
    }
}