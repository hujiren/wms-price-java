package com.apl.wms.price.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Min;
import com.baomidou.mybatisplus.annotation.TableName;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
public class WarehousePriceItemListVo implements Serializable {


    @TableId(value = "id", type = IdType.UUID)
    private String id;

    private Integer whType;

    private String moduleName;

    private String itemCode;

    private String itemName;

    private String itemNameEn;

    private String unitName;

    private String currency;

    private String remark;

    private static final long serialVersionUID=1L;


}