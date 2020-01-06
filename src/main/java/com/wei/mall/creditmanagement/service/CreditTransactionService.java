package com.wei.mall.creditmanagement.service;

import com.wei.mall.creditmanagement.bo.CreditTransactionBo;
import org.springframework.data.domain.Page;

public interface CreditTransactionService {
    Long create(CreditTransactionBo bo);
    Integer getSummary(Long userId);
    Page<CreditTransactionBo> getDetails(Long userId, Integer pageNo, Integer pageSize, String sortedBy);
    Page<CreditTransactionBo> getPositiveDetails(Long userId, Integer pageNo, Integer pageSize, String sortedBy);
    Page<CreditTransactionBo> getNegativeDetails(Long userId, Integer pageNo, Integer pageSize, String sortedBy);
}
