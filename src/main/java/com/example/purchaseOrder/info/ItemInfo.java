package com.example.purchaseOrder.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemInfo {
    private String itemCode; // 상품코드
    private String itemName; // 상품명
    private String lot;      // 수량
}

