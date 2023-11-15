package model.Menu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class MenuTest {

    @Test
    public void testGetAppetizerPriceValid() {
        int price = Menu.getAppetizerPrice("양송이수프");
        assertEquals(6000, price);
    }

    @Test
    public void testGetAppetizerPriceInvalid() {
        int price = Menu.getAppetizerPrice("없는 메뉴");
        assertEquals(-1, price);
    }

    @Test
    public void testGetBeveragePriceValid() {
        int price = Menu.getBeveragePrice("레드와인");
        assertEquals(60000, price);
    }

    @Test
    public void testGetBeveragePriceInvalid() {
        int price = Menu.getBeveragePrice("없는 메뉴");
        assertEquals(-1, price);
    }

    @Test
    public void testGetDessertPriceValid() {
        int price = Menu.getDessertPrice("초코케이크");
        assertEquals(15000, price);
    }

    @Test
    public void testGetDessertPriceInvalid() {
        int price = Menu.getDessertPrice("없는 메뉴");
        assertEquals(-1, price);
    }

    @Test
    public void testGetMainDishPriceValid() {
        int price = Menu.getMainDishtPrice("티본스테이크");
        assertEquals(55000, price);
    }

    @Test
    public void testGetMainDishPriceInvalid() {
        int price = Menu.getMainDishtPrice("없는 메뉴");
        assertEquals(-1, price);
    }

    @Test
    public void testValidateMenuItemValid() {
        assertTrue(Menu.validateMenuItem("티본스테이크"));
        assertTrue(Menu.validateMenuItem("레드와인"));
    }

    @Test
    public void testValidateMenuItemInvalid() {
        assertFalse(Menu.validateMenuItem("없는 메뉴"));
    }
}
