package view;

import camp.nextstep.edu.missionutils.Console;
import org.junit.jupiter.params.aggregator.ArgumentAccessException;

public class InputView {
    private static String errorMessage = "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.";
    private static String dateMessage = "12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)";

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


}
