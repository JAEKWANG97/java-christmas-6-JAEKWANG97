package model;


import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import model.Menu.Dessert;
import model.Menu.MainDish;
import model.Menu.Menu;
import java.time.LocalDate;

public class CalculatorTotalCost {
    private HashMap<String, Integer> receipt;
    private int date;
    private final int totalAmountBeforeDiscount;

    private final int DISCOUNT_PRICE = 2023;

    private final String[] weekday = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
    private final String[] weekend = {"Friday", "Saturday"};
    private final int[] eventDay = {3, 10, 17, 24, 31};


    public CalculatorTotalCost(HashMap<String, Integer> receipt, int date) {
        this.receipt = receipt;
        this.date = date;
        this.totalAmountBeforeDiscount = calculateTotalAmountBeforeDiscount(receipt);

    }

    public int getTotalAmountBeforeDiscount() {
        return totalAmountBeforeDiscount;
    }


    private int calculateTotalAmountBeforeDiscount(HashMap<String, Integer> receipt) {
        int cost = 0;
        for (String key : receipt.keySet()) {
            Integer value = receipt.get(key);
            cost += Menu.getMenuPrice(key) * value;
        }
        return cost;
    }

    private String calculateReservationDay(int day) {
        LocalDate date = LocalDate.of(2023, 12, day);
        return date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
    }

    //평일 할인


    public int calculateTotalDiscount() {
        int discount = 0;
        String day = calculateReservationDay(date);
        if (Arrays.asList(weekday).contains(day)) {
            discount += calculateWeekdayDiscount();
        }
        if (Arrays.asList(weekend).contains(day)) {
            discount += calculateWeekendDiscount();
        }
        discount += calculateChristmasDDayDiscount();
        discount += calculateEventDayDiscount();
        return discount;
    }

    public int calculateChristmasDDayDiscount() {
        int discount = 1000;
        if (date <= 25) {
            return discount + 100 * (date - 1);
        }
        return 0;
    }

    public int calculateWeekdayDiscount() {
        int discount = 0;
        String day = calculateReservationDay(date);
        if (!Arrays.asList(weekday).contains(day))
        {
            return 0;
        }
        for (String key : receipt.keySet()) {
            Integer value = receipt.get(key);
            if (Dessert.validateDessert(key)) {
                discount += DISCOUNT_PRICE * value;
            }
        }
        return discount;
    }

    public int calculateWeekendDiscount() {
        int discount = 0;
        String day = calculateReservationDay(date);
        if (!Arrays.asList(weekend).contains(day))
        {
            return 0;
        }
        for (String key : receipt.keySet()) {
            Integer value = receipt.get(key);
            if (MainDish.validateMainDish(key)) {
                discount += DISCOUNT_PRICE * value;
            }
        }
        return discount;
    }

    public int calculateEventDayDiscount() {
        for (int eventDate : eventDay) {
            if (eventDate == date) {
                return 1000;
            }
        }
        return 0;
    }

    //평일 할인(일요일~목요일): 평일에는 디트저 메뉴를 메뉴 1개당 2,023원 할인
    //주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
    //특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
    //[x] 이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용

}
