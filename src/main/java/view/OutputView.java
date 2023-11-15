package view;

import dto.Receipt;
import java.util.HashMap;
import model.Menu.Menu;

public class OutputView {
    public void greetMessageOutputter(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }
    public void benefitsPreviewOutputter(){
        System.out.println("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!");
    }

    public void totalOrderOutputter(Receipt receipt){
        HashMap<String, Integer> orders = receipt.getOrders();
        System.out.println("<주문 메뉴>");
        for (String key : orders.keySet()) {
            Integer value = orders.get(key);
            System.out.println(key + " "+ value+"개");
        }
    }
}
