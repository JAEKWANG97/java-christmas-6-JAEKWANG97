package view;

import dto.Receipt;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OutputViewTest {

    @Test
    public void testTotalOrderOutputter() {
        OutputView outputView = new OutputView();

        // 적절한 주문 내역을 생성
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("레드와인", 2);
        orders.put("해산물파스타", 1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.totalOrderOutputter(new Receipt(15, orders));

        String output = outputStream.toString().trim();

        // 출력된 문자열에 각 메뉴 아이템이 포함되어 있는지 확인
        assertTrue(output.contains("해산물파스타 1개"));
        assertTrue(output.contains("레드와인 2개"));
        assertTrue(output.startsWith("<주문 메뉴>")); // 출력이 "<주문 메뉴>"로 시작하는지 확인
    }

    @Test
    public void testBenefitsPreviewOutputter() {
        OutputView outputView = new OutputView();
        int date = 26;
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("레드와인", 2);
        orders.put("해산물파스타", 1);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        outputView.benefitsPreviewOutputter(new Receipt(date, orders));
        String output = outputStream.toString().trim();

        assertEquals("12월 26일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", output);
    }


}
