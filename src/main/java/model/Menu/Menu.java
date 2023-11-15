package model.Menu;

public class Menu {
    public static boolean validateMenuItem(String name) {
        return (Appetizer.validateAppetizer(name) ||
                Beverage.validateBeverage(name) ||
                Dessert.validateDessert(name) ||
                MainDish.validateMainDish(name));
    }

    public static int getMenuPrice(String name) {
        if (getAppetizerPrice(name) != -1) {
            return getAppetizerPrice(name);
        }
        if (getBeveragePrice(name) != -1) {
            return getBeveragePrice(name);
        }
        if (getMainDishtPrice(name) != -1) {
            return getMainDishtPrice(name);
        }
        if (getDessertPrice(name) != -1) {
            return getDessertPrice(name);
        }
        return -1;
    }

    private static int getAppetizerPrice(String name) {
        for (Appetizer menu : Appetizer.values()) {
            if (menu.getName().equals(name)) {
                return menu.getPrice();
            }
        }
        return -1;
    }

    private static int getBeveragePrice(String name) {
        for (Beverage menu : Beverage.values()) {
            if (menu.getName().equals(name)) {
                return menu.getPrice();
            }
        }
        return -1;
    }

    private static int getMainDishtPrice(String name) {
        for (MainDish menu : MainDish.values()) {
            if (menu.getName().equals(name)) {
                return menu.getPrice();
            }
        }
        return -1;
    }

    private static int getDessertPrice(String name) {
        for (Dessert menu : Dessert.values()) {
            if (menu.getName().equals(name)) {
                return menu.getPrice();
            }
        }
        return -1;
    }


}
