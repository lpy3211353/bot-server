package com.lpy.bot.server.domain.account.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lpy.bot.server.commons.util.NanoIdUtil;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("group_info")
public class GroupInfoEntity {
    @TableId
    private String id;
    private byte[] groupNumber;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;

    public void generatorUuid() {
        setId(NanoIdUtil.randomNanoId());
    }
}
