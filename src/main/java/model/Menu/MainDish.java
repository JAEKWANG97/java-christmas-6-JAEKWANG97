package model.Menu;

public enum MainDish {
    TBONE_STEAK("티본스테이크", 55000),
    BBQ_RIBS("바비큐립", 54000),
    SEAFOOD_PASTA("해산물 파스타", 35000),
    CHRISTMAS_PASTA("크리스마스파스타", 25000); // 오타 수정: CHTISTMAS_PASTA -> CHRISTMAS_PASTA

    private final String name; // final을 추가하는 것이 좋습니다.
    private final int price;   // final을 추가하는 것이 좋습니다.

    // 생성자 수정: private 선언 및 올바른 파라미터 사용
    private MainDish(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean validateMainDish(String koreanName) {
        for (MainDish menu : MainDish.values()) {
            if (menu.getName().equals(koreanName)) {
                return true;
            }
        }
        return false;
    }
}
