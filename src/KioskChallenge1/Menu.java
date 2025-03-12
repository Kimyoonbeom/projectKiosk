package KioskChallenge1;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    private String categoryName; // 메뉴 카테고리 이름
    private List<MenuItem> menuItems; // 해당 카테고리의 메뉴 아이템들

    // 생성자: 카테고리 이름 초기화
    public Menu(String categoryName) {
        this.categoryName = categoryName;
        this.menuItems = new ArrayList<>();
    }
    // Getter
    // 메뉴 아이템 추가
    public String getCategoryName() {
        return categoryName;
    }

    // 메뉴 아이템 리스트 반환
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
    // Setter
    public void setCategoryName(String categoryName){
        this.categoryName = categoryName;
    }
    // 메뉴 아이템 추가
    public void addMenuItem(MenuItem item) {
        menuItems.add(item);
    }
    // 메뉴 아이템 출력
    public void displayMenuItems() {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println((i + 1) + ". " + menuItems.get(i));
        }
        System.out.println("0. 뒤로가기");
    }

}