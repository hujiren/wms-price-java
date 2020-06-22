package com.apl.wms.price.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cy
 * @since 2020-06-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="WarehousePriceItem对象", description="项目价格")
public class WarehousePriceItem extends Model<WarehousePriceItem> {

private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.UUID)
    private Long id;

    private Boolean whType;

    private String moduleName;

    private String itemCode;

    private String itemName;

    private String itemNameEn;

    private String unitName;

    private String currency;

    private String remark;

    private Long innerOrgId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
