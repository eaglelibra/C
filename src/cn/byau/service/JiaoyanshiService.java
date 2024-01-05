package cn.byau.service;


import cn.byau.dao.JiaoyanshiDAO;
import cn.byau.entity.Jiaoyanshi;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tjh on 2017/5/13.
 */
@Service("JiaoyanshiService")
public class JiaoyanshiService {




	@Autowired
	private JiaoyanshiDAO cityDAO;





	public PageInfo<Jiaoyanshi> listByPage(Integer pageNum, Integer pageSize, String courseId) {
		 //将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNum, pageSize);
		List<Jiaoyanshi> list = cityDAO.listByPage(courseId);
		PageInfo<Jiaoyanshi> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}

	public void save(Jiaoyanshi course) {
		cityDAO.save(course);
	}

	public Jiaoyanshi getById(String courseId) {
		return cityDAO.getById(courseId);
	}

	public void update(Jiaoyanshi course) {
		cityDAO.update(course);
	}

	public void deleteBatch(List<String> idList) {
		cityDAO.deleteBatch(idList);
	}


}
