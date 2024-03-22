package com.ssg.meowwms.domain.User;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class MemberVO {
    @NotNull
    private String uid;
    @NotNull
    private String shopName;
    @NotNull
    private int coRegNum;
    @NotNull
    private String shopAddress;
    @NotNull
    private String businessType;
    @NotNull
    private int onlineBusinessNumber;
    private String fax;
}