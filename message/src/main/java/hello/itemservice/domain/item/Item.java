package hello.itemservice.domain.item;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    private Boolean open; // 판배 여부
    private List<String> regions; // 등록 지역
    private ItemType itemType; // 배송 타입
    private String deliveryCode; // 배송 코드

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", itemName='" + itemName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
