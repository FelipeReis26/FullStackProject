package com.transport.stenlogistics.service.impl;

import com.transport.stenlogistics.constants.ErrorDetils;
import com.transport.stenlogistics.constants.IllegalList;
import com.transport.stenlogistics.entity.Goods;
import com.transport.stenlogistics.exception.GoodsException;
import com.transport.stenlogistics.repository.GoodsRepository;
import com.transport.stenlogistics.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepository repository;

    @Override
    public Goods sendGoods(Goods goods) {
        for (String itemType: IllegalList.illegalItems) {
            if(goods.getType().equalsIgnoreCase(itemType)){
                throw new GoodsException(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa").format(new Date()),ErrorDetils.TYPE_ERROR_CODE,ErrorDetils.TYPE_ERROR_MESSSAGE);
            }
        }
        if(goods.getDistance() >= 1000){
            throw new GoodsException(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa").format(new Date()),ErrorDetils.DISTANCE_ERROR_CODE,ErrorDetils.DISTANCE_ERROR_MESSAGE);
        }
        if(goods.getWeight() >= 700){
            throw new GoodsException(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa").format(new Date()),ErrorDetils.WEIGHT_ERROR_CODE,ErrorDetils.WEIGHT_ERROR_MESSAGE);
        }
        if(goods.getValue() >= 10000){
            throw new GoodsException(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss aa").format(new Date()),ErrorDetils.VALUE_ERROR_CODE,ErrorDetils.VALUE_ERROR_MESSAGE);
        }
        goods.setCreatedAt(new Date());
        return repository.save(goods);
    }

    @Override
    public Goods findById(Long id) {
        return repository.findById(id).get();
    }


    @Override
    public List<Goods> getattemptedFailures() {
        return null;
    }
}
