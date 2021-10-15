package com.xiexin.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xiexin.bean.Students;
import com.xiexin.bean.StudentsDto;
import com.xiexin.bean.StudentsExample;
import com.xiexin.respcode.Result;
import com.xiexin.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsService studentsService;

    // 全查  注意 不用map， 公司中 都用  一个 类， 好几类组成的类， 叫做
    // 统一响应类， 每个公司都不一样。
    @RequestMapping("/selectAll") // /student/selectAll
    public Result selectAll(){
        List<Students> students = studentsService.selectByExample(null);// select * from students
        Result  result =new Result(students);
        return result;
    }

   /* //  （带参数的）分页查询
    @RequestMapping("/selectPageAll") // /student/selectPageAll
    public Result selectPageAll(Student student,@RequestParam(value = "page",defaultValue = "1",required = true) Integer page,
                                @RequestParam(value = "limit",defaultValue = "10",required = true)Integer pageSize){
        System.out.println("student = " + student);
        StudentExample example=new StudentExample();
        StudentExample.Criteria criteria=example.createCriteria();
     //使用的是 pagehelper 分页
        PageHelper.startPage(page,pageSize);
        if(null !=student.getStudentSex()&&!"".equals(student.getStudentSex())){
            criteria.andStudentSexEqualTo(student.getStudentSex());
        }
        List<Student> students = studentService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(students);
        Result result = new Result(pageInfo);
        return result;
    }
*/
    //  （带参数的）分页查询
    @RequestMapping("/selectPageAll") // /student/selectPageAll
    public Result selectPageAll(Students students,@RequestParam(value = "page",defaultValue = "1",required = true) Integer page,
                                @RequestParam(value = "limit",defaultValue = "10",required = true)Integer pageSize){
        System.out.println("students= " + students);
        StudentsExample example=new StudentsExample();
        StudentsExample.Criteria criteria=example.createCriteria();
        //使用的是 pagehelper 分页
        PageHelper.startPage(page,pageSize);
        if(null !=students.getStudentName()&&!"".equals(students.getStudentName())){
            criteria.andStudentNameEqualTo(students.getStudentName());
        }

        if(null !=students.getStudentSex()&&!"".equals(students.getStudentSex())){
            criteria.andStudentSexEqualTo(students.getStudentSex());
        }
        List<Students> studentds = studentsService.selectByExample(example);
        PageInfo pageInfo = new PageInfo(studentds);
        Result result = new Result(pageInfo);
        return result;
    }

//修改
    @RequestMapping("/updateOne")
    public  Result updateOne(@RequestBody StudentsDto studentsDto){

        int i = studentsService.updateSelectiveDto(studentsDto);
        if(i==1){
            return new Result();
        }else{
            return new Result(40001,"修改失败");
        }
    }

//添加
@RequestMapping("/addOne")
public  Result addOne(@RequestBody StudentsDto studentsDto) {
    int i = studentsService.insertSelectiveDto(studentsDto);
    if (i == 1) {
        return new Result();
    } else {
        return new Result(40002, "添加失败");
    }
 }

 //删除
 @RequestMapping("/deleteOne")
 public  Result deleteOne(@RequestParam(value = "studentId",required = false) Integer studentId) {
     int i = studentsService.deleteByPrimaryKey(studentId);
     if (i == 1) {
         return new Result();
     } else {
         return new Result(40002, "删除失败");
     }
 }
}
