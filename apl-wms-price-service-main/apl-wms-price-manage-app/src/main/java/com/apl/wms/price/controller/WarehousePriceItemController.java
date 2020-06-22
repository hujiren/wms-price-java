package com.apl.wms.price.controller;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtils;
import com.apl.lib.validate.ApiParamValidate;
import com.apl.wms.price.dto.WarehousePriceItemDto;
import com.apl.wms.price.dto.WarehousePriceItemKeyDto;
import com.apl.wms.price.service.WarehousePriceItemService;
import com.apl.wms.price.vo.WarehousePriceItemInfoVo;
import com.apl.wms.price.vo.WarehousePriceItemListVo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.NotNull;

/**
 * @author hjr start
 * @date 2020/6/21 - 14:50
 */

@RestController
@RequestMapping(value = "/wh-price")
@Validated
@Slf4j
@Api(value = "价格项目", tags = "价格项目")
public class WarehousePriceItemController {

    @Autowired
    public WarehousePriceItemService warehousePriceItemService;


    @PostMapping(value = "/add")
    @ApiOperation(value =  "添加", notes ="添加")
    public ResultUtils<Integer> add(WarehousePriceItemDto warehousePriceItemDto) {
        return warehousePriceItemService.add(warehousePriceItemDto);
    }


    @PostMapping(value = "/upd")
    @ApiOperation(value =  "更新",  notes ="更新")
    public ResultUtils<Boolean> updById(WarehousePriceItemDto warehousePriceItemDto) {
        ApiParamValidate.notEmpty("id", warehousePriceItemDto.getId());
        return warehousePriceItemService.updById(warehousePriceItemDto);
    }


    @PostMapping(value = "/del")
    @ApiOperation(value =  "删除" , notes = "删除")
    @ApiImplicitParam(name = "id",value = " id",required = true  , paramType = "query")
    public ResultUtils<Boolean> delById(@NotNull(message = "id不能为空") Long id) {
        return warehousePriceItemService.delById(id);
    }


    @PostMapping(value = "/get")
    @ApiOperation(value =  "获取详细" , notes = "获取详细")
    @ApiImplicitParam(name = "id",value = "id",required = true  , paramType = "query")
    public ResultUtils<WarehousePriceItemInfoVo> selectById(@NotNull(message = "id不能为空") Long id) {
        return warehousePriceItemService.selectById(id);
    }


    @PostMapping("/get-list")
    @ApiOperation(value =  "分页查找" , notes = "分页查找")
    public ResultUtils<Page<WarehousePriceItemListVo>> getList(PageDto pageDto, WarehousePriceItemKeyDto keyDto) {
        return warehousePriceItemService.getList(pageDto, keyDto);
    }

}
