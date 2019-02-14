package com.soft863.mapper;

import java.util.List;

import com.soft863.entity.Code;
import com.soft863.entity.ListCode;
import com.soft863.entity.PageSplit;
import com.soft863.entity.Role;
import com.soft863.entity.RoleSplit;
import com.soft863.entity.Role_Code;

public interface RoleMapper {
	//查询权限表
	public List<Code> find();
	//添加角色前查看是否存在用户
	public Role judgeRole(Role r);
	
	//添加角色
	public int addRole(Role r);
	
	//查找添加用户的ID
	public Role updateId(String name);
	
	//角色ID与权限ID添加进中间表
	public int addRCid(Role_Code rc);
	
	//角色前台显示
	public List<Role> updateRole(PageSplit r);
	
	//角色权限ID
	public List<Role_Code> referCid(Role_Code rc);
	
	//通过ID查询角色信息
	public Role updaId(Role id);
	//修改角色信息
	public int alter(Role r);
	//删除角色信息
	public int deleteRole(Role id);
	//删除角色权限
	public int deleteCode(Role r);
	//循环添加角色权限
	public int updateCoid(Role r);
	
	//模糊查询角色信息
	public List<Role> inquireRole(Role r);
	
	//查询角色个数
	public int countRole();
	
	//模糊查询分页
	public List<Role> dimRole(Role r);
	//删除角色与用户中间表
	public int deleteUser_role(Role r);
}
