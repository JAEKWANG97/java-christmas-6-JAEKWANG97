package view;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;
    private InputStream originalSystemIn;

    @BeforeEach
    public void setUp() {
        inputView = new InputView();
        originalSystemIn = System.in;
    }

    @Test
    public void testDateInputterWithValidDate() {
        String input = "15\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputView inputView = new InputView();
        int result = inputView.dateInputter();
        assertEquals(15, result);
    }

    @Test
    public void testDateInputterWithValidDateAfterInvalidInput() {
        InputView inputView = new InputView();

        String input = "35\n15\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        int result = inputView.dateInputter();

        assertEquals(15, result);
    }

    @Test
    public void testMenuInputterWithValidOrderAfterInvalidOrder() {
        InputView inputView = new InputView();

        String input = "해산물파스타-21,초코케이크-1\n레드와인-1\n해산물파스타-1,레드와인-1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        HashMap<String, Integer> result = inputView.menuInputter();

        assertEquals(1, result.get("해산물파스타"));
        assertEquals(1, result.get("레드와인"));
    }

}