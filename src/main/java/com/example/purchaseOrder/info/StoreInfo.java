package com.example.purchaseOrder.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoreInfo {
    private String storeCode; // 점포코드
    private String storeName; // 점포명
}

