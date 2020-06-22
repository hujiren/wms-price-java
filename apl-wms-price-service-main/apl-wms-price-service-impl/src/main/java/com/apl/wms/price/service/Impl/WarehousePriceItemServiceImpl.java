package com.apl.wms.price.service.Impl;

import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtils;
import com.apl.lib.utils.SnowflakeIdWorker;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.wms.price.dto.WarehousePriceItemDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.apl.lib.constants.CommonStatusCode;

import com.apl.wms.price.mapper.WarehousePriceItemMapper;
import com.apl.wms.price.service.WarehousePriceItemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.apl.wms.price.vo.WarehousePriceItemListVo;
import com.apl.wms.price.vo.WarehousePriceItemInfoVo;
import com.apl.wms.price.dto.WarehousePriceItemKeyDto;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


/**
 * <p>
 * service实现类
 * </p>
 *
 * @author cy
 * @since 2020-06-22
 */
@Service
@Slf4j
public class WarehousePriceItemServiceImpl extends ServiceImpl<WarehousePriceItemMapper, WarehousePriceItemDto> implements WarehousePriceItemService {

//状态code枚举
/*enum WarehousePriceItemServiceCode {

        ;

        private String code;
        private String msg;

        WarehousePriceItemServiceCode(String code, String msg) {
             this.code = code;
             this.msg = msg;
        }
    }*/

    @Override
    public ResultUtils<Integer> add(WarehousePriceItemDto warehousePriceItemDto) {

        warehousePriceItemDto.setId(SnowflakeIdWorker.generateId());

        ApiParamValidate.notEmpty("whType", warehousePriceItemDto.getWhType());
        ApiParamValidate.notEmpty("itemName", warehousePriceItemDto.getItemName());
        ApiParamValidate.notEmpty("moduleName", warehousePriceItemDto.getModuleName());
        ApiParamValidate.notEmpty("itemCode", warehousePriceItemDto.getItemCode());
        ApiParamValidate.notEmpty("itemNameEn", warehousePriceItemDto.getItemNameEn());
        ApiParamValidate.notEmpty("unitName", warehousePriceItemDto.getUnitName());
        ApiParamValidate.notEmpty("currency", warehousePriceItemDto.getCurrency());
        ApiParamValidate.notEmpty("id", warehousePriceItemDto.getId());

        if (!warehousePriceItemDto.getWhType().equals(1) && !warehousePriceItemDto.getWhType().equals(2)) {
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL, "仓库类型必须为1或者2");
        }
        Integer flag = baseMapper.insert(warehousePriceItemDto);
        if (flag.equals(1)) {
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS, warehousePriceItemDto.getId());
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL, null);
    }


    @Override
    public ResultUtils<Boolean> updById(WarehousePriceItemDto warehousePriceItemDto) {

        ApiParamValidate.notEmpty("whType", warehousePriceItemDto.getWhType());
        ApiParamValidate.notEmpty("itemName", warehousePriceItemDto.getItemName());
        ApiParamValidate.notEmpty("moduleName", warehousePriceItemDto.getModuleName());
        ApiParamValidate.notEmpty("itemCode", warehousePriceItemDto.getItemCode());
        ApiParamValidate.notEmpty("itemNameEn", warehousePriceItemDto.getItemNameEn());
        ApiParamValidate.notEmpty("unitName", warehousePriceItemDto.getUnitName());
        ApiParamValidate.notEmpty("currency", warehousePriceItemDto.getCurrency());
        ApiParamValidate.notEmpty("id", warehousePriceItemDto.getId());

        if (!warehousePriceItemDto.getWhType().equals(1) && !warehousePriceItemDto.getWhType().equals(2)) {
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL, "仓库类型必须为1或者2");
        }
        Integer flag = baseMapper.updateById(warehousePriceItemDto);
        if (flag.equals(1)) {
            return ResultUtils.APPRESULT(CommonStatusCode.SAVE_SUCCESS, true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.SAVE_FAIL, false);
    }


    @Override
    public ResultUtils<Boolean> delById(Long id) {

        boolean flag = removeById(id);
        if (flag) {
            return ResultUtils.APPRESULT(CommonStatusCode.DEL_SUCCESS, true);
        }

        return ResultUtils.APPRESULT(CommonStatusCode.DEL_FAIL, false);
    }


    @Override
    public ResultUtils<WarehousePriceItemInfoVo> selectById(Long id) {

        WarehousePriceItemInfoVo warehousePriceItemInfoVo = baseMapper.getById(id);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, warehousePriceItemInfoVo);
    }


    @Override
    public ResultUtils<Page<WarehousePriceItemListVo>> getList(PageDto pageDto, WarehousePriceItemKeyDto keyDto) {

        Page<WarehousePriceItemListVo> page = new Page();
        page.setCurrent(pageDto.getPageIndex());
        page.setSize(pageDto.getPageSize());

        List<WarehousePriceItemListVo> list = baseMapper.getList(page, keyDto);
        page.setRecords(list);

        return ResultUtils.APPRESULT(CommonStatusCode.GET_SUCCESS, page);
    }

}