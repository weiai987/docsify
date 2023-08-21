package com.blb.mvc.converter;

import com.blb.mvc.entity.Student;
import org.springframework.core.convert.converter.Converter;

/**
 * 学生类型转换，将id-name-age-subject格式字符串转换为Student对象
 */
public class StudentConverter implements Converter<String, Student> {

    @Override
    public Student convert(String s) {
        //按-分割字符串
        String[] strings = s.split("\\-");
        if(strings.length != 4){
            throw new IllegalArgumentException("字符串不符合学生信息格式要求");
        }
        //返回Student对象
        Student student = new Student();
        student.setId(Long.valueOf(strings[0]));
        student.setName(strings[1]);
        student.setAge(Integer.valueOf(strings[2]));
        student.setSubject(strings[3]);
        return student;
    }
}
