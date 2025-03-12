package KioskChallenge1;
/**
 1. 생성 및 관리
 사용자가 선택한 메뉴를 장바구니에 추가할 수 있는 기능을 제공합니다.
 장바구니는 메뉴명, 수량, 가격 정보를 저장하며, 항목을 동적으로 추가 및 조회할 수 있어야 합니다.
 사용자가 잘못된 선택을 했을 경우 예외를 처리합니다. -> 유효하지 않은 메뉴 번호 입력

 2. 장바구니 출력 및 금액 계산
 사용자가 결제를 시도하기 전에, 장바구니에 담긴 모든 메뉴와 총 금액을 출력한다.
 -> 각 메뉴의 이름, 가격, 수량, 총 금액 합계

 3. 장바구니 담기 기능
 메뉴를 클릭하면 장바구니에 추가할 지 물어보고, 입력값에 따라 "추가", "취소" 처리한다.
 메뉴는 한 번에 1개만 담는다.

 4. 주문 기능
 장바구니에 담긴 모든 항목 출력
 합산하여 총 금액 계산하고, "주문하기"를 누르면 장바구니를 초기화한다.

 */
import java.util.ArrayList;
import java.util.List;
public class ShoppingCart {
    private List<ShoppingList> shoppingLists;
    /* ShoppingList를 클래스로 정의할까, Enum으로 할까, 인터페이스로 할까?
       메뉴 아이템과 수량, 정보들을 저장하니까 클래스를 하나 더 만들자
       인터페이스는 객체구조, Enum은 상수 집합이니까.
     */

    public ShoppingCart(){
        this.shoppingLists = new ArrayList<>();
    }
    // 장바구니 아이템 리스트 반환
    public List<ShoppingList> getShoppingLists() {
        return shoppingLists;
    }
    // 장바구니에 물건 추가 하기.
    public void addShoppingList(ShoppingList list){
        // shoppingLists.add(list); // 이전에는 그냥 했더니 1개 씩으로만 출력.
         /*
            이 부분은 장바구니에 이미 있는 모든 항목(ShoppingList)을 하나씩 검사합.

            각 항목의 메뉴 이름(existingList.getMenuItem().getName())을 새로 추가하려는 메뉴 이름(list.getMenuItem().getName())과 비교.

            두 이름이 같으면, 동일한 메뉴가 이미 장바구니에 있다는 의미다.

         */
        for (ShoppingList existingList : shoppingLists){ // 동일한 메뉴가 이미 장바구니에 있는감?

            if (existingList.getMenuItem().getName().equals(list.getMenuItem().getName())){
                // 같은게 있다면 수량 증가 + 1
                existingList.setCount(existingList.getCount() + 1);
                return;
            }
        }
        // 리스트에 추가
        shoppingLists.add(list);
    }
    // 장바구니 물건들 출력.
    public void displayShoppingLists(){
        for (int i = 0; i < shoppingLists.size(); i++){
            ShoppingList list = shoppingLists.get(i);
            System.out.printf("%-15s  | W %.1f | 수량: %d\n"
                    ,
                    list.getMenuItem().getName(),
                    list.getMenuItem().getPrice(),
                    list.getCount());
        }
    }
    // 장바구니 총 금액 합계
    public double calculatorTotal(){
        double total = 0;
        for (ShoppingList list: shoppingLists){
            total += list.getMenuItem().getPrice()*list.getCount(); // 총합 = 메뉴명 * 수량
        }
        return total;
    }
    // 장바구니 초기화
    public void clearShoppinglist(){
        shoppingLists.clear();
    }

}
