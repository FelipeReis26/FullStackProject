package com.transport.stenlogistics.service;

import com.transport.stenlogistics.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.List;


public interface GoodsService {
    Goods sendGoods(Goods goods);
    Goods findById(Long id);
    List<Goods> getattemptedFailures();
}
