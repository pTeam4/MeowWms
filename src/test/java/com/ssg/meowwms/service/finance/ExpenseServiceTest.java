package com.ssg.meowwms.service.finance;

import com.ssg.meowwms.domain.finance.ExpenseVO;
import com.ssg.meowwms.dto.finance.SalesMonthDTO;
import com.ssg.meowwms.dto.search.OptionDTO;
import com.ssg.meowwms.dto.finance.ExpenseDTO;
import com.ssg.meowwms.dto.finance.ExpenseMonthDTO;
import com.ssg.meowwms.mapper.finance.ExpenseMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExpenseServiceTest {

    @Mock
    private ExpenseMapper expenseMapper;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ExpenseServiceImpl expenseService;

    private ExpenseDTO expenseDTO;
    private ExpenseVO expenseVO;
    private OptionDTO optionDTO;

    @BeforeEach
    void setUp() {
        Date date = new Date();
        expenseDTO = ExpenseDTO.builder()
                .cost(10000)
                .type("창고 사용료")
                .warehouseId(1)
                .expenseDate(date)
                .build();
                // Assume ExpenseDTO has similar fields like ExpenseVO
        expenseVO = ExpenseVO.builder()
                .cost(10000)
                .type("창고 사용료")
                .warehouseId(1)
                .expenseDate(date)
                // Assume ExpenseVO has fields that correspond to ExpenseDTO
                .build();
        optionDTO = new OptionDTO(); // Setup optionDTO as needed

        when(modelMapper.map(any(ExpenseDTO.class), eq(ExpenseVO.class))).thenReturn(expenseVO);
        when(modelMapper.map(any(ExpenseVO.class), eq(ExpenseDTO.class))).thenReturn(expenseDTO);
    }

    @Test
    void insertExpense() {
        expenseService.insertExpense(expenseDTO);
        verify(expenseMapper, times(1)).insertExpense(expenseVO);
    }

    @Test
    void selectExpenseById() {
        when(expenseMapper.selectExpenseById(anyInt())).thenReturn(expenseVO);
        ExpenseDTO result = expenseService.selectExpenseById(1);
        assertNotNull(result);
        verify(expenseMapper, times(1)).selectExpenseById(1);
    }

    @Test
    void selectAll() {
        when(expenseMapper.selectAll(anyList())).thenReturn(Arrays.asList(expenseVO));
        List<ExpenseDTO> results = expenseService.selectAll(Arrays.asList(optionDTO));
        assertFalse(results.isEmpty());
        verify(expenseMapper, times(1)).selectAll(anyList());
    }

    @Test
    void deleteExpense() {
        expenseService.deleteExpense(1);
        verify(expenseMapper, times(1)).deleteExpense(1);
    }

    @Test
    void updateExpense() {
        expenseService.updateExpense(expenseDTO);
        verify(expenseMapper, times(1)).updateExpense(expenseVO);
    }

    @Test
    void sumExpenses() {
        when(expenseMapper.sumExpenses(anyList())).thenReturn(100);
        int sum = expenseService.sumExpenses(Arrays.asList(optionDTO));
        assertEquals(100, sum);
        verify(expenseMapper, times(1)).sumExpenses(anyList());
    }

    @Test
    void sumExpensesByYear() {
        List<ExpenseMonthDTO> expenseMonthDTOS = Arrays.asList(new ExpenseMonthDTO());
        when(expenseMapper.sumExpensesByYear(anyInt(), anyString())).thenReturn(expenseMonthDTOS);
        List<ExpenseMonthDTO> results = expenseService.sumExpensesByYear(1, "2020");
        assertFalse(results.isEmpty());
        verify(expenseMapper, times(1)).sumExpensesByYear(1, "2020");
    }

    @Test
    void allExpenseSumByYear(){
        String year = "2024";
        List<ExpenseMonthDTO> expenseMonthDTOS = expenseMapper.sumAllExpensesByYear(year);
        List<ExpenseMonthDTO> expense1 = expenseMapper.sumExpensesByYear(1, year);
        System.out.println(expenseMonthDTOS);
        System.out.println(expense1);
    }

    @Test
    void getAllyears() {
        // 가상의 연도 목록 데이터 준비
        List<String> mockYears = Arrays.asList("2024");

        // expenseMapper.getAllYears() 호출 시, 가상의 연도 목록을 반환하도록 설정
        when(expenseMapper.getAllYears()).thenReturn(mockYears);

        // 테스트 실행
        List<String> resultYears = expenseService.getAllYears();

        // 결과 검증
        assertFalse(resultYears.isEmpty(), "결과 목록이 비어 있지 않아야 합니다.");
        assertEquals(1, resultYears.size(), "결과 목록의 크기가 예상과 일치해야 합니다.");
        assertTrue(resultYears.containsAll(Arrays.asList("2024")), "예상된 연도가 모두 포함되어야 합니다.");

        // expenseMapper.getAllYears() 메소드 호출 검증
        verify(expenseMapper, times(1)).getAllYears();
    }
}
