package model;

import dto.Receipt;
import java.util.HashMap;
import model.Menu.Menu;

public class CalculatorTotalCost {
    private HashMap<String, Integer> receipt;
    private int totalAmountBeforeDiscount;

    public CalculatorTotalCost(Receipt receipt) {
        this.receipt = receipt.getOrders();
        this.totalAmountBeforeDiscount = calculateTotalAmountBeforeDiscount(receipt.getOrders());
    }

    public int getTotalAmountBeforeDiscount(){
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

}
