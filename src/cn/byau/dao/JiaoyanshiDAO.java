package cn.byau.dao;


import cn.byau.entity.Jiaoyanshi;

import java.util.List;

public interface JiaoyanshiDAO {



	int save(Jiaoyanshi city);

	/**
	 * 根据courseId查询一条记录
	 * @param courseId
	 * @return
	 */
	Jiaoyanshi getById(String courseId);

	/**
	 * 修改一条记录
	 *
	 * @param course
	 * @return
	 */
	int update(Jiaoyanshi course);




	List<Jiaoyanshi> listByPage(String courseId);



	/**
	 * 批量添加 ，从excel导入时使用
	 * @param courseList
	 * @return
	 */




	int deleteBatch(List<String> idList);

}
