package view;

import dto.Receipt;
import java.util.HashMap;
import model.CalculatorTotalCost;
import model.Menu.Menu;

public class OutputView {
    public void greetMessageOutputter() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void benefitsPreviewOutputter() {
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void totalOrderOutputter(Receipt receipt) {
        HashMap<String, Integer> orders = receipt.getOrders();
        System.out.println("<주문 메뉴>");
        for (String key : orders.keySet()) {
            Integer value = orders.get(key);
            System.out.println(key + " " + value + "개");
        }
    }

    public void totalAmountBeforeDiscountOutputter(Receipt receipt) {
        int totalAmountBeforeDiscount = receipt.getTotalAmountBeforeDiscount();
        String formattedTotal = String.format("%,d", totalAmountBeforeDiscount);
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(formattedTotal + "원");
    }

    public void giveAwayOutputter(Receipt receipt) {
        HashMap<String, Integer> giveAway = receipt.getGiveAway();
        System.out.println("<증정 메뉴>");
        if (giveAway.isEmpty()) {
            System.out.println("없음");
        } else {
            for (String key : giveAway.keySet()
            ) {
                Integer value = giveAway.get(key);
                System.out.println(key + " " + value + "개");
            }
        }
    }

}
