package view;

import dto.Receipt;
import java.util.HashMap;
import model.CalculatorTotalCost;
import model.Menu.Menu;

public class OutputView {
    public void greetMessageOutputter() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public void benefitsPreviewOutputter(Receipt receipt) {
        int day = receipt.getDate();
        System.out.println("12월 " + day + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
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

    public void benefitDetailsOutputter(Receipt receipt) {
        System.out.println("<혜택 내역>");
        printDiscount("크리스마스 디데이 할인", receipt.getChirstmasDDayDiscountAmount());
        printDiscount("평일 할인", receipt.getWeekdayDiscountAmount());
        printDiscount("주말 할인", receipt.getWeekendDiscountAmount());
        printDiscount("특별 할인", receipt.getEventdayDiscountAmount());
        printDiscount("증정 이벤트", receipt.getGiveAwayAmount());

        if (receipt.getTotalDiscountAmount() == 0) {
            System.out.println("없음");
        }
    }

    public void totalBenefitAmountOutputter(Receipt receipt) {
        System.out.println("<총혜택 금액>");
        if (receipt.getTotalDiscountAmount() > 0) {
            String formattedAmount = String.format("%,d", receipt.getTotalDiscountAmount() + receipt.getGiveAwayAmount());
            System.out.println("-" + formattedAmount + "원");
            return;
        }
        System.out.println("0원");
        return;

    }

    private void printDiscount(String discountName, int amount) {
        if (amount > 0) {
            String formattedAmount = String.format("%,d", amount);
            System.out.println(discountName + ": -" + formattedAmount + "원");
        }
    }

    public void estimatedPaymentAmountAfterDiscount(Receipt receipt) {
        System.out.println("<할인 후 예상 결제 금액>");
        String formattedAmount = String.format("%,d", receipt.getTotalAmountBeforeDiscount() - receipt.getTotalDiscountAmount());
        System.out.println(formattedAmount+"원");
    }
}
