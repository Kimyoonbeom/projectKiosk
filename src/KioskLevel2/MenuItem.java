package KioskLevel2;

public class MenuItem {
    private String name; // 메뉴 이름
    private double price; // 메뉴 가격
    private String description; // 메뉴 설명

    // 생성자: 이름, 가격, 설명 초기화
    public MenuItem(String name, double price, String description) {
        this.name = name; // 이름 설정
        this.price = price; // 가격 설정
        this.description = description; // 설명 설정
    }
    // 메뉴 이름 반환
    public String getName() {
        return name; // 이름을 반환
    }

    public double getPrice() {
        return price; // 가격을 반환
    }

    public String getDescription() {
        return description; // 설명을 반환
    }

    @Override
    public String toString() {
        // 메뉴 정보 출력, 숫자를 문자로
        // 예시) 1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
        return String.format("%-15s | W %.1f | %s", name, price, description);
        // %-15 이름을 15칸으로 정렬(왼쪽 기준), %.1f: 소수점 이하 한 자리 까지만 표시.
    }
}
