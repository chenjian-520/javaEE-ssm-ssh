package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.electiveMapper;
import pojo.Elective;
import service.ElectiveService;
@Service("electiveservice")
public class ElectiveServiceImple implements ElectiveService {

	@Autowired
	private electiveMapper mapper;
	@Override
	public List<Elective> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public Elective findOne(Elective c) {
		// TODO Auto-generated method stub
		return mapper.findOne(c);
	}

	@Override
	public int update(Elective c) {
		// TODO Auto-generated method stub
		return mapper.update(c);
	}

	@Override
	public int insert(Elective c) {
		// TODO Auto-generated method stub
		return mapper.insert(c);
	}

	@Override
	public int delete(Elective c) {
		// TODO Auto-generated method stub
		return mapper.delete(c);
	}

}
