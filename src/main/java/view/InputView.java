package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import model.Menu.Appetizer;
import model.Menu.Beverage;
import model.Menu.Dessert;
import model.Menu.MainDish;

public class InputView {
    private static String ERROR_DATE_MESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static String DATE_MESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private static String MENU_MESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    private static String ERROR_ORDER_MESSAGE = "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.";

    private String getInput() {
        return Console.readLine();
    }

    public int dateInputter() {
        int reservationDate = 0;
        String input = "";
        boolean validate = false;
        while (!validate) {
            System.out.println(DATE_MESSAGE);
            input = getInput();
            validate = validateDate(input);
        }
        reservationDate = Integer.parseInt(input);
        return reservationDate;
    }

    private boolean validateDate(String input) {
        try {
            int date = turnToInt(input);
            checkDate(date);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_DATE_MESSAGE);
            return false;
        }
    }

    private int turnToInt(String input) {
        int date = 0;
        try {
            date = Integer.parseInt(input);
            return date;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void checkDate(int date) {
        if (date <= 0 || date > 31) {
            throw new IllegalArgumentException();
        }
    }
    private int total_count = 0;
    private HashMap<String, Integer> orders = new HashMap<>();
    public HashMap<String, Integer> menuInputter() {
        boolean validate = false;
        String input = "";
        int total_count = 0; // 총 주문 수량을 초기화
        while (!validate) {
            System.out.println(MENU_MESSAGE);
            input = getInput();
            validate = validateOrder(input);
        }
        return orders;
    }

    private boolean validateOrder(String input) {
        List<String> orderList = splitMenuItems(input);
        HashSet<String> orderMenu = new HashSet<>();
        try {
            for (String order : orderList) {
                isValidOrder(order, orderMenu);
            }
            return hasNonBeverageItem(orderMenu);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_ORDER_MESSAGE);
            total_count = 0;
            orders.clear();
            return false;
        }
    }

    private void isValidOrder(String input, HashSet<String> orderMenu) {
        String[] orderItem = input.split("-");
        isValidSize(orderItem);
        String name = orderItem[0];
        int count = turnToInt(orderItem[1]);
        isValidCount(count);
        isValidTotalCount(count);
        isinItem(name);
        isDuplicateOrder(name, orderMenu);
        orders.put(name, count);
    }


    private void isValidSize(String[] input){
        if (input.length != 2) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasNonBeverageItem(HashSet<String> orderMenu) {
        for (String item : orderMenu) {
            if (!Beverage.validateBeverage(item)) {
                return true;
            }
        }

        throw new IllegalArgumentException(ERROR_ORDER_MESSAGE);
    }


    private void isValidTotalCount(int count) {
        total_count += count;
        if (total_count > 20) {
            throw new IllegalArgumentException(ERROR_ORDER_MESSAGE);
        }
    }

    private HashSet<String> isDuplicateOrder(String name, HashSet<String> orderMenu) {
        if (orderMenu.contains(name)) {
            throw new IllegalArgumentException(ERROR_ORDER_MESSAGE);
        }
        orderMenu.add(name);
        return orderMenu;
    }

    private List<String> splitMenuItems(String input) {
        List<String> splittedMenu = new ArrayList<>();
        String[] menuItems = input.split(",");
        splittedMenu.addAll(Arrays.asList(menuItems));
        return splittedMenu;
    }

    private void isValidCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException(ERROR_ORDER_MESSAGE);
        }
    }


    private boolean isinItem(String name) {
        if (Appetizer.validateAppetizer(name) ||
                Beverage.validateBeverage(name) ||
                Dessert.validateDessert(name) ||
                MainDish.validateMainDish(name)) {
            return true;
        }
        System.out.println("유효하지 않은 메뉴 입니다.");

        throw new IllegalArgumentException(ERROR_ORDER_MESSAGE);
    }
}
