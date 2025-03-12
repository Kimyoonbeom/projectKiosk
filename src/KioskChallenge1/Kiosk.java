package KioskChallenge1;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

/*  기능 구현
    1. 장바구니 생성 및 관리 기능
    2. 장바구니 출력 및 금액 계산
    3. 장바구니 담기 기능
    4. 주문 기능
 */
public class Kiosk {
    private List<Menu> menus;
    private ShoppingCart shoppingCart;

    // 메뉴 카테고리 초기화
    public Kiosk(List<Menu> menus) {
        setMenus(menus);
        this.shoppingCart = new ShoppingCart();
    }

    // getter
    public List<Menu> getMenus() {
        return new ArrayList<>(menus);
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    // setter
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

            if (!shoppingCart.getShoppingLists().isEmpty()) { // 장바구니가 비어있지 않을 경우 [ORDER MENU] 출력
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
            }
            // 메뉴 선택
            System.out.print("메뉴를 선택하세요: ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            // 메뉴 카테고리 선택 후 메뉴 아이템 출력.
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
                        // 메뉴 아이템 선택 및 장바구니 추가
                        try {
                            int i = Integer.parseInt(itemInput); // 입력받은 값을 정수로 변환

                            if (i > 0 && i <= menu.getMenuItems().size()) {
                                MenuItem selectedItem = menu.getMenuItems().get(i - 1); // 선택된 메뉴 아이템
                                System.out.printf("선택한 메뉴: %s | W %.1f | %s\n\n",
                                        selectedItem.getName(),
                                        selectedItem.getPrice(),
                                        selectedItem.getDescription());

                                System.out.println("\"" + selectedItem.getName() + " | W " + selectedItem.getPrice() +
                                        " | " + selectedItem.getDescription() + "\"");
                                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                                System.out.println("1. 확인        2. 취소");

                                String addInput = scanner.nextLine();

                                if (addInput.equals("1")) {
                                    shoppingCart.addShoppingList(new ShoppingList(selectedItem));
                                    System.out.println(selectedItem.getName() + " 이 장바구니에 추가되었습니다.\n");
                                } else {
                                    System.out.println("취소되었습니다.\n");
                                }
                            } else {
                                System.out.println("유효하지 않은 선택입니다. 다시 입력해주세요.\n");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
                        }
                    }
                    // [ ORDER MENU ] 처리
                } else if (choice == 4) { // Orders 메뉴
                    if (shoppingCart.getShoppingLists().isEmpty()) { // 장바구니가 비어있으면 예외 처리
                        System.out.println("장바구니가 비어 있습니다. 먼저 메뉴를 추가해주세요.\n");
                        continue;
                    }

                    System.out.println("[ Orders ]");
                    shoppingCart.displayShoppingLists();
                    System.out.printf("\n[ Total ]\nW %.1f\n", shoppingCart.calculatorTotal());

                    System.out.println("\n1. 주문      2. 메뉴판");
                    String orderInput = scanner.nextLine();

                    if (orderInput.equals("1")) { // 주문 완료 처리
                        double totalCost = shoppingCart.calculatorTotal();
                        shoppingCart.clearShoppinglist();
                        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n\n", totalCost);
                    } else if (orderInput.equals("2")) { // 메뉴판으로 돌아가기
                        continue;
                    } else {
                        System.out.println("유효하지 않은 선택입니다.\n");
                    }
                    // 주문 취소 처리
                } else if (choice == 5) { // Cancel 메뉴
                    if (shoppingCart.getShoppingLists().isEmpty()) { // 장바구니가 비어있으면 예외 처리
                        System.out.println("진행중인 주문이 없습니다.\n");
                        continue;
                    }

                    shoppingCart.clearShoppinglist();
                    System.out.println("주문이 취소되었습니다.\n");
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
/*
필드:
1. menus: 메뉴의 카테고리를 저장하는 리스트
2. shoppingCart: 장바구니 관리하는 필드
메서드:
1. getMenus(): 메뉴 카테고리 리스트를 받는 메서드
2. setMenus(): 메뉴 카테고리 리스트를 설정
3. start(): 키오스트의 입력과 출력의 기능 메서드
start()
1. 메인 메뉴 출력
2. 메뉴 선택
3. 메뉴 아이템 선택과 장바구니 추가
4. 장바구니 메뉴 출력 [ ORDER MENU ]
5. 주문 확인 및 결제, 취소
예외:
숫자가 아닌 값이나 없는 번호를 입력
장바구니가 비어 있을 때의 예외
*/
