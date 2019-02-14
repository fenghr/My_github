package com.soft863.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft863.entity.Dept;
import com.soft863.entity.PageSplit;
import com.soft863.entity.Role;
import com.soft863.entity.User;
import com.soft863.entity.User_Role;
import com.soft863.mapper.UserMapper;
import com.soft863.service.UserService;

@Service("se")
public class UserServiceImpl implements UserService {

	@Autowired
	UserMapper userMapper;

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	// 新增
	@Override
	public int insert(User user) {
		int insert = userMapper.insert(user);

		return insert;
	}

	// 查询所有部门
	@Override
	public List<Dept> query() {
		List<Dept> query = userMapper.query();
		return query;
	}

	// 查询所有等级
	@Override
	public List<Role> queryCode() {
		List<Role> queryCole = userMapper.queryCole();
		return queryCole;
	}

	// 遍历用户信息
	@Override
	public List<User> queryUser(PageSplit ps) {
		List<User> queryUser = userMapper.queryUser(ps);
		return queryUser;
	}

	// 插入中间表
	@Override
	public int insertId(User_Role ur) {
		int insertId = userMapper.insertId(ur);
		return insertId;
	}
	//通过id编辑用户信息
	@Override
	public User update(int id) {
		User update = userMapper.update(id);
		return update;
	}
	
	//通过用户id拿到中间表的角色id
	@Override
	public List<User_Role> queryRole(User_Role id) {
		List<User_Role> queryRole = userMapper.queryRole(id);
		return queryRole;
	}

	@Override
	public int updateUser(User user) {
		int updateUser = userMapper.updateUser(user);
		return updateUser;
	}

	@Override
	public int delete(int id) {
		int delete = userMapper.delete(id);
		return delete;
	}

	@Override
	public int deleteUser(User user) {
		int deleteUser = userMapper.deleteUser(user);
		return deleteUser;
	}

	@Override
	public int insertUserRole(User user) {
		int insertUserRole = userMapper.insertUserRole(user);
		return insertUserRole;
	}

	@Override
	public List<User> selectName(String account) {
		List<User> selectName = userMapper.selectName(account);
		
		return selectName;
	}
    //模糊查询
	@Override
	public List<User> queryName(User user) {
		List<User> queryName = userMapper.queryName(user);
		return queryName;
	}

	@Override
	public int allUser() {
		int allUser = userMapper.allUser();
		return allUser;
	}

	@Override
	public List<User> download() {
		List<User> download = userMapper.download();
		return download;
	}

}
