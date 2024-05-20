package com.example.purchaseOrder;

import com.example.purchaseOrder.dto.PurchaseOrderRequest;
import com.example.purchaseOrder.entities.PurchaseOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchase-orders")
@RequiredArgsConstructor
public class PurchaseOrderController {
    private final PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrder> createPurchaseOrder(@RequestBody PurchaseOrderRequest request) {
        PurchaseOrder savedOrder = purchaseOrderService.savePurchaseOrder(request);
        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
    }

}

