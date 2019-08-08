package com.spring.proxy;

/**
 * 对生产厂家需求的接口
 */
public interface IProducer {
    /**
     * 销售
     * @param money
     */
    public void saleProduct(float money);


    /**
     * 售后
     * @param money
     */
    public void afterService(float money);
}
