package dto;

import java.util.HashMap;
import model.CalculatorTotalCost;
import model.Menu.Menu;

public class Receipt {
    private final int month = 12;
    private final int date;
    private final HashMap<String, Integer> orders;
    private final int totalAmountBeforeDiscount;

    private final HashMap<String, Integer> giveAway;

    public Receipt(int date, HashMap<String, Integer> orders) {
        this.date = date;
        this.orders = orders;
        CalculatorTotalCost calculatorTotalCost = new CalculatorTotalCost(orders , date);
        this.totalAmountBeforeDiscount = calculatorTotalCost.getTotalAmountBeforeDiscount();
        this.giveAway = ReceiveGiveaway();
    }

    public HashMap<String, Integer> getGiveAway() {
        return giveAway;
    }

    public int getTotalAmountBeforeDiscount() {
        return totalAmountBeforeDiscount;
    }

    public int getMonth() {
        return month;
    }

    public int getYear(){
        return 2023;
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
            item.put("삼페인", count);
        }
        return item;
    }
}
