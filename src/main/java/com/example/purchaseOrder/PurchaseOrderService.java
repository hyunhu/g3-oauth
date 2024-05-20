package com.example.purchaseOrder;

import com.example.purchaseOrder.dto.PurchaseOrderRequest;
import com.example.purchaseOrder.entities.PurchaseOrder;
import com.example.repositories.PurchaseOrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PurchaseOrderService {
    private final PurchaseOrderRepository purchaseOrderRepository;

    public PurchaseOrder savePurchaseOrder(PurchaseOrderRequest request) {
        PurchaseOrder purchaseOrder = PurchaseOrder.builder()
                .eoiId(request.getEoiId())
                .itemInfo(request.getItemInfo())
                .companyInfo(request.getCompanyInfo())
                .storeInfo(request.getStoreInfo())
                .centerInfo(request.getCenterInfo())
                .orderInfo(request.getOrderInfo())
                .statementNo(request.getStatementNo())
                .buyerName(request.getBuyerName())
                .orderType(request.getOrderType())
                .orderTypeName(request.getOrderTypeName())
                .releaseRequestYn(request.getReleaseRequestYn())
                .remarks(request.getRemarks())
                .build();

        return purchaseOrderRepository.save(purchaseOrder);
    }
}

