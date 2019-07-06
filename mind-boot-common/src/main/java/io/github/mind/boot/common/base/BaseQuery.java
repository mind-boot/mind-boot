package io.github.mind.boot.common.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 查询基类
 *
 * @author caoyong
 * @since 2018年1月29日 上午11:21:28
 */
public class BaseQuery implements Serializable {
    private static final long serialVersionUID = 265900375595315903L;
    /**
     * 页码数
     */
    private Integer pageNo = 1;
    /**
     * 每页条数（pageSize）
     */
    private Integer limit = 10;
    /**
     * 开始行
     */
    @JsonIgnore
    private Integer start = 0;
    /**
     *
     */
    @JsonIgnore
    private Boolean page = false;

    @JsonIgnore
    private String orderBy;

    /**
     * 总记录数
     */
    @JsonIgnore
    private Integer results;

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        //重新计算start
        start = (pageNo - 1) * limit;
        //当pageNo为空、0时，设置为第一页
        this.pageNo = (pageNo < 1) ? 1 : pageNo;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        //重新计算start
        start = (pageNo - 1) * limit;
        this.limit = limit;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Boolean getPage() {
        return page;
    }

    public void setPage(Boolean page) {
        this.page = page;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
