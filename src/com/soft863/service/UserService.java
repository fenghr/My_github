package com.soft863.service;

import java.util.List;

import com.soft863.entity.Dept;
import com.soft863.entity.PageSplit;
import com.soft863.entity.Role;

import com.soft863.entity.User;
import com.soft863.entity.User_Role;

public interface UserService {

	//添加用户
	public int insert(User user);
	
	
	//查询所有的部门
	public List<Dept> query();
	
	//查询所有的角色
	public List<Role> queryCode();
	
	//查询所有的用户  遍历
	public  List<User> queryUser(PageSplit ps);
	
      //插入中间表
	public int insertId(User_Role ur);
	
	//通过id编辑用户信息
	public User update(int id);
	
	//通过用户id拿到中间表的角色id
	public List<User_Role> queryRole(User_Role id);
	
   //通过id修改用户信息
	public  int updateUser(User user);
	
	//通过用户id删除中间表所选择的角色信息
	public int delete(int id);
	
	//通过用户id删除用户信息
	public int deleteUser(User user);
	
	//通过用户id循环插入中间表
	public  int insertUserRole(User user);
	
	//查询所有的用户name
	public List<User> selectName(String account);
	
	//模糊查询
	public List<User> queryName(User user);
	
	//拿出用户总条数
	public int allUser();
	
	//导出
	public List<User> download();
}
