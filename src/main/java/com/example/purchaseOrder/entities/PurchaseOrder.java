package com.example.purchaseOrder.entities;

import com.example.account.entities.BaseTimeEntity;
import com.example.purchaseOrder.info.*;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 이마트, 홈플러스, 쿠팡, 롯데마트, BGF 발주서
 */
@Getter
@NoArgsConstructor
@Entity
@Table(name = "PURCHASEORDER")
public class PurchaseOrder extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String eoiId;

    @Embedded
    private ItemInfo itemInfo;

    @Embedded
    private CompanyInfo companyInfo;

    @Embedded
    private StoreInfo storeInfo;

    @Embedded
    private CenterInfo centerInfo;

    @Embedded
    private OrderInfo orderInfo;

    private String statementNo;       // 전표번호
    private String buyerName;         // 바이어명
    private String orderType;         // 납품구분코드
    private String orderTypeName;     // 납품구분명
    private String releaseRequestYn;  // 출하요청여부
    private String remarks;           // 비고

    @Builder
    public PurchaseOrder(String eoiId, ItemInfo itemInfo, CompanyInfo companyInfo, StoreInfo storeInfo,
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

    public static PurchaseOrder createPurchaseOrder(String eoiId, ItemInfo itemInfo, CompanyInfo companyInfo,
                                                    StoreInfo storeInfo, CenterInfo centerInfo, OrderInfo orderInfo,
                                                    String statementNo, String buyerName, String orderType,
                                                    String orderTypeName, String releaseRequestYn, String remarks) {
        return PurchaseOrder.builder()
                .eoiId(eoiId)
                .itemInfo(itemInfo)
                .companyInfo(companyInfo)
                .storeInfo(storeInfo)
                .centerInfo(centerInfo)
                .orderInfo(orderInfo)
                .statementNo(statementNo)
                .buyerName(buyerName)
                .orderType(orderType)
                .orderTypeName(orderTypeName)
                .releaseRequestYn(releaseRequestYn)
                .remarks(remarks)
                .build();
    }
}
