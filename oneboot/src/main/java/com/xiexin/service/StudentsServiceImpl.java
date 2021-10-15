package com.xiexin.service;

import com.xiexin.bean.Students;
import com.xiexin.bean.StudentsDto;
import com.xiexin.bean.StudentsExample;
import com.xiexin.dao.StudentsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service("studentsService")
public class StudentsServiceImpl implements StudentsService{
	@Autowired(required = false)
	private StudentsDAO studentsDAO;
	public long countByExample(StudentsExample example){
    	return studentsDAO.countByExample(example);
    }

	public int deleteByExample(StudentsExample example){
    	return studentsDAO.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return studentsDAO.deleteByPrimaryKey(id);
    }

	public int insert(Students record){
    	return studentsDAO.insert(record);
    }

	public int insertSelective(Students record){
    	return studentsDAO.insertSelective(record);
    }

	public List<Students> selectByExample(StudentsExample example){
    	return studentsDAO.selectByExample(example);
    }

	public Students selectByPrimaryKey(Integer id){
    	return studentsDAO.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(Students record, StudentsExample example){
    	return studentsDAO.updateByExampleSelective(record, example);
    }

	public int updateByExample(Students record, StudentsExample example){
    	return studentsDAO.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(Students record){
    	return studentsDAO.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(Students record){
    	return studentsDAO.updateByPrimaryKey(record);
    }

	@Override
	public List<Map> selectMore1(Map map) {
		return studentsDAO.selectMore1(map);
	}

	@Override
	public int insertSelectiveDto(StudentsDto studentsDto) {
		return studentsDAO.insertSelectiveDto(studentsDto);
	}

	@Override
	public int updateSelectiveDto(StudentsDto studentsDto) {
		return studentsDAO.updateSelectiveDto(studentsDto);
	}


}
