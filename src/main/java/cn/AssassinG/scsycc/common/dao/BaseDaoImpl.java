package cn.AssassinG.scsycc.common.dao;

import cn.AssassinG.scsycc.common.entity.BaseEntity;
import cn.AssassinG.scsycc.common.page.PageBean;
import cn.AssassinG.scsycc.common.page.PageParam;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDaoImpl<T extends BaseEntity> extends SqlSessionDaoSupport implements BaseDao<T> {

    public static final String SQL_INSERT = "insert";
    public static final String SQL_BATCH_INSERT = "batchInsert";
    public static final String SQL_UPDATE = "update";
    public static final String SQL_BATCH_UPDATE = "batchUpdate";
    public static final String SQL_GET_BY_ID = "getById";
    public static final String SQL_DELETE_BY_ID = "deleteById";
    public static final String SQL_DELETE = "delete";
    public static final String SQL_LIST_ALL = "listAll";
    public static final String SQL_LIST_BY = "listBy";
    public static final String SQL_LIST_PAGE_COUNT = "listPageCount";
    public static final String SQL_LIST_PAGE = "listPage";
//    public static final String SQL_COUNT_BY_PAGE_PARAM = "countByPageParam"; // 根据当前分页参数进行统计

    private SqlSessionTemplate sessionTemplate;
    public SqlSessionTemplate getSessionTemplate() {
        return sessionTemplate;
    }

    public void setSessionTemplate(SqlSessionTemplate sessionTemplate) {
        this.sessionTemplate = sessionTemplate;
    }

    public SqlSession getSqlSession() {
        return super.getSqlSession();
    }

    public long insert(T entity) {
        int result = sessionTemplate.insert(getStatement(SQL_INSERT), entity);

        if (result <= 0) {
            //throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}", getStatement(SQL_INSERT));
            throw new RuntimeException("数据库insert操作返回0");
        }

        if (entity != null && entity.getId() != null && result > 0) {
            return entity.getId();
        }

        return result;
    }

    public long insert(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }

        int result = sessionTemplate.insert(getStatement(SQL_BATCH_INSERT), list);

        if (result <= 0) {
            //throw BizException.DB_INSERT_RESULT_0.newInstance("数据库操作,insert返回0.{%s}", getStatement(SQL_INSERT));
            throw new RuntimeException("数据库insert操作返回0");
        }
        return result;
    }

    public int update(T entity) {
        int result = sessionTemplate.update(getStatement(SQL_UPDATE), entity);
        if (result <= 0) {
            //throw BizException.DB_UPDATE_RESULT_0.newInstance("数据库操作,update返回0.{%s}", getStatement(SQL_UPDATE));
            throw new RuntimeException("数据库update操作返回0");
        }
        return result;
    }

    public int update(List<T> list) {
        if (list == null || list.size() <= 0) {
            return 0;
        }

        int result = sessionTemplate.update(getStatement(SQL_BATCH_UPDATE), list);
        if (result <= 0) {
//            throw BizException.DB_UPDATE_RESULT_0.newInstance("数据库操作,update返回0.{%s}", getStatement(SQL_UPDATE));
            throw new RuntimeException("数据库update操作返回0");
        }
        return result;
    }

    public T getById(long id) {
        return sessionTemplate.selectOne(getStatement(SQL_GET_BY_ID), id);
    }

    public int deleteById(long id) {
        return (int) sessionTemplate.delete(getStatement(SQL_DELETE_BY_ID), id);
    }

    public int delete(T entity) {
        int result = sessionTemplate.update(getStatement(SQL_DELETE), entity);
        if (result <= 0) {
            //throw BizException.DB_UPDATE_RESULT_0.newInstance("数据库操作,update返回0.{%s}", getStatement(SQL_UPDATE));
            throw new RuntimeException("数据库delete操作返回0");
        }
        return result;
    }

    public List<T> listAll() {
        return sessionTemplate.selectList(getStatement(SQL_LIST_ALL));
    }

    public T getBy(Map<String, Object> paramMap) {
        if (paramMap == null || paramMap.isEmpty()) {
            return null;
        }
        try{
            return sessionTemplate.selectOne(getStatement(SQL_LIST_BY), paramMap);
        }catch (TooManyResultsException e){
            throw new RuntimeException("数据库查询到多个结果");
        }
    }

    public List<T> listBy(Map<String, Object> paramMap) {
        if (paramMap == null || paramMap.isEmpty()) {
            return null;
        }
        return sessionTemplate.selectList(getStatement(SQL_LIST_BY), paramMap);
    }

    public PageBean<T> listPage(PageParam pageParam, Map<String, Object> paramMap) {
        if (paramMap == null) {
            paramMap = new HashMap<String, Object>();
        }

        // 根据页面传来的分页参数构造SQL分页参数
        paramMap.put("pageFirst", (pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("pageSize", pageParam.getNumPerPage());
        paramMap.put("startRowNum", (pageParam.getPageNum() - 1) * pageParam.getNumPerPage());
        paramMap.put("endRowNum", pageParam.getPageNum() * pageParam.getNumPerPage());

        // 统计总记录数
        Long count = sessionTemplate.selectOne(getStatement(SQL_LIST_PAGE_COUNT), paramMap);

        // 获取分页数据集
        List<T> list = sessionTemplate.selectList(getStatement(SQL_LIST_PAGE), paramMap);

        Object isCount = paramMap.get("isCount"); // 是否统计当前分页条件下的数据：1:是，其他为否
        if (isCount != null && "1".equals(isCount.toString())) {
//            Map<String, Object> countResultMap = sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
//            return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list, countResultMap);
            //暂不统计
            return new PageBean<T>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
        } else {
            // 构造分页对象
            return new PageBean<T>(pageParam.getPageNum(), pageParam.getNumPerPage(), count.intValue(), list);
        }
    }

    public String getStatement(String sqlId) {
        String name = this.getClass().getName();
        StringBuffer sb = new StringBuffer();
        sb.append(name).append(".").append(sqlId);
        String statement = sb.toString();

        return statement;
    }
}
