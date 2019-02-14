package com.soft863.service;

import java.util.List;

import com.soft863.entity.Code;
import com.soft863.entity.PageSplit;
import com.soft863.entity.Role;
import com.soft863.entity.RoleSplit;
import com.soft863.entity.Role_Code;

public interface RoleService {

	//查看权限
	public List<Code> find();
	//添加用户前判断是否存在
 	public Role judgeRole(Role r);
	
	//添加角色
	public int addRole(Role r);
	
	//拿取存储用户的ID
	public Role updateId(Role r);
	
	//角色ID与权限ID存入中间表
	public int addRCid(Role_Code rc);
	
	//前台页面遍历数据
	public List<Role> updateRole(PageSplit r);
	//查询角色权限ID
	public List<Role_Code> referCid(Role_Code rc);
	
	public Role updaId(Role id);
	//修改角色信息
	public int alter(Role r);
	//删除角色信息
	public int deleteRole(Integer id);
	//模糊查询
	public List<Role> inquireRole(Role r);
	
	//查询角色个数
	public int countRole();
	
	public List<Role> dimRole(Role r);
	
}
