package KioskLevel4;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Menu 객체 생성하면서 카테고리 이름 설정
        Menu burgers = new Menu("Burgers");
        burgers.addMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgers.addMenuItem(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Menu drinks = new Menu("Drinks");
        // 음료 메뉴 아이템 추가
        drinks.addMenuItem(new MenuItem("Coca-Cola", 2.5, "코카콜라"));
        drinks.addMenuItem(new MenuItem("Sprite", 2.5, "스프라이트"));

        Menu desserts = new Menu("Desserts");
        // 디저트 메뉴 아이템 추가
        desserts.addMenuItem(new MenuItem("Cheesecake", 8.7, "치즈케이크"));
        desserts.addMenuItem(new MenuItem("Pancake", 6.9, "팬케이크"));

        // Menu 클래스 내 있는 List<MenuItem> 에 MenuItem 객체 생성하면서 삽입
        List<Menu> menus = new ArrayList<>();
        menus.add(burgers);
        menus.add(drinks);
        menus.add(desserts);

        // Kiosk 객체 생성 및 실행
        Kiosk kiosk = new Kiosk(menus);
        kiosk.start();
    }
}
