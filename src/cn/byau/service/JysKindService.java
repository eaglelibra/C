package cn.byau.service;


import cn.byau.dao.JysKindDAO;
import cn.byau.entity.JysKind;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by tjh on 2017/5/13.
 */
@Service("JysKindService")
public class JysKindService {

    @Autowired
    private JysKindDAO courseKindDAO;

    public List<JysKind> list() {
        return courseKindDAO.list();
    }
    public JysKind getByKindId(String kindId) {
        return courseKindDAO.getByKindId(kindId);
    }

    public void save(JysKind courseKind) {
    	courseKindDAO.save(courseKind);
	}



	public void update(JysKind courseKind) {
		courseKindDAO.update(courseKind);
	}



	public void delete(String kindId) {
		courseKindDAO.delete(kindId);
	}
	/**
     *   这个方法中用到了分页插件pagehelper
     *   很简单，只需要在service层传入参数，然后将参数传递给一个插件的一个静态方法即可；
     * @param pageNum 开始页数
     * @param pageSize 每页显示的数据条数

     * @return
     */
	public PageInfo<JysKind> listByPage(Integer pageNum, Integer pageSize) {
		 //将参数传给这个方法就可以实现物理分页了，非常简单。
		PageHelper.startPage(pageNum, pageSize);
		List<JysKind> list = courseKindDAO.list();
		PageInfo<JysKind> pageInfo = new PageInfo<>(list);
		return pageInfo;
	}



}
