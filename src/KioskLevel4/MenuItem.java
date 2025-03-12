package KioskLevel4;
// 세부 메뉴 속성 가지는 클래스
    // 햄버거의 이름, 가격 설명

public class MenuItem {
    private String name; // 메뉴 이름
    private double price; // 메뉴 가격
    private String description; // 메뉴 설명

    // 초기화
    public MenuItem(String name, double price, String description){
        this.name = name;
        this.price = price;
        this.description = description;
    }
    // 메뉴 이름
    public String getName(){
        return name;
    }
    // 메뉴 가격
    public double getPrice(){
        return price;
    }
    // 메뉴 설명
    public String getDescription(){
        return description;
    }

    @Override
    // 메뉴 정보 출력, 숫자를 문자로
    public String toString(){
        // 예시) 1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
        return String.format("%-15s  | W %.1f | %s", name, price, description);
        // %-15s 이름을 15칸으로 정렬(왼쪽 기준), %.1f: 소수점 이하 한 자리 까지만 표시.
    }
}
