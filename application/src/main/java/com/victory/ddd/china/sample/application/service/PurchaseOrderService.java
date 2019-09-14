package com.victory.ddd.china.sample.application.service;

import com.victory.ddd.china.sample.application.dto.PurchaseOrderPlaceInfoDto;
import com.victory.ddd.china.sample.application.dto.PurchaseOrderPlaceResultDto;
import com.victory.ddd.china.sample.application.dto.PurchaseOrderSummaryDto;
import com.victory.ddd.china.sample.domain.order.PurchaseOrder;
import com.victory.ddd.china.sample.domain.order.PurchaseOrderRepo;
import lombok.NonNull;
import lombok.val;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.stream.Collectors;

@Named
public class PurchaseOrderService {

    private PurchaseOrderRepo purchaseOrderRepo;

    @Inject
    public PurchaseOrderService(PurchaseOrderRepo purchaseOrderRepo) {
        this.purchaseOrderRepo = purchaseOrderRepo;
    }

    public List<PurchaseOrderSummaryDto> getPurchaseOrdersSummary() {
        final List<PurchaseOrder> purchaseOrders = purchaseOrderRepo.findAll();
        return purchaseOrders.stream().map(PurchaseOrderSummaryDto::from).
                collect(Collectors.toList());
    }

    public PurchaseOrderPlaceResultDto placeOrder(@NonNull PurchaseOrderPlaceInfoDto createRequest) {
        PurchaseOrder order = new PurchaseOrder(createRequest.getCode());
        purchaseOrderRepo.save(order);
        val id = order.getId();
        return PurchaseOrderPlaceResultDto.from(order);
    }
}
