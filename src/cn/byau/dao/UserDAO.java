package cn.byau.dao;

import cn.byau.entity.User;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface UserDAO {
    void delete(Integer id);
    int insert(User user);
    int update(User user);
    User getUserByUserNameAndPassword(Map map);
    User getUserById(String id);


    @Select("select  * from user where userName=#{userName}")
    User getUserName(String userName);

}
