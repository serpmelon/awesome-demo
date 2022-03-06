package com.togo.design.seckill;

import com.togo.design.seckill.factory.ServiceFactory;
import com.togo.design.seckill.middleware.CacheService;
import com.togo.design.seckill.middleware.LimiterService;
import com.togo.design.seckill.middleware.MQService;
import com.togo.design.seckill.middleware.SQLService;
import com.togo.design.seckill.model.Result;
import com.togo.design.seckill.model.vo.StockVO;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 下午5:52 2022/3/6
 **/
public class WebAPI {

    private LimiterService limiterService;
    private CacheService cacheService;
    private MQService mqService;
    private SQLService sqlService;

    public Result<StockVO> query(String stockId) {

    }

    /**
     * @param stockId 购买商品id
     * @param amount  购买商品数量
     * @return 结果
     */
    public Result<Void> order(String stockId, int amount) {

        if (!limiterService.tryAcquire()) {
            return Result.fail("");
        }

//        cacheService.
    }

    public Result<Void> pay() {

    }
}
