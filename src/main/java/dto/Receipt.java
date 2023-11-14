package dto;

import java.util.HashMap;

public class Receipt {
    private final int date;
    private final HashMap<String, Integer> orders;

    public Receipt(int date , HashMap<String, Integer> orders){
        this.date = date;
        this.orders = orders;
    }

    public int getDate(){
        return date;
    }
    public HashMap<String, Integer> getOrders(){
        return orders;
    }




}
