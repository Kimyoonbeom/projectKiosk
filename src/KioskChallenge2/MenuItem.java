package KioskChallenge2;

public class MenuItem {
    private String name; // 메뉴 이름
    private double price; // 메뉴 가격
    private String description; // 메뉴 설명

    // 초기화
    public MenuItem(String name, double price, String description) {
        setName(name);
        setPrice(price);
        setDescription(description);
    }

    // Getter
    // 메뉴 이름
    public String getName() {
        return name;
    }

    // 메뉴 가격
    public double getPrice() {
        return price;
    }

    // 메뉴 설명
    public String getDescription() {
        return description;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    // 메뉴 정보 출력, 숫자를 문자로
    public String toString() {
        // 예시) 1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
        return String.format("%-15s  | W %.1f | %s", name, price, description);
        // %-15s 이름을 15칸으로 정렬(왼쪽 기준), %.1f: 소수점 이하 한 자리 까지만 표시.
    }
}
