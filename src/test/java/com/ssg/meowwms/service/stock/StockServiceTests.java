package com.ssg.meowwms.service.stock;

import com.ssg.meowwms.domain.stock.StockVO;
import com.ssg.meowwms.service.stock.StockService;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Log4j2
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class StockServiceTests {


    @Autowired
    private StockService stockService;

    @Test
    public void testStockList() {
        log.info("/test stockList");
        log.info(stockService.stockList());
        stockService.stockList();
    }

    @Test
    public void testGetStockByMainCategory(){
        String categoryId = "냉장";
        log.info("/test stock By Main Category");
        log.info(stockService.getStockByMainCategory());
        stockService.getStockByMainCategory();
    }
    @Test
    public void testGetStockByMiddleCategory(){
        String categoryId = "식품";
        log.info("/test stock By Main Category");
        log.info(stockService.getStockByMiddleCategory(categoryId));
        stockService.getStockByMiddleCategory(categoryId);
    }
    @Test
    public void testGetStockBySubCategory(){
        String categoryId = "유제품";
        log.info("/test stock By Main Category");
        log.info(stockService.getStockBySubCategory(categoryId));
        stockService.getStockBySubCategory(categoryId);
    }
    @Test
    public void testGetProductStatusList() throws ParseException {
        log.info("/test GetProductStatusList");
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = dateFormat.parse("2025-03-23");
//        Date lastyear = dateFormat.parse("2023-03-23");

//        log.info(stockService.getProductStatusList(
//                null
//                , null
//                , null
//                , null
//                , null
//                , null
//        ));
        log.info(stockService.getProductStatusList());
        stockService.getProductStatusList(
//                lastyear
//                , date
//                , "1"
//                , "냉장"
//                , "식품"
//                , "유제품"
        );
    }
    @Test
    public void testGetWarehouseStatusList(){
        log.info("/test GetWarehouseStatusList");
        log.info(stockService.getWarehouseStatusList(
//                "운양동 우유 창고"
//                ,"냉장"
//                , "식품"
//                , "유제품"
        ));

        stockService.getWarehouseStatusList(
//                "운양동 우유 창고"
//                ,"냉장"
//                , "식품"
//                , "유제품"
        );
    }

    @Test
    @Transactional
    public void testInsertStock() {
        log.info("/test Insert Stock");
        StockVO stockVO = StockVO.builder()
                .stockId(1000)
                .warehouseId(1)
                .productId(1)
                .quantity(100)
                .build();

        try {
            stockService.insertStock(stockVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("test: insertion made");
    }
}
