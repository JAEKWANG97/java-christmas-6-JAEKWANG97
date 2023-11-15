package model;

import dto.Receipt;

public class BadgeAssigner {
    private final String badge;
    private final String STAR = "별";
    private final String TREE = "트리";
    private final String SANTA = "산타";

    public BadgeAssigner(Receipt receipt) {
        int totalBenefitsAmount = receipt.getTotalDiscountAmount() + receipt.getGiveAwayAmount();

        if (totalBenefitsAmount >= 20000) {
            this.badge = SANTA;
        } else if (totalBenefitsAmount >= 10000) {
            this.badge = TREE;
        } else if (totalBenefitsAmount >= 5000) {
            this.badge = STAR;
        } else {
            this.badge = null; // NULL 대신 null 사용
        }
    }

    public String getBadge() {
        return badge;
    }
}
