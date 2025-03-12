package KioskChallenge1;
// 장바구니는 메뉴명, 수량, 가격 정보를 저장
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


    /* // 첫번째
    public int setCount(int count) {
        // 잘못된 선택을 했을 경우 예외를 처리 -> 수량은 1 이상이여야 한다.
        if (count > 0) {
            this.count = count;
        } else {
            System.out.println("수량은 0보다 커야 합니다!");
        }
        return count;
    }

    */
    /* // 두번째
    public void setCount(int count) {
        // 잘못된 선택을 했을 경우 예외를 처리 -> 수량은 1 이상이여야 한다.
        if (count > 0) {
            this.count = count;
        } else {
            System.out.println("수량은 0보다 커야 합니다!");
        }
        // void를 사용하면 return을 입력하지 않아도 된다.
    */

}

