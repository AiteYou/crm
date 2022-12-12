package com.xxxx.crm.query;

import com.xxxx.crm.base.BaseQuery;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 想被你艾特
 * @Date: 2022/12/05/11:02
 * @Description:
 */
public class CusDevPlanQuery extends BaseQuery {
    private Integer saleChanceId;//营销机会的主键
    public Integer getSaleChanceId(){
        return saleChanceId;
    }
    public void setSaleChanceId(Integer saleChanceId){
        this.saleChanceId = saleChanceId;
    }
}
