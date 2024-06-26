package com.ssg.meowwms.dto.retrieval;

import lombok.*;

import java.time.LocalDate;

@ToString
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingOrdersListDTO {

    private int index;
    /**
     * from ShippingOrdersVO
     */
    private int id;
    private String uid;
    private LocalDate expectedDate;

    /**
     * from ShippingOrdersDetailVO
     */
    private int productId;
    private int quantity;

    /**
     * from ProductVO
     */
    private String productName;

    /**
     * from ShippingOrdersStatusVO
     */
    private int allocatedStatus;
    private int approvedStatus;
    private int waybillStatus;
}
