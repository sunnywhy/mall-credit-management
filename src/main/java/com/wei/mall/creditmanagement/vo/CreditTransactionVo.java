package com.wei.mall.creditmanagement.vo;

import com.github.dozermapper.core.Mapper;
import com.wei.mall.creditmanagement.bo.CreditTransactionBo;
import lombok.Data;

import java.time.LocalDateTime;

import static com.wei.mall.creditmanagement.base.BaseObject.getMapper;

@Data
public class CreditTransactionVo {
    private Long id;
    private Long userId;
    private Long channelId;
    private Long eventId;
    private Integer credit;
    private LocalDateTime createdTime;

    public static CreditTransactionVo fromBo(CreditTransactionBo bo){
        Mapper mapper = getMapper();
        return mapper.map(bo, CreditTransactionVo.class);
    }
}
