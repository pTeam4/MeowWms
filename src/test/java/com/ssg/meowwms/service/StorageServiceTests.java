package com.ssg.meowwms.service;

import com.ssg.meowwms.dto.storage.ProductDTO;
import com.ssg.meowwms.dto.storage.StockMovementDTO;
import com.ssg.meowwms.service.storage.StorageService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StorageServiceTests {

    @Autowired
    private StorageService storageService;
    @Autowired
    private JdbcTemplate jdbcTemplate; // jdbcTemplate 추가



    @Test
    public void testRegisterStorage(){
        // 1. 제품 등록 후 ID 가져오기
        ProductDTO productDTO = ProductDTO.builder()
                .categoryId(5)
                .name("americano3")
                .brand("coffee회사")
                .price(3000)
                .salePrice(4000)
                .quantity(500)
                .volume(20)
                .userId("user8").build();
        int pid = storageService.registerProduct(productDTO);


        // 2. 입고 요청 등록
        StockMovementDTO stockMovementDTO = StockMovementDTO.builder()
                .productId(pid) // 앞서 등록한 제품의 ID를 설정
                .userId("user8")
                .statusCode("IR")
                .requestDatetime(LocalDate.from(LocalDateTime.now()))
                .build();
        storageService.registerStorage(stockMovementDTO);
    }
    @Test
    public void testApproveStorageRequest(){
        storageService.approveStorageRequest(125);

    }
    @Test
    public void testCancelStorageRequest(){
        storageService.cancelStorageRequest(125);
    }
    @Test
    public void testModifyStorageRequest(){
        ProductDTO productDTO = ProductDTO.builder()
                .categoryId(7)
                .name("americano7")
                .brand("coffee회사")
                .price(3000)
                .salePrice(5000)
                .quantity(200)
                .volume(20)
                .build();
        storageService.modifyProduct(31, productDTO);

        storageService.modifyStorageRequest(31);
    }

    @Test
    public void testStorageList(){
        log.info(storageService.getStorageList());
        storageService.getStorageList();
    }

    @Test
    public void testListByStatus(){
        String status = "IR";
        log.info(storageService.selectMovementByStatus(status));
        storageService.selectMovementByStatus(status);
    }
    @Test
    public void testListById(){
        int id = 31;
        log.info(storageService.selectStockMovementsById(id));
        storageService.selectStockMovementsById(id);
    }
}
