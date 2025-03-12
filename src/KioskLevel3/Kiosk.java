package KioskLevel3;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> menuItems; // 메뉴 아이템 리스트

    // 생성자: Kiosk 객체를 생성하며 메뉴 리스트 초기화
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // 키오스크 프로그램 시작 메서드
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[ SHAKESHACK MENU ]");

            // 메뉴 출력
            for (int i = 0; i < menuItems.size(); i++) {
                System.out.println((i + 1) + ". " + menuItems.get(i));
            }
            System.out.println("0. 종료          | 종료");

            System.out.print("메뉴 번호를 입력하세요: ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                // 종료 조건
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try {
                int choice = Integer.parseInt(input); // 입력 값을 정수로 변환

                if (choice > 0 && choice <= menuItems.size()) {
                    MenuItem selectedItem = menuItems.get(choice - 1); // 선택한 메뉴 가져오기
                    System.out.printf("선택한 메뉴: %s | W %.2f | %s\n\n",
                            selectedItem.getName(),
                            selectedItem.getPrice(),
                            selectedItem.getDescription());
                } else {
                    System.out.println("유효하지 않은 메뉴 번호입니다. 다시 입력해주세요.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
            }
        }

        scanner.close(); // Scanner 자원 해제
    }

}
