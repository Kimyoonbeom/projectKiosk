package KioskChallenge2;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String,ShoppingList> shoppingLists;

    public ShoppingCart(){
        this.shoppingLists = new HashMap<>();
    }

    // 장바구니 아이템 리스트 변환
    public Map<String, ShoppingList> getShoppingLists(){
        return shoppingLists;
    }

    // 장바구니 물건 추가하기.
    public void addShoppingList(ShoppingList list){
        String menuItemName = list.getMenuItem().getName();

        if (shoppingLists.containsKey(menuItemName)) {
            // 동일한 메뉴가 있으면 수량 증가
            ShoppingList existingList = shoppingLists.get(menuItemName);
            existingList.setCount(existingList.getCount() + 1);
        } else {
            // 동일한 메뉴가 없으면 새로운 항목으로 추가
            shoppingLists.put(menuItemName, list);
        }
    }
/*
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

 */
    // 스트림을 이용한 장바구니 물건들 출력.
    public void displayShoppingListsStream(){
        int index = 1; // 번호 부여하기 위한 변수.
        for (Map.Entry<String, ShoppingList> entry : shoppingLists.entrySet()){
            System.out.printf("%d. %-15s  | W %.1f | 수량: %d\n",
                    index++, // 번호 출력
                    entry.getValue().getMenuItem().getName(), // 메뉴 이름
                    entry.getValue().getMenuItem().getPrice(), // 가격
                    entry.getValue().getCount()); // 수량
        }
    }
    // 스트림을 이용한 장바구니 항목 삭제하기
    public void removeItem(String itemName){
        shoppingLists = shoppingLists.entrySet().stream()
                .filter(entry -> !entry.getKey().equals(itemName))
                .collect(Collectors.toMap
                        (Map.Entry::getKey,
                        Map.Entry::getValue));
    }
    // 장바구니 총 금액 합계
    public double calculatorTotal(){
        double total = 0;
        for (ShoppingList list: shoppingLists.values()){
            total += list.getMenuItem().getPrice()*list.getCount(); // 총합 = 메뉴명 * 수량
        }
        return total;
    }
    // 장바구니 초기화
    public void clearShoppinglist(){
        shoppingLists.clear();
    }
}
