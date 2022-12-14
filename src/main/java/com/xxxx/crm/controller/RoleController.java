package com.xxxx.crm.controller;

import com.xxxx.crm.base.BaseController;
import com.xxxx.crm.base.ResultInfo;
import com.xxxx.crm.query.RoleQuery;
import com.xxxx.crm.service.RoleService;
import com.xxxx.crm.vo.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: 想被你艾特
 * @Date: 2022/12/06/9:15
 * @Description:
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController {
    @Resource
    private RoleService roleService;
    @RequestMapping("queryAllRoles")
    @ResponseBody
    public List<Map<String,Object>> queryAllRoles(Integer userId){
        return roleService.queryAllRoles(userId);
    }
    /**
     * 分页条件查询角色列表
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param roleQuery
     * @return java.util.Map<java.lang.String,java.lang.Object>
     */
    @GetMapping("list")
    @ResponseBody
    public Map<String,Object> selectByParams(RoleQuery roleQuery){
        return roleService.queryByParamsForTable(roleQuery);
    }
    /**
     * 进入角色管理页面
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param
     * @return java.lang.String
     */
    @RequestMapping("index")
    public String index(){
        return "role/role";
    }
    /**
     * 添加角色
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param role
     * @return com.xxxx.crm.base.ResultInfo
     */
    @PostMapping("add")
    @ResponseBody
    public ResultInfo addRole(Role role) {
        roleService.addRoler(role);
        return success("角色添加成功！");
    }

    /***
     * 进入添加/更新角色信息的页面
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param
     * @return java.lang.String
     */
    @RequestMapping("toAddOrUpdateRolePage")
    public String toAddOrUpdateRolePage(Integer roleId, HttpServletRequest request){
        //如果roleId不为空，则表示修改操作
        if (roleId == null) {
            //通过角色ID查角色记录
            Role role = roleService.selectByPrimaryKey(roleId);
            //设置到请求域中
            request.setAttribute("role",role);
        }
        return "role/add_update";
    }

    /**
     * 修改角色
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param role
     * @return com.xxxx.crm.base.ResultInfo
     */
    @PostMapping("update")
    @ResponseBody
    public ResultInfo updateRole(Role role) {
        roleService.updateRole(role);
        return success("角色修改成功！");
    }

    /**
     * 删除角色
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param roleId
     * @return com.xxxx.crm.base.ResultInfo
     */
    @PostMapping("delete")
    @ResponseBody
    public ResultInfo deleteRole(Integer roleId) {
        roleService.deleteRole(roleId);
        return success("角色删除成功！");
    }
    /**
     * 角色授权
     *
     *
     * 乐字节：专注线上IT培训
     * 答疑老师微信：lezijie
     * @param roleId
     * @param mIds
     * @return com.xxxx.crm.base.ResultInfo
     */
    @PostMapping("addGrant")
    @ResponseBody
    public ResultInfo addGrant(Integer roleId,Integer [] mIds){
        roleService.addGrant(roleId,mIds);
        return success("角色授权成功！");
    }
}
