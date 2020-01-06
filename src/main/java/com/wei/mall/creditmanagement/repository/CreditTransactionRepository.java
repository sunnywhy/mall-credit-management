package com.wei.mall.creditmanagement.repository;

import com.wei.mall.creditmanagement.entity.CreditTransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CreditTransactionRepository extends JpaRepository<CreditTransactionEntity, Long> {

    @Query("SELECT SUM(e.credit) FROM CreditTransactionEntity e WHERE e.userId = :userId")
    Integer totalCredit(@Param("userId") Long userId);

    @Query(value = "SELECT * FROM credit_transaction WHERE user_id = ?1",
            countQuery = "SELECT count(*) FROM credit_transaction WHERE user_id = ?1",
            nativeQuery = true)
    Page<CreditTransactionEntity> findAllByUserId(Long userId, Pageable pageable);

    @Query(value = "SELECT * FROM credit_transaction WHERE user_id = ?1 AND credit > 0",
            countQuery = "SELECT count(*) FROM credit_transaction WHERE user_id = ?1 AND credit > 0",
            nativeQuery = true)
    Page<CreditTransactionEntity> findAllPositivesByUserId(Long userId, Pageable pageable);

    @Query(value = "SELECT * FROM credit_transaction WHERE user_id = ?1 AND credit < 0",
            countQuery = "SELECT count(*) FROM credit_transaction WHERE user_id = ?1 AND credit < 0",
            nativeQuery = true)
    Page<CreditTransactionEntity> findAllNegativesByUserId(Long userId, Pageable pageable);
}
