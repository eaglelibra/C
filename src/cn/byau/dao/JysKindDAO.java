package cn.byau.dao;


import cn.byau.entity.JysKind;

import java.util.List;

public interface JysKindDAO {
	List<JysKind> list();

	JysKind getByKindId(String kindId);
	int delete(String kindId);

    int save(JysKind record);



    int update(JysKind record);



}
