package cn.zealon.book.system.org.controller;import cn.zealon.book.common.base.BaseController;import cn.zealon.book.common.result.Result;import cn.zealon.book.system.org.bo.OrgPermissionBO;import cn.zealon.book.system.org.entity.OrgPermission;import cn.zealon.book.system.org.service.OrgPermissionService;import org.springframework.beans.factory.annotation.Autowired;import org.springframework.web.bind.annotation.*;/** * 菜案权限接口 * @author: zealon * @since: 2020/2/6 */@RestController@RequestMapping("system/org/permission")public class OrgPermissionController extends BaseController {    @Autowired    private OrgPermissionService orgPermissionService;    @PostMapping("/create")    public Result create(@RequestBody OrgPermission record){        return orgPermissionService.create(record);    }    @PutMapping("/update")    public Result update(@RequestBody OrgPermissionBO record){        return orgPermissionService.update(record);    }    @DeleteMapping("/delete")    public Result delete(Integer parentId,Integer id){        return orgPermissionService.deleteById(parentId,id);    }    /**     * 获取权限列表     * @param parentId  父级ID     * @return     */    @GetMapping("/get-list")    public Result getList(Integer parentId){        return this.orgPermissionService.getList(parentId);    }    @GetMapping("/details")    public Result details(Integer id){        return orgPermissionService.findById(id);    }    @GetMapping("/edit-details")    public Result getEditDetails(Integer id){        return orgPermissionService.getEditDetails(id);    }    /**     * 获取 Cascader 组件选项数据源     * @return     */    @GetMapping("/get-parent-cascader-options")    public Result getParentCascaderOptions(){        return this.orgPermissionService.getParentCascaderOptions();    }    @GetMapping("/get-tree-options")    public Result getPermissionTreeOptions(){        return this.orgPermissionService.getPermissionTree();    }    /**     * 获取用户菜单JSON     * @param userId     * @return     */    @GetMapping("/get-user-menus")    public Result getUserMenus(String userId){        return this.orgPermissionService.getUserMenus(userId);    }    /**     * 获取用户路由     * @return     */    @GetMapping("/get-user-router")    public Result getUserRouters(String userId){        return this.orgPermissionService.getUserRouters(userId);    }}