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
@TableName("user_info")
public class UserInfoEntity {

    @TableId
    private String id;

    private byte[] qqNumber;

    private String groupSerial;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;

    public void generatorUuid() {
        setId(NanoIdUtil.randomNanoId());
    }
}
