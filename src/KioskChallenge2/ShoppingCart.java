package KioskChallenge2;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ShoppingCart {
    private List<ShoppingList> shoppingLists;

    public ShoppingCart(){
        this.shoppingLists = new ArrayList<>();
    }

    // 장바구니 아이템 리스트 변환
    public List<ShoppingList> getShoppingLists(){
        return shoppingLists;
    }

    // 장바구니 물건 추가하기.
    public void addShoppingList(ShoppingList list){
        // 동일한 메뉴가 이미 있는지 확인.
        for (ShoppingList existingList: shoppingLists){
            if (existingList.getMenuItem().getName().equals(list.getMenuItem().getName())){
                // 같은게 있다면 수량 증가 + 1
                existingList.setCount(existingList.getCount() + 1);
                return;
            }
        }
        shoppingLists.add(list); // 동일한 메뉴가 이미 없다면 추가.
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
    // 스트림을 이용한 장바구니 물건들 출력.
    public void displayShoppingListsStream(){
        shoppingLists.stream().forEach(list -> System.out.printf("%-15s  | W %.1f | 수량: %d\n",
                list.getMenuItem().getName(),
                list.getMenuItem().getPrice(),
                list.getCount()));
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
