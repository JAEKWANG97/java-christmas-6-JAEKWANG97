package model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import dto.Receipt;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class BadgeAssignerTest {

    @Test
    public void testBadgeAssignerForSanta() {
        Receipt receipt = createMockReceipt(25000);
        BadgeAssigner badgeAssigner = new BadgeAssigner(receipt);

        assertEquals("산타", badgeAssigner.getBadge());
    }

    @Test
    public void testBadgeAssignerForTree() {
        Receipt receipt = createMockReceipt(15000);
        BadgeAssigner badgeAssigner = new BadgeAssigner(receipt);

        assertEquals("트리", badgeAssigner.getBadge());
    }

    @Test
    public void testBadgeAssignerForStar() {

        Receipt receipt = createMockReceipt(6000);
        BadgeAssigner badgeAssigner = new BadgeAssigner(receipt);

        assertEquals("별", badgeAssigner.getBadge());
    }

    @Test
    public void testBadgeAssignerForNoBadge() {
        Receipt receipt = createMockReceipt(3000);
        BadgeAssigner badgeAssigner = new BadgeAssigner(receipt);

        assertNull(badgeAssigner.getBadge());
    }

    private Receipt createMockReceipt(int totalBenefitAmount) {
        HashMap<String, Integer> mockOrders = new HashMap<>();
        mockOrders.put("해산물파스타", 1);

        Receipt mockReceipt = new Receipt(1, mockOrders);
        mockReceipt.setTotalDiscountAmount(totalBenefitAmount);
        return mockReceipt;
    }
}
