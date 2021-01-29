package com.first.testgit.service.testmybatisplus.teststudent;

import com.first.testgit.entity.Student;
import com.first.testgit.mapper.StudentMapper;
import com.first.testgit.service.testmybatisplus.base.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author:jiaxingxu
 **/
@Service
public class StudentServiceImpl extends BaseServiceImpl<StudentMapper,Student> implements  StudentService {



}
