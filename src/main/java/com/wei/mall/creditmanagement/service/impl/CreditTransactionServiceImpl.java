package com.wei.mall.creditmanagement.service.impl;

import com.wei.mall.creditmanagement.bo.CreditTransactionBo;
import com.wei.mall.creditmanagement.entity.CreditTransactionEntity;
import com.wei.mall.creditmanagement.repository.CreditTransactionRepository;
import com.wei.mall.creditmanagement.service.CreditTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CreditTransactionServiceImpl implements CreditTransactionService {

    private CreditTransactionRepository creditTransactionRepository;

    @Autowired
    public CreditTransactionServiceImpl(CreditTransactionRepository creditTransactionRepository){
        this.creditTransactionRepository = creditTransactionRepository;
    }

    @Override
    public Long create(CreditTransactionBo bo) {
        CreditTransactionEntity entity = CreditTransactionEntity.fromBo(bo);
        creditTransactionRepository.save(entity);
        return entity.getId();
    }

    @Override
    public Integer getSummary(Long userId) {
        return creditTransactionRepository.totalCredit(userId);
    }

    @Override
    public Page<CreditTransactionBo> getDetails(Long userId, Integer pageNo, Integer pageSize, String sortedBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortedBy));
        return creditTransactionRepository.findAllByUserId(userId, paging).map(CreditTransactionBo::fromEntity);
    }

    @Override
    public Page<CreditTransactionBo> getPositiveDetails(Long userId, Integer pageNo, Integer pageSize, String sortedBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortedBy));
        return creditTransactionRepository.findAllPositivesByUserId(userId, paging).map(CreditTransactionBo::fromEntity);
    }

    @Override
    public Page<CreditTransactionBo> getNegativeDetails(Long userId, Integer pageNo, Integer pageSize, String sortedBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortedBy));
        return creditTransactionRepository.findAllNegativesByUserId(userId, paging).map(CreditTransactionBo::fromEntity);
    }
}
