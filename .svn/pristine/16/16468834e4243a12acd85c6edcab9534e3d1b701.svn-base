package com.soft863.mapper;

import java.util.List;

import com.soft863.entity.Dept;
import com.soft863.entity.PageSplit;
import com.soft863.entity.Role;

import com.soft863.entity.User;
import com.soft863.entity.User_Role;

public interface UserMapper {

	public User save(User user);

	// 新增用户
	public int insert(User user);

	// 查询所有的部门
	public List<Dept> query();

	// 查询所有的角色
	public List<Role> queryCole();

	// 遍历用户信息
	public List<User> queryUser(PageSplit ps);

	// 通过账号查询用户id
	public int queryId(User u);

	// 插入中间表
	public int insertId(User_Role ur);

	// 通过id编辑用户
	public User update(int id);

	// 通过用户id拿到角色id
	public List<User_Role> queryRole(User_Role id);

	// 修改用户信息
	public int updateUser(User user);

	// 通过用户名删除中间表 用户对应的角色id
    public  int  delete(int id);
    
    //通过用户id删除用户信息
    public int deleteUser(User user);
    
    //通过用户id  和循环角色id  插入中间表
    public int insertUserRole(User user);
    
    //查询所有的用户的name
    public  List<User> selectName(String account);
    
    //模糊查询
    public List<User> queryName(User user);
    
    //分页拿到用户总数据
    public int allUser();
    
    //导出
    public List<User> download();
}
