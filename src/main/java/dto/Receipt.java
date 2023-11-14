package dto;

import java.util.HashMap;

public class Receipt {
    private final int date;
    private final HashMap<String, Integer> orders;

    public Receipt(int date , HashMap<String, Integer> orders){
        this.date = date;
        this.orders = orders;
    }

    


}
