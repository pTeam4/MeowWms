package com.ssg.meowwms.dto.storage;

import lombok.*;

import java.sql.Blob;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class QrcodeDTO {
    private int id;
    private int productId;
    private Blob barcodeData;
    private Date creationDate;
}
