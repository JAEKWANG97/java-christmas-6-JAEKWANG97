package model.Menu;

public class Menu {
    public static boolean validateMenuItem(String name) {
        return (Appetizer.validateAppetizer(name) ||
                Beverage.validateBeverage(name) ||
                Dessert.validateDessert(name) ||
                MainDish.validateMainDish(name));
    }

    public static int getMenuPrice(String name) {
        int price;
        price = getAppetizerPrice(name);
        if (price != -1) return price;
        price = getBeveragePrice(name);
        if (price != -1) return price;
        price = getMainDishtPrice(name);
        if (price != -1) return price;
        price = getDessertPrice(name);
        return price;
    }

    private static int getAppetizerPrice(String name){
        for (Appetizer menu : Appetizer.values()) {
            if (menu.getName().equals(name)) {
                return menu.getPrice();
            }
        }
        return -1;
    }
    private static int getBeveragePrice(String name){
        for (Beverage menu : Beverage.values()) {
            if (menu.getName().equals(name)) {
                return menu.getPrice();
            }
        }
        return -1;
    }
    private static int getMainDishtPrice(String name){
        for (MainDish menu : MainDish.values()) {
            if (menu.getName().equals(name)) {
                return menu.getPrice();
            }
        }
        return -1;
    }

    private static int getDessertPrice(String name){
        for (Dessert menu : Dessert.values()) {
            if (menu.getName().equals(name)) {
                return menu.getPrice();
            }
        }
        return -1;
    }


}
