package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.classMapper;
import pojo.Class1;
import service.ClassService;


@Service("classservice")
public class ClassServiceImple implements ClassService {
	
	@Autowired
	private classMapper mapper;
	
	@Override
	public List<Class1> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll() ;
	}

	@Override
	public Class1 findOne(String name) {
		// TODO Auto-generated method stub
		return mapper.findOne(name);
	}

	@Override
	public int update(Class1 c) {
		// TODO Auto-generated method stub
		return mapper.update(c);
	}

	@Override
	public int insert(Class1 c) {
		// TODO Auto-generated method stub
		return mapper.insert(c);
	}

	@Override
	public int delete(Class1 c) {
		// TODO Auto-generated method stub
		return mapper.delete(c);
	}

	@Override
	public List<Class1> selectAll() {
		// TODO Auto-generated method stub
		return mapper.selectAll();
	}

}
