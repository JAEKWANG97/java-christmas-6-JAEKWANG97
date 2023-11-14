package model.Menu;

public enum Dessert {
    CHOCOLATE_CAKE("초코케이크", 15000),
    ICE_CREAM("아이스크림", 5000);

    private final String name;
    private final int price;

    private Dessert(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public static boolean validateDessert(String koreanName) {
        for (Dessert menu : Dessert.values()) {
            if (menu.getName().equals(koreanName)) {
                return true;
            }
        }
        return false;
    }
}
