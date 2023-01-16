package com.lquan.service.impl;

import com.lquan.domain.Storage;
import com.lquan.mapper.StorageMapper;
import com.lquan.service.StorageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (Storage)表服务实现类
 *
 * @author makejava
 * @since 2023-01-17 02:53:10
 */
@Service
public class StorageServiceImpl implements StorageService {
    @Resource
    private StorageMapper storageMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Storage queryById(Long id) {
        return this.storageMapper.queryById(id);
    }



    /**
     * 新增数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
    @Override
    public Storage insert(Storage storage) {
        this.storageMapper.insert(storage);
        return storage;
    }
    
    /**
     * 新增数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
    @Override
    public Storage insertSelective(Storage storage) {
        this.storageMapper.insertSelective(storage);
        return storage;
    }
    

    /**
     * 修改数据
     *
     * @param storage 实例对象
     * @return 实例对象
     */
    @Override
    public Storage update(Storage storage) {
        this.storageMapper.update(storage);
        return this.queryById(storage.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.storageMapper.deleteById(id) > 0;
    }
}
