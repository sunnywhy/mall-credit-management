package com.wei.mall.creditmanagement.bo;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.Mapper;
import com.wei.mall.creditmanagement.base.BaseBo;
import com.wei.mall.creditmanagement.entity.CreditTransactionEntity;
import com.wei.mall.creditmanagement.vo.CreditTransactionVo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
public class CreditTransactionBo extends BaseBo {
    private Long id;
    private Long userId;
    private Long channelId;
    private Long eventId;
    private Integer credit;
    private LocalDateTime createdTime;

    public static CreditTransactionBo fromEntity(CreditTransactionEntity entity){
        Mapper mapper = getMapper();
        return mapper.map(entity, CreditTransactionBo.class);
    }

    public static CreditTransactionBo fromVo(CreditTransactionVo vo){
        Mapper mapper = getMapper();
        return mapper.map(vo, CreditTransactionBo.class);
    }
}
