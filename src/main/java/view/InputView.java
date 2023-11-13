package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;

public class InputView {
    private static String ERRORMESSAGE = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static String DATEMESSAGE = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private static String MENUMESSAGE = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    private String getInput() {
        return Console.readLine();
    }

    public int dateInputter() {
        boolean validate = false;
        String input = "";
        int reservationDate = 0;
        while (!validate) {
            System.out.println(DATEMESSAGE);
            input = getInput();
            validate = validateDate(input);
        }
        reservationDate = Integer.parseInt(input);
        return reservationDate;
    }

    public HashMap<String, Integer> menuInputter() {
        boolean validate = false;
        String input = "";
        HashMap<String, Integer> orderedMenu = new HashMap<>();
        while (!validate) {
            System.out.println(MENUMESSAGE);
            input = getInput();
            validate = validateMenu(input);
        }
        return orderedMenu;
    }


    private boolean validateDate(String input) {
        try {
            int reservationDate = Integer.parseInt(input);
            return checkDate(reservationDate);
        } catch (NumberFormatException e) {
            System.out.println(ERRORMESSAGE);
        }
        return false;
    }

    private boolean checkDate(int date){
        if (date <= 0 || date > 31) {
            System.out.println(ERRORMESSAGE);
            return false;
        }
        return true;
    }

    private boolean validateMenu(String input) {
        return false;
    }

    private boolean duplicateCheck(String name) {
        return false;
    }

}
