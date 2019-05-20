package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mapper.courseMapper;
import pojo.Course;
import service.CourseService;


@Service("courseservice")
public class CourseServiceImple implements CourseService {

	@Autowired
	private courseMapper mapper;
	@Override
	public List<Course> findAll() {
		// TODO Auto-generated method stub
		return mapper.findAll();
	}

	@Override
	public Course findOne(int cid) {
		// TODO Auto-generated method stub
		return mapper.findOne(cid);
	}

	@Override
	public int update(Course c) {
		// TODO Auto-generated method stub
		return mapper.update(c);
	}

	@Override
	public int insert(Course c) {
		// TODO Auto-generated method stub
		return mapper.insert(c);
	}

	@Override
	public int delete(int c) {
		// TODO Auto-generated method stub
		return mapper.delete(c);
	}

}
