package com.ssg.meowwms.domain.stock;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * 재고 실사 디테일 필드값 (제품아이디, 제품명, 소분류, 전산제고, 실사제고, 조정수량, 상태 , 상태상세)
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockTakingDetailVO {

    @NotNull
    private int stockId;

    /**
     * 제품 아이디 : 1 이상, Auto Increment
     */
    @NotNull
    @Min(value = 1, message = "제품 ID 는 1이상 이여야 합니다")
    private int productId;

    /**
     * 제품 이름 : 45자 이상
     */
    @NotNull
    @Length(max = 45, message = "제품 이름은 45자 이하여야 합니다")
    private String productName;

    /**
     * 제품 소분류 : 45자 이상
     */
    @NotNull
    @Length(max = 45, message = "카테고리 이름은 45자 이하여야 합니다")
    private String category;

    /**
     * 전산재고 : 0 이상, +값
     */
    @NotNull
    @Positive(message = "전산재고는 0 이상이여야 합니다.")
    private int computerizedStock;

    /**
     * 실사 재고 : 출고 - 입고 값, +값
     * 실사재고 값이 (-) 값으로 나온다면 말이 안되는 문제이기 때문에 오류 발생
     */
    @Nullable
    @Positive(message = "에러발생 : 실사재고는 0 이상이여야 합니다. 입출고량을 확인해주세요")
    private int actualStock;

    // 조정 수량 : 전산재고 - 실사재고
    /**
     * 조정 수량 : 전산재고 - 실사재고
     */
    @Nullable
    private int adjustmentQuantity = this.computerizedStock - this.actualStock;;

    /**
     * 재고 실사 상태 값 : 완료, 미완료, 오류
     */
    @NotNull
    private Status status;

    /**
     * 재고 실사 상태상세 : 재고 실사 상태값에 따른 담당자가 작성하는 상세
     * ex)  완료시: 문제 없음
     *      미완료시: (아직 진행안해서 상태값이 없을 것인데 "00월 00일 방문예정" 이런거도 가능)
     *      오류 : 재고 실사를 진행했으나 수량이 맞지 않음
     */
    @Nullable
    private String statusDetail;

    /**
     * 조정 수량 값이 (+)/(-) 값이면 수량 앞에 (+)/(-) 사인까지 같이 출력
     */
    @Override
    public String toString() {

        String sign ="";
        if (adjustmentQuantity > 0) {
            sign = "+";
        } else if (adjustmentQuantity < 0){
            sign = "-";
        }

        return "StockTakingDetailVO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productSubCategory='" + category + '\'' +
                ", computerizedStock=" + computerizedStock +
                ", actualStock=" + actualStock +
                ", adjustmentQuantity=" + sign + adjustmentQuantity +
                ", status=" + status +
                ", statusDetail='" + statusDetail + '\'' +
                '}';
    }
}
