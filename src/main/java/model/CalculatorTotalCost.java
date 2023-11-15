package model;

import dto.Receipt;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import model.Menu.Menu;
import java.time.DayOfWeek;import java.time.LocalDate;

public class CalculatorTotalCost {
    private HashMap<String, Integer> receipt;
    private int date;
    private final int totalAmountBeforeDiscount;


    public CalculatorTotalCost(HashMap<String, Integer> receipt , int date) {
        this.receipt = receipt;
        this.date = date;
        this.totalAmountBeforeDiscount = calculateTotalAmountBeforeDiscount(receipt);

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

    private String getReservationDay(int day){
        LocalDate date = LocalDate.of(2023, 12, day);
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);
        return dayOfWeek;
    }

    //평일 할인
    private int calculateChristmasDDayDiscount(int date){
        int discount = 1000;
        if (date <= 25){
            return discount + 100 * (24);
        }
        return discount;
    }

    //평일 할인(일요일~목요일): 평일에는 디트저 메뉴를 메뉴 1개당 2,023원 할인
    //주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
    //특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
    //이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용

}
