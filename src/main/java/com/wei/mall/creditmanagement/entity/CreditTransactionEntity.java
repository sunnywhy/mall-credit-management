package com.wei.mall.creditmanagement.entity;

import com.github.dozermapper.core.Mapper;
import com.wei.mall.creditmanagement.bo.CreditTransactionBo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

import static com.wei.mall.creditmanagement.base.BaseObject.getMapper;

@Entity
@Table(name = "credit_transaction")
@Getter
@Setter
@NoArgsConstructor
public class CreditTransactionEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private Long userId;
  private Long channelId;
  private Long eventId;
  private Integer credit;
  private LocalDateTime createdTime;

  public static CreditTransactionEntity fromBo(CreditTransactionBo bo) {
    Mapper mapper = getMapper();
    return mapper.map(bo, CreditTransactionEntity.class);
  }
}
