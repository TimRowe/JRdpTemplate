package com.rdp.template.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "tbLOG_Site")
public class Site {
    @TableField(value = "Site_ID")
    @TableId
    private int siteId;

    @TableField(value = "Site_Desc")
    private String siteDesc;

    @TableField(value = "Status_Flag")
    private int statusFlag;
}
