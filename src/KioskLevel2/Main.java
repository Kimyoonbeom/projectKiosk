package KioskLevel2;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) { // 프로그램의 시작 지점
        // List 선언 및 초기화
        List<MenuItem> menuItems = new ArrayList<>(); // ArrayList 초기화

        // MenuItem 객체 생성 및 리스트에 추가
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거")); // ShackBurger 추가
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거")); // SmokeShack 추가
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거")); // Cheeseburger 추가
        menuItems.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거")); // Hamburger 추가

        Scanner scanner = new Scanner(System.in); // 사용자 입력을 받기 위한 Scanner 객체 생성

        while (true) { // 무한 반복문
            System.out.println("[ SHAKESHACK MENU ]"); // 메뉴 헤더 출력

            // 반복문을 활용해 List 안에 있는 MenuItem 출력
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i)); // 각 메뉴 항목 출력
            }

            System.out.println("0. 종료      | 종료");

            System.out.print("메뉴 번호를 입력하세요: ");

            int choice = scanner.nextInt();

            if (choice == 0) {
                // 0을 입력하면 프로그램 종료 메시지 출력 후 반복문 종료
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            if (choice >= 1 && choice <= menuItems.size()) {
                // 유효한 번호일 경우 선택한 메뉴 정보 출력
                MenuItem selectedItem = menuItems.get(choice - 1); // 선택된 메뉴 가져오기
                System.out.println("선택한 메뉴: " + selectedItem.getName()); // 메뉴 이름 출력
                System.out.println(selectedItem.getDescription()); // 메뉴 설명 출력
            } else {
                // 유효하지 않은 번호일 경우 오류 메시지 출력
                System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
            }

            System.out.println(); // 줄바꿈 (UI 정리용)
        }

        scanner.close(); // Scanner 객체 닫기 (자원 해제)
    }
}
