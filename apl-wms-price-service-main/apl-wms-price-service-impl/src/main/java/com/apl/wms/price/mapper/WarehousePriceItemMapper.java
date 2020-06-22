package com.apl.wms.price.mapper;

import com.apl.wms.price.dto.WarehousePriceItemDto;
import com.apl.wms.price.vo.WarehousePriceItemListVo;
import com.apl.wms.price.vo.WarehousePriceItemInfoVo;
import com.apl.wms.price.dto.WarehousePriceItemKeyDto;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author cy
 * @since 2020-06-22
 */
@Repository
public interface WarehousePriceItemMapper extends BaseMapper<WarehousePriceItemDto> {

    /**
     * @Desc: 根据id 查找详情
     * @Author: ${cfg.author}
     * @Date: 2020-06-22
     */
    public WarehousePriceItemInfoVo getById(@Param("id") Long id);

    /**
     * @Desc: 查找列表
     * @Author: ${cfg.author}
     * @Date: 2020-06-22
     */
    List<WarehousePriceItemListVo> getList(Page page, @Param("kd") WarehousePriceItemKeyDto keyDto);


}