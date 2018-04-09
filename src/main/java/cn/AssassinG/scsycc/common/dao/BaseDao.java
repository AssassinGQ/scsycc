package cn.AssassinG.scsycc.common.dao;

import cn.AssassinG.scsycc.common.page.PageBean;
import cn.AssassinG.scsycc.common.page.PageParam;
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
    int delete(T entity);
    public List<T> listAll();
    public T getBy(Map<String, Object> paramMap);
    public List<T> listBy(Map<String, Object> paramMap);
    public PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap);
}
