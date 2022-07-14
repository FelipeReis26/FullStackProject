package com.transport.stenlogistics.controller;

import com.transport.stenlogistics.entity.Goods;
import com.transport.stenlogistics.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/transport")
public class TansportController {

    @Autowired
    private GoodsService service;

    @PostMapping("/send")
    public ResponseEntity<Goods> sendGoods(@RequestBody Goods goods) {
        return ResponseEntity.ok(service.sendGoods(goods));
    }

    @GetMapping("/get/{goodsId}")
    public ResponseEntity<Goods> getGoodById(@PathVariable("goodsId") Long goodsId) {
        return ResponseEntity.ok(service.findById(goodsId));
    }

}
