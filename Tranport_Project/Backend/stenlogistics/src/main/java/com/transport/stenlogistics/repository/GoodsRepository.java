package com.transport.stenlogistics.repository;

import com.transport.stenlogistics.entity.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {

}
