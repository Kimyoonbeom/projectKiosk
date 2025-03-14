package KioskChallenge2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Map;

public class Kiosk {
    private List<Menu> menus; // 여러 메뉴 카테고리
    private ShoppingCart shoppingCart; // 장바구니

    // 생성자: 메뉴 카테고리 초기화 및 장바구니 생성
    public Kiosk(List<Menu> menus) {
        setMenus(menus);
        this.shoppingCart = new ShoppingCart();
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

            // 장바구니가 비어있지 않을 경우 [ORDER MENU] 출력
            if (!shoppingCart.getShoppingLists().isEmpty()) {
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println("5. Cancel       | 진행중인 주문을 취소합니다.");
            }

            System.out.print("메뉴를 선택하세요: ");
            String input = scanner.nextLine();

            if (input.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            try {
                int choice = Integer.parseInt(input); // 입력받은 값을 정수로 변환

                if (choice > 0 && choice <= getMenus().size()) {
                    // 선택된 메뉴 카테고리
                    Menu menu = getMenus().get(choice - 1);

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
                                // 선택된 메뉴 아이템
                                MenuItem selectedItem = menu.getMenuItems().get(i - 1);

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
                                    // 장바구니에 추가
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
                } else if (choice == 4) { // Orders 메뉴
                    if (shoppingCart.getShoppingLists().isEmpty()) { // 장바구니가 비어있으면 예외 처리
                        System.out.println("장바구니가 비어 있습니다. 먼저 메뉴를 추가해주세요.\n");
                        continue;
                    }

                    System.out.println("[ Orders ]");
                    // 스트림을 활용한 장바구니 출력
                    shoppingCart.displayShoppingListsStream();
                    System.out.printf("\n[ Total ]\nW %.1f\n", shoppingCart.calculatorTotal());

                    System.out.println("\n1. 주문      2. 메뉴판");
                    String orderInput = scanner.nextLine();

                    if (orderInput.equals("1")) { // 주문 완료 처리
                        System.out.println("할인 정보를 입력해주세요.");
                        System.out.println("1. 국가유공자 : 10% ");
                        System.out.println("2. 군인     :  5%");
                        System.out.println("3. 학생     :  3%");
                        System.out.println("4. 일반     :  0%");

                        String discountInput = scanner.nextLine();

                        double totalCost = shoppingCart.calculatorTotal();
                        double discountRate = 0.0;

                        switch (discountInput) {
                            case "1":
                                discountRate = Discount.Veteran.getDiscountRate();
                                break;
                            case "2":
                                discountRate = Discount.Soldier.getDiscountRate();
                                break;
                            case "3":
                                discountRate = Discount.Student.getDiscountRate();
                                break;
                            case "4":
                                discountRate = Discount.Normal.getDiscountRate();
                                break;
                            default:
                                System.out.println("유효하지 않은 선택입니다. 기본적으로 0% 할인 적용됩니다.");
                        }
                        // 할인률 계산.
                        double discountedCost = totalCost * (1 - discountRate);

                        shoppingCart.clearShoppinglist();
                        System.out.printf("주문이 완료되었습니다. 금액은 W %.1f 입니다.\n\n", discountedCost);
                    } else if (orderInput.equals("2")) { // 메뉴판으로 돌아가기
                        continue;
                    } else {
                        System.out.println("유효하지 않은 선택입니다.\n");
                    }
                } else if (choice == 5) { // Cancel 메뉴
                    if (shoppingCart.getShoppingLists().isEmpty()) { // 장바구니가 비어있으면 예외 처리
                        System.out.println("진행중인 주문이 없습니다.\n");
                        continue;
                    }

                    System.out.println("[ Cancel Menu ]");
                    shoppingCart.displayShoppingListsStream(); // 스트림으로 장바구니 출력

                    System.out.print("취소할 항목의 번호를 입력하세요 (0: 취소): ");
                    String cancelInput = scanner.nextLine();

                    if (cancelInput.equals("0")) {
                        System.out.println("취소가 취소되었습니다.\n");
                        continue;
                    }

                    try {
                        int cancelIndex = Integer.parseInt(cancelInput); // 입력받은 값을 정수로 변환

                        if (cancelIndex >= 0 && cancelIndex < shoppingCart.getShoppingLists().size()) {
                            String keyToRemove = shoppingCart.getShoppingLists().keySet().stream().
                                    skip(cancelIndex - 1)
                                    .findFirst()
                                    .orElse(null);
                            // 해당키로 항목을 제거.
                            if (keyToRemove != null) {
                                shoppingCart.removeItem(keyToRemove);
                                System.out.println("주문이 취소되었습니다.\n");
                            } else {
                                System.out.println("유효하지 않은 선택입니다. 다시 입력해주세요.\n");
                            }
                        } else {
                            System.out.println("유효하지 않은 선택입니다. 다시 입력해주세요.\n");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
                    }
                } else {
                    System.out.println("유효하지 않은 선택입니다. 다시 입력해주세요.\n");
                }
            } catch (NumberFormatException e){
                System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.\n");
            }
        }

        scanner.close(); // Scanner 자원 해제
    }
}
