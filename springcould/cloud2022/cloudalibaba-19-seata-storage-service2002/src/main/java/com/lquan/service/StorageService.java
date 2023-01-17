package com.lquan.service;

import com.lquan.domain.Storage;


/**
 * (Storage)表服务接口
 *
 * @author makejava
 * @since 2023-01-17 02:53:10
 */
public interface StorageService {

    // 扣减库存
    void decrease(Long productId, Integer count);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Storage queryById(Long id);


    /**
     * 新增数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
    Storage insert(Storage storage);
    
        /**
     * 新增数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
    Storage insertSelective(Storage storage);

    /**
     * 修改数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
    Storage update(Storage storage);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}
