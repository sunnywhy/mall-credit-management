package com.wei.mall.creditmanagement.controller;

import com.wei.mall.creditmanagement.bo.CreditTransactionBo;
import com.wei.mall.creditmanagement.service.CreditTransactionService;
import com.wei.mall.creditmanagement.vo.CreditTransactionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/credit")
public class CreditTransactionController {
  private CreditTransactionService creditTransactionService;

  @Autowired
  public CreditTransactionController(CreditTransactionService creditTransactionService) {
    this.creditTransactionService = creditTransactionService;
  }

  @PostMapping(path = "/earn")
  public Long earn(@RequestBody CreditTransactionVo vo) {
    CreditTransactionBo bo = CreditTransactionBo.fromVo(vo);
    return creditTransactionService.create(bo);
  }

  @PostMapping(path = "/consume")
  public Long consume(@RequestBody CreditTransactionVo vo) {
    CreditTransactionBo bo = CreditTransactionBo.fromVo(vo);
    return creditTransactionService.create(bo);
  }

  @GetMapping(path = "/{userId}/summary")
  public Integer summary(@PathVariable Long userId) {
    return creditTransactionService.getSummary(userId);
  }

  @GetMapping(path = "/{userId}/detail")
  public Page<CreditTransactionVo> detail(
      @PathVariable Long userId,
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortedBy) {
    return creditTransactionService
        .getDetails(userId, pageNo, pageSize, sortedBy)
        .map(CreditTransactionVo::fromBo);
  }

  @GetMapping(path = "/{userId}/earn-detail")
  public Page<CreditTransactionVo> earnDetail(
      @PathVariable Long userId,
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortedBy) {
    return creditTransactionService
        .getPositiveDetails(userId, pageNo, pageSize, sortedBy)
        .map(CreditTransactionVo::fromBo);
  }

  @GetMapping(path = "/{userId}/consume-detail")
  public Page<CreditTransactionVo> consumeDetail(
      @PathVariable Long userId,
      @RequestParam(defaultValue = "0") Integer pageNo,
      @RequestParam(defaultValue = "10") Integer pageSize,
      @RequestParam(defaultValue = "id") String sortedBy) {
    return creditTransactionService
        .getNegativeDetails(userId, pageNo, pageSize, sortedBy)
        .map(CreditTransactionVo::fromBo);
  }
}
