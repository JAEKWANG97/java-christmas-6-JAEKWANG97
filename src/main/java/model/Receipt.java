package model;

import java.util.HashMap;
import model.CalculatorTotalCost;
import model.Menu.Beverage;
import model.Menu.Menu;


public class Receipt {
    private final int month = 12;
    private final int date;
    private final HashMap<String, Integer> orders;
    private final int totalAmountBeforeDiscount;

    private int totalDiscountAmount = 0;

    private int weekendDiscountAmount = 0;
    private int weekdayDiscountAmount = 0;
    private int eventdayDiscountAmount = 0;
    private int chirstmasDDayDiscountAmount = 0;

    private int giveAwayAmount;

    private final HashMap<String, Integer> giveAway;

    public Receipt(int date, HashMap<String, Integer> orders) {
        this.date = date;
        this.orders = orders;
        CalculatorTotalCost calculatorTotalCost = new CalculatorTotalCost(orders, date);
        this.totalAmountBeforeDiscount = calculatorTotalCost.getTotalAmountBeforeDiscount();
        this.giveAway = ReceiveGiveaway();
        if (totalAmountBeforeDiscount > 10000) {
            this.totalDiscountAmount = calculatorTotalCost.calculateTotalDiscount();
            this.weekendDiscountAmount = calculatorTotalCost.calculateWeekendDiscount();
            this.weekdayDiscountAmount = calculatorTotalCost.calculateWeekdayDiscount();
            this.eventdayDiscountAmount = calculatorTotalCost.calculateEventDayDiscount();
            this.chirstmasDDayDiscountAmount = calculatorTotalCost.calculateChristmasDDayDiscount();
            this.giveAwayAmount = getGiveAwayAmount();
        }
    }

    public HashMap<String, Integer> getGiveAway() {
        return giveAway;
    }

    public int getGiveAwayAmount() {
        for (String key : giveAway.keySet()
        ) {
            return Menu.getMenuPrice(key);
        }
        return 0;
    }

    public int getTotalAmountBeforeDiscount() {
        return totalAmountBeforeDiscount;
    }


    public int getTotalDiscountAmount() {
        return totalDiscountAmount;
    }


    public int getWeekendDiscountAmount() {
        return weekendDiscountAmount;
    }

    public int getWeekdayDiscountAmount() {
        return weekdayDiscountAmount;
    }

    public int getEventdayDiscountAmount() {
        return eventdayDiscountAmount;
    }

    public int getChirstmasDDayDiscountAmount() {
        return chirstmasDDayDiscountAmount;
    }

    public int getDate() {
        return date;
    }

    public HashMap<String, Integer> getOrders() {
        return orders;
    }


    private HashMap<String, Integer> ReceiveGiveaway() {
        HashMap<String, Integer> item = new HashMap<>();
        if (totalAmountBeforeDiscount > 120000) {
            int count = 1;
            item.put("샴페인", count);
        }
        return item;
    }
}
