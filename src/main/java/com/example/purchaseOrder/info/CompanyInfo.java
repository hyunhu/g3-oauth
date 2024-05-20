package com.example.purchaseOrder.info;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyInfo {
    private String comCode;  // 업체코드
    private String comName;  // 업체명
    private String clientCode; // 거래처코드
}

