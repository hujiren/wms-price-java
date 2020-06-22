package com.apl.wms.price.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

/**
 * @author hjr start
 * @date 2020/6/21 - 15:05
 */
@TableName(value = "warehouse_price_item")
@Data
@ApiModel(value = "WarehousePriceItemPo持久化对象", description = "项目价格")
@EqualsAndHashCode(callSuper = false)
public class WarehousePriceItemPo extends Model<WarehousePriceItemPo> {


    @TableId(value = "id", type = IdType.UUID)
    @ApiModelProperty(value = "id", hidden = true)
    private Long id;

    @Length(max = 1, message = "仓库类型长度不能超过1")
    @NotEmpty(message = "仓库类型不能为空")
    @ApiModelProperty(name = "whType", value = "仓库类型:1保税仓 2标准仓", required = true)
    @Range(min = 1, max = 2, message = "仓库类型必须为1或者2")
    private Integer whType;

    @Length(max = 30, message = "模块长度不能超过30")
    @NotEmpty(message = "模块不能为空")
    @ApiModelProperty(name = "moduleName", value = "模块", required = true)
    private String moduleName;

    @Length(max = 50, message = "代码长度不能超过50")
    @NotEmpty(message = "代码不能为空")
    @ApiModelProperty(name = "itemCode", value = "代码", required = true)
    private String itemCode;

    @Length(max = 50, message = "名称长度不能超过50")
    @NotEmpty(message = "名称不能为空")
    @ApiModelProperty(name = "itemName", value = "名称", required = true)
    private String itemName;

    @Length(max = 50, message = "英文名长度不能超过50")
    @NotEmpty(message = "英文名不能为空")
    @ApiModelProperty(name = "itemNameEn", value = "英文名", required = true)
    private String itemNameEn;

    @Length(max = 30, message = "单位长度不能超过30")
    @NotEmpty(message = "单位不能为空")
    @ApiModelProperty(name = "unitName", value = "单位", required = true)
    private String unitName;

    @Length(max = 5, message = "币制长度不能超过5")
    @NotEmpty(message = "币制不能为空")
    @ApiModelProperty(name = "currency", value = "币制", required = true)
    private String currency;

    @Length(max = 255, message = "备注长度不能超过255")
    @ApiModelProperty(name = "remark", value = "备注")
    private String remark;

    @Length(max = 30, message = "组织id长度不能超过30")
    @ApiModelProperty(name = "innerOrgId", value = "组织id", hidden = true)
    private Long innerOrgId;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
