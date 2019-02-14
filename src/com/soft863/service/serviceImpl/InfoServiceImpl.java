package com.soft863.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.soft863.entity.Info;
import com.soft863.entity.Types;
import com.soft863.mapper.InfoMapper;
import com.soft863.service.InfoService;

@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	InfoMapper infoMapper;

	@Override
	public List<Info> queryInfo(Info info) {
		return infoMapper.queryInfo(info);
	}

	@Override
	public int delInfo(Integer[] id) {
		return infoMapper.delInfo(id);
	}

	@Override
	public List<Info> queryexcel() {
		return infoMapper.queryexcel();
	}

	@Override
	public int updateState(Info info) {
		return infoMapper.updateState(info);
	}

	@Override
	public List<Info> queryInfos() {
		return infoMapper.queryInfos();
	}

	@Override
	public int addInfo(Info info) {
		return infoMapper.addInfo(info);
	}

	@Override
	public List<Types> queryType() {
		return infoMapper.queryType();
	}

	@Override
	public Info queryInfoids(int id) {
		return infoMapper.queryInfoids(id);
	}

	@Override
	public int updateInfo(Info info) {
		return infoMapper.updateInfo(info);
	}

	@Override
	public int countInfo(Info info) {
		return infoMapper.countInfo(info);
	}

}
