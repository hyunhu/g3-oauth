package com.example.purchaseOrder.dto;

import com.example.purchaseOrder.info.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PurchaseOrderRequest {
    private String eoiId;
    private ItemInfo itemInfo;
    private CompanyInfo companyInfo;
    private StoreInfo storeInfo;
    private CenterInfo centerInfo;
    private OrderInfo orderInfo;
    private String statementNo;
    private String buyerName;
    private String orderType;
    private String orderTypeName;
    private String releaseRequestYn;
    private String remarks;

    @Builder
    public PurchaseOrderRequest(String eoiId, ItemInfo itemInfo, CompanyInfo companyInfo, StoreInfo storeInfo,
                                CenterInfo centerInfo, OrderInfo orderInfo, String statementNo, String buyerName,
                                String orderType, String orderTypeName, String releaseRequestYn, String remarks) {
        this.eoiId = eoiId;
        this.itemInfo = itemInfo;
        this.companyInfo = companyInfo;
        this.storeInfo = storeInfo;
        this.centerInfo = centerInfo;
        this.orderInfo = orderInfo;
        this.statementNo = statementNo;
        this.buyerName = buyerName;
        this.orderType = orderType;
        this.orderTypeName = orderTypeName;
        this.releaseRequestYn = releaseRequestYn;
        this.remarks = remarks;
    }
}


