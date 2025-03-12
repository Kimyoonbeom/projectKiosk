package KioskLevel5;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<Menu> menus; // 여러 메뉴 카테고리

    // 생성자: 메뉴 카테고리 초기화
    public Kiosk(List<Menu> menus) {
        setMenus(menus);
    }

    // Getter 메서드
    public List<Menu> getMenus() {
        return new ArrayList<>(menus); // 복사본을 반환하여 외부에서 수정 방지
    }

    // Setter 메서드
    public void setMenus(List<Menu> menus) {
        this.menus = menus;
    }

    // 키오스크 프로그램 시작 메서드
    public void start() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("[ MAIN MENU ]");

            // 메인 메뉴 출력
            for (int i = 0; i < getMenus().size(); i++) {
                System.out.printf("%d. %s\n", i + 1, getMenus().get(i).getCategoryName());
            }
            System.out.println("0. 종료 | 종료");

            System.out.print("메뉴를 선택하세요: ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try {
                int choice = Integer.parseInt(input); // 입력받은 값을 정수로 변환

                if (choice > 0 && choice <= getMenus().size()) {
                    Menu menu = getMenus().get(choice - 1); // 선택된 메뉴 카테고리

                    while (true) {
                        System.out.println("[" + menu.getCategoryName() + " MENU ]");

                        // 선택된 메뉴의 아이템 출력
                        menu.displayMenuItems();

                        System.out.print("메뉴를 선택하세요: ");
                        String itemInput = scanner.nextLine();

                        if (itemInput.equals("0")) {
                            // 뒤로가기
                            break;
                        }

                        try {
                            int i = Integer.parseInt(itemInput); // 입력받은 값을 정수로 변환

                            if (i > 0 && i <= menu.getMenuItems().size()) {
                                MenuItem selectedItem = menu.getMenuItems().get(i - 1); // 선택된 메뉴 아이템
                                System.out.printf("선택한 메뉴: %s | W %.1f | %s\n\n",
                                        selectedItem.getName(),
                                        selectedItem.getPrice(),
                                        selectedItem.getDescription());
                            } else {
                                System.out.println("유효하지 않은 선택입니다. 다시 입력해주세요.\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
                        }
                    }
                } else {
                    System.out.println("유효하지 않은 선택입니다. 다시 입력해주세요.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
            }
        }

        scanner.close(); // Scanner 자원 해제
    }
}
