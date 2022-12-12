package com.xxxx.crm.query;

import com.xxxx.crm.base.BaseQuery;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 想被你艾特
 * @Date: 2022/12/06/15:08
 * @Description:
 */
public class RoleQuery extends BaseQuery {
    private String roleName; // 角色名称

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
