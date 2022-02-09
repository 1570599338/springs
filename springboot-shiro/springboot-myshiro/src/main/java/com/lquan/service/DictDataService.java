package com.lquan.service;

import com.lquan.domain.DictData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 字典数据表(DictData)表服务接口
 *
 * @author makejava
 * @since 2022-02-08 23:58:30
 */
public interface DictDataService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DictData queryById(Long id);

    /**
     * 分页查询
     *
     * @param dictData 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DictData> queryByPage(DictData dictData, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dictData 实例对象
     * @return 实例对象
     */
    DictData insert(DictData dictData);
    
        /**
     * 新增数据
     *
     * @param dictData 实例对象
     * @return 实例对象
     */
    DictData insertSelective(DictData dictData);

    /**
     * 修改数据
     *
     * @param dictData 实例对象
     * @return 实例对象
     */
    DictData update(DictData dictData);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);


    /**
     * 根据字典类型查询字典数据
     *
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    public List<DictData> selectDictDataByType(String dictType);


    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String selectDictLabel(String dictType, String dictValue);


}
