package com.ssg.meowwms.service.warehouse;

import com.ssg.meowwms.domain.warehouse.WarehouseVO;
import com.ssg.meowwms.dto.search.OptionDTO;
import com.ssg.meowwms.dto.warehouse.WarehouseDTO;
import com.ssg.meowwms.dto.warehouse.WarehouseDetailDTO;

import com.ssg.meowwms.mapper.warehouse.WarehouseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Log4j2
@Service
@RequiredArgsConstructor
public class WarehouseServiceImpl implements WarehouseService{
    private final WarehouseMapper warehouseMapper;
    private final ModelMapper modelMapper;

    @Override
    public WarehouseDTO getWarehouse(String name) {
        WarehouseVO warehouseVO = warehouseMapper.selectOne(name);

        return modelMapper.map(warehouseVO, WarehouseDTO.class);
    }

    @Override
    public void register(WarehouseDTO warehouseDTO) {
        log.info("register...!!!");

        WarehouseVO warehouseVO = modelMapper.map(warehouseDTO, WarehouseVO.class);

        log.info("WarehouseVO: " + warehouseVO);

        warehouseMapper.insert(warehouseVO);
    }

    @Override
    public List<WarehouseDTO> selectAll(List<OptionDTO> optionList) {
        List<WarehouseVO> warehouseVOList = warehouseMapper.selectAll(optionList);

        return warehouseVOList.stream()
                .map(warehouseVO -> modelMapper.map(warehouseVO, WarehouseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<WarehouseDetailDTO> getWarehouseDetail(int warehouseId) {
        return warehouseMapper.selectWarehouseDetail(warehouseId);
    }

    @Override
    public List<WarehouseDTO> getWarehouseWithCategory(String category) {
        return warehouseMapper.selectWarehouseWithCategory(category);
    }

    @Override
    public Optional<Integer> getWarehouseIdByName(String warehouseName) {
        return warehouseMapper.selectIdByName(warehouseName);
    }

    @Override
    public List<Integer> getAllWarehouseId() {
        return warehouseMapper.selectAllWarehouseId();
    }

    @Override
    public List<WarehouseDTO> getAllWarehouse() {
        return warehouseMapper.selectAllWarehouse().stream()
                .map(warehouseVO -> modelMapper.map(warehouseVO, WarehouseDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public int getSumOfVolume() {
        return warehouseMapper.selectSumOfVolume();
    }
}
