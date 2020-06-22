package com.apl.wms.price.service;

import com.apl.wms.price.dto.WarehousePriceItemDto;
import com.apl.wms.price.vo.WarehousePriceItemListVo;
import com.apl.wms.price.vo.WarehousePriceItemInfoVo;
import com.apl.wms.price.dto.WarehousePriceItemKeyDto;
import com.baomidou.mybatisplus.extension.service.IService;
import com.apl.lib.pojo.dto.PageDto;
import com.apl.lib.utils.ResultUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
/**
 * <p>
 *  service接口
 * </p>
 *
 * @author cy
 * @since 2020-06-22
 */
public interface WarehousePriceItemService extends IService<WarehousePriceItemDto> {

        /**
         * @Desc: 添加一个WarehousePriceItemPo实体
         * @author cy
         * @since 2020-06-22
         */
        ResultUtils<Integer> add(WarehousePriceItemDto warehousePriceItemDto);


        /**
         * @Desc: 根据id 更新一个WarehousePriceItemPo 实体
         * @author cy
         * @since 2020-06-22
         */
        ResultUtils<Boolean> updById(WarehousePriceItemDto warehousePriceItemDto);


        /**
         * @Desc: 根据id 查找一个WarehousePriceItemPo 实体
         * @author cy
         * @since 2020-06-22
         */
        ResultUtils<Boolean> delById(Long id);


        /**
         * @Desc: 根据id 查找一个 WarehousePriceItemPo 实体
         * @author cy
         * @since 2020-06-22
         */
        ResultUtils<WarehousePriceItemInfoVo> selectById(Long id);


        /**
         * @Desc: 分页查找 WarehousePriceItemPo 列表
         * @author cy
         * @since 2020-06-22
         */
        ResultUtils<Page<WarehousePriceItemListVo>>getList(PageDto pageDto, WarehousePriceItemKeyDto keyDto);

        }