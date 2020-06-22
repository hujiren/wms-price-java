package com.apl.wms.price.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.util.StringUtils;

/**
 * @author hjr start
 * @date 2020/6/21 - 15:05
 */
@TableName(value = "warehouse_price")
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value = "WarehousePriceKeyDto分页对象", description = "仓库价格")
public class WarehousePriceItemKeyDto extends Model<WarehousePriceItemKeyDto> {


    @Length(max = 100, message = "关键词长度不能超过100")
    @ApiModelProperty(name = "keyword", value = "关键词")
    private String keyword;

    @ApiModelProperty(name = "whType", value = "仓储类型: 1保税仓 2标准仓")
    @Range(min = 1, max = 2, message = "仓储类型必须为1或者2")
    private Integer whType;

    @ApiModelProperty(name = "moduleName", value = "模块")
    @Length(max = 50, message = "模块最大长度为50")
    private String moduleName;

    public String getKeyword() {
        if (keyword == null || StringUtils.isEmpty(keyword.trim())){
            return  null;
        }
        return keyword.trim();
    }

    public String getModuleName(){
        if (moduleName == null || StringUtils.isEmpty(moduleName.trim())){
            return  null;
        }
        return moduleName.trim();
    }

    public Integer getWhType(){
        if( whType == null || StringUtils.isEmpty(whType)){
            return null;
        }
        return whType;
    }

}
