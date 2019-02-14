package com.soft863.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.soft863.entity.Code;
import com.soft863.entity.PageSplit;
import com.soft863.entity.Role;
import com.soft863.entity.Role_Code;
import com.soft863.mapper.RoleMapper;
import com.soft863.service.RoleService;


@Service
public class RoleServiceImpl implements RoleService{
	@Resource
	RoleMapper rm=null;
	
	@Override
	public int addRole(Role r) {
		
		
		int i = rm.addRole(r);
		
		return i;
	}

	@Override
	public List<Code> find() {
		List<Code> list = rm.find();
		return list;
	}

	//查找添加角色的ID
	@Override
	public Role updateId(Role r) {
		Role role = rm.updateId(r.getName());
		return role;
	}
	//角色ID与权限ID存入中间表
	@Override
	public int addRCid(Role_Code rc) {
		int i = rm.addRCid(rc);
		return i;
	}

	//角色信息显示页面
	@Override
	public List<Role> updateRole(PageSplit r) {
		List<Role> list = rm.updateRole(r);
		return list;
	}
	
	//角色ID查询角色权限ID
	public List<Role_Code> referCid(Role_Code rc){
		List<Role_Code> list = rm.referCid(rc);
		return list;
		
	}

	@Override
	public Role updaId(Role id) {
		Role role = rm.updaId(id);
		return role;
	}

	//修改角色信息
	@Override
	public int alter(Role r) {
		int i = rm.alter(r);
		
		if(i > 0){
			//删除角色权限
			int j = rm.deleteCode(r);
			if(j>0){
				//填入新选择的权限信息
				int k = rm.updateCoid(r);
				if(k>0){
					return k;
				}
			}
		}
		return 0;
	}

	//删除角色
	@Override
	public int deleteRole(Integer id) {
		Role r = new Role(id); 
		//删除角色权限
		int i = rm.deleteCode(r);
		if(i > 0){
			//删除用户与角色中间表
			int k = rm.deleteUser_role(r);
			if(k > 0){
				int j = rm.deleteRole(r);
				if(j>0){
					return j;
				}
			}
		}
		
		return 0;
	}

	@Override
	public List<Role> inquireRole(Role r) {
		List<Role> list = rm.inquireRole(r);
		return list;
	}

	@Override
	public int countRole() {
		int countRole = rm.countRole();
		return countRole;
	}

	@Override
	public Role judgeRole(Role r) {
		
		return rm.judgeRole(r);
	}

	@Override
	public List<Role> dimRole(Role r) {
		return	rm.dimRole(r);
	}


}
