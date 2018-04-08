package cn.AssassinG.scsycc.common.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
    public SqlSessionTemplate getSessionTemplate();
    public SqlSession getSqlSession();
    long insert(T entity);
    long insert(List<T> list);
    int update(T entity);
    int update(List<T> list);
    T getById(long id);
    int deleteById(long id);
//    public T getBy(Map<String, Object> paramMap);
//    public List<T> listBy(Map<String, Object> paramMap);
}
