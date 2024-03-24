package com.ssg.meowwms.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MemberDTO {
    private String uid;
    private String shopName;
    private String coRegNum;
    private String shopAddress;
    private String businessType;
    private int onlineBusinessNumber;
    private String fax;
}