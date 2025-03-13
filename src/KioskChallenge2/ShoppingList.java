package KioskChallenge2;

public class ShoppingList {
    private MenuItem menuItem; // 메뉴 명
    private int count; // 수량

    public ShoppingList(MenuItem menuItem) {
        this.menuItem = menuItem;
        this.count = 1;
    }

    // getter
    public MenuItem getMenuItem() { // 메뉴명
        return menuItem;
    }

    public int getCount() { // 수량
        return count;
    }

    // setter

    public MenuItem setMenuItem() {
        return menuItem;
    }
    public void setCount(int count) {
        if (count <= 0) {
            throw new IllegalArgumentException("수량은 0보다 커야 합니다!");
        }
        this.count = count;
    }
}
