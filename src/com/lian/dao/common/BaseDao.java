package com.lian.dao.common;

import java.util.List;

import com.lian.util.PageModel;

public interface BaseDao<T> {
	/**
	 * 新增一个实例
	 * @param entity 要新增的实例 
	 */
	public void save(T entity);
	
	/**
	 * 根据主键删除一个实例 
	 * @param id 主键
	 */
	public void delete(int id);
	
	/**
	 * 编辑指定实例的详细信息
	 * @param entity 实例 
	 */
	public void edit(T entity);
	
	/**
	 * 根据主键获取对应的实例 
	 * @param id 主键值
	 * @return 如果查询成功，返回符合条件的实例;如果查询失败，返回null
	 */
	public T get(Integer id);
	
	/**
	 * 根据主键获取对应的实例 
	 * @param id 主键值
	 * @return 如果查询成功，返回符合条件的实例;如果查询失败，抛出空指针异常
	 */
//	public T load(Integer id);
	
	/**
	 * 获取所有实体实例列表
	 * @return 符合条件的实例列表
	 */
	public List<T> getAll();
	
	/**
	 * 统计总实体实例的数量
	 * @return 总数量
	 */
	public int getTotalCount();
	
	/**
	 * 获取分页列表
	 * @param pageNo 当前页号
	 * @param pageSize 每页要显示的记录数
	 * @return 符合分页条件的分页模型实例
	 */
	public PageModel<T> getByPager(int pageNo, int pageSize);
	
	/**
	 * 根据指定的SQL语句和参数值执行更新数据的操作
	 * @param sql SQL语句
	 * @param paramValues 参数值数组
	 */
//	public void update(String sql);
	
	/**
	 * 根据指定的SQL语句和参数值执行单个对象的查询操作
	 * @param sql SQL语句
	 * @param paramValues 参数值
	 * @return 符合条件的实体对象
	 */
//	public T getUnique(String sql);
}
