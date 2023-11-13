package view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;

public class InputView {
    private static String errorMessage = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static String dateMessage = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

    private static String menuMessage = "주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)";

    public String getInput() {
        return Console.readLine();
    }

    public int dateInputter() {
        boolean validate = false;
        String input = "";
        int reservationDate = 0;
        while (!validate) {
            System.out.println(dateMessage);
            input = getInput();
            validate = validateDate(input);
        }
        reservationDate = Integer.parseInt(input);
        return reservationDate;
    }

    public String menuInputter() {
        boolean validate = false;
        String input = "";
        String orderedMenu = "";
        while (!validate) {
            System.out.println(menuMessage);
            input = getInput();
            validate = validateMenu(input);
        }
        return orderedMenu;
    }


    private boolean validateDate(String input) {
        try {
            int reservationDate = Integer.parseInt(input);
            if (reservationDate <= 0 || reservationDate > 31) {
                System.out.println(errorMessage);
                return false;
            }
            return true;
        } catch (NumberFormatException e) {
            System.out.println(errorMessage);
        }
        return false;
    }

    private boolean validateMenu(String input){
        try{

        }catch (ArgumentAccessException e){

        }
    }


}
