package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.Test;

class CalculatorTotalCostTest {
    @Test
    void getTotalAmountBeforeDiscount() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("초코케이크", 3);
        CalculatorTotalCost calculator = new CalculatorTotalCost(orders, 3); // 화요일

        int discount = calculator.getTotalAmountBeforeDiscount();

        assertEquals(45000, discount);
    }

    @Test
    void calculateTotalDiscount() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("초코케이크", 3);
        CalculatorTotalCost calculator = new CalculatorTotalCost(orders, 3); // 화요일

        int discount = calculator.calculateTotalDiscount();

        assertEquals(8269, discount);
    }

    @Test
    void calculateChristmasDDayDiscount() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("초코케이크", 3);
        CalculatorTotalCost calculator = new CalculatorTotalCost(orders, 24); // 화요일

        int discount = calculator.calculateChristmasDDayDiscount();

        assertEquals(3300, discount);
    }

    @Test
    public void testCalculateWeekdayDiscount() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("초코케이크", 3);
        CalculatorTotalCost calculator = new CalculatorTotalCost(orders, 3); // 화요일

        int discount = calculator.calculateWeekdayDiscount();

        assertEquals(2023 * 3, discount);
    }

    @Test
    void calculateWeekendDiscount() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("티본스테이크", 2);
        CalculatorTotalCost calculator = new CalculatorTotalCost(orders, 2); // 화요일

        int discount = calculator.calculateWeekendDiscount();

        assertEquals(4046, discount);
    }

    @Test
    void calculateEventDayDiscount() {
        HashMap<String, Integer> orders = new HashMap<>();
        orders.put("티본스테이크", 2);
        CalculatorTotalCost calculator = new CalculatorTotalCost(orders, 25); // 화요일

        int discount = calculator.calculateEventDayDiscount();

        assertEquals(1000, discount);
    }
}