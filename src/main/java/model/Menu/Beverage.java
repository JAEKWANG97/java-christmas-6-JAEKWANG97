package model.Menu;

public enum Beverage {
    ZERO_COLA("제로콜라", 3000),
    RED_WINE("레드와인", 60000),
    CHAMPAGNE("샴페인", 25000);
    private final String name;
    private final int price;

    private Beverage(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean validateBeverage(String name) {
        for (Beverage menu : Beverage.values()) {
            if (menu.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
