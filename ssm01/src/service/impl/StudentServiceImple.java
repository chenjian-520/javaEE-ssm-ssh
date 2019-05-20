package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.studentMapper;
import pojo.Student;
import service.StudentService;
@Service("studentservice")
public class StudentServiceImple implements StudentService {

	@Autowired
	private studentMapper mapper;
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public Student findOne(int c) {
		// TODO Auto-generated method stub
		return mapper.findOne(c);
	}

	@Override
	public int update(Student c) {
		// TODO Auto-generated method stub
		return mapper.update(c);
	}

	@Override
	public int insert(Student c) {
		// TODO Auto-generated method stub
		return mapper.insert(c);
	}

	@Override
	public int delete(int c) {
		// TODO Auto-generated method stub
		return mapper.delete(c);
	}

	@Override
	public List<Student> class22() {
		// TODO Auto-generated method stub
		return mapper.class22();
	}

}
