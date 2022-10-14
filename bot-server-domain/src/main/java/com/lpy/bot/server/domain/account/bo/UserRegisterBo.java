package com.lpy.bot.server.domain.account.bo;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterBo {
    private String qqNumber;
    private String groupNumber;
}
