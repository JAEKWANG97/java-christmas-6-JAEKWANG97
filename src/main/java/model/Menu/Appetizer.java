package model.Menu;

public enum Appetizer {

    MUSHROOM_SOUP("양송이수프", 6000),
    TAPAS("타파스", 5500),
    CAESAR_SALAD("시저샐러드", 8000);

    private final String name;
    private final int price;


    private Appetizer(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean validateAppetizer(String name) {
        for (Appetizer menu : Appetizer.values()) {
            if (menu.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
