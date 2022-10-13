package com.lpy.bot.server.domain.userinfo.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.lpy.bot.server.commons.util.NanoIdUtil;
import lombok.*;

import java.util.Date;
import java.util.UUID;

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
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.UPDATE)
    private String updateTime;

    public void generatorUuid() {
        this.id = NanoIdUtil.randomNanoId();
    }
}
