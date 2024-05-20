package com.example.purchaseOrder.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderInfo {
    private String orderDate;     // 발주일자
    private String orderCost;     // 발주원가
    private String orderUnit;     // 발주단위
    private String orderQuantity; // 발주수량
    private String orderAmount;   // 발주금액
}

