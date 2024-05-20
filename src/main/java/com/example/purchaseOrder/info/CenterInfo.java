package com.example.purchaseOrder.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CenterInfo {
    private String centerCode;    // 센터코드
    private String centerName;    // 센터명
    private String centerInDate;  // 점입점일자
    private String storeInDate;   // 센터입하일자
}

