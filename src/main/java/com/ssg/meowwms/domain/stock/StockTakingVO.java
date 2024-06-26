package com.ssg.meowwms.domain.stock;


import com.fasterxml.jackson.annotation.JsonFormat;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import groovyjarjarantlr4.v4.runtime.misc.Nullable;
import jakarta.validation.constraints.Min;

import lombok.*;
import org.hibernate.validator.constraints.Length;


import java.util.Date;

/**
 * 재고실사 필드값 (실사아이디, 재고이름, 실사일자, 담당자, 상태, 상태상세)
 */
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class StockTakingVO {

    /**
     * 재고실사 아이디 : 1 이상, Auto Increment
     */
    @NotNull
    @Min(value = 1, message = "재고실사 ID 는 1이상 이여야 합니다")
    private int stockTakingId;


    private int warehouseId;

    /**
     * 재고아이디 : 1 이상, Auto Increment
     */
    @NotNull
    @Min(value = 1, message = "재고 ID 는 1이상 이여야 합니다")
    private int stockId;

    /**
     * 실사일자 : yyyy-MM-dd 형식, 한국(서울) 시간
     */
    @NotNull
    @JsonFormat(pattern ="yyyy-MM-dd", timezone = "Asia/Seoul")
    private Date plannedDate;

    /**
     * 재고 실사 담당자 이름 : 45자 제한
     */
    @NotNull
    @Length(max = 45)
    private String inspector;

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

    private int quantity;

}
