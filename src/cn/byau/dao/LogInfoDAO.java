package cn.byau.dao;

import cn.byau.entity.LogInfo;

import java.util.HashMap;
import java.util.List;

public interface LogInfoDAO {
        int save(LogInfo logInfo);


       List<LogInfo> list(HashMap hm);
}
