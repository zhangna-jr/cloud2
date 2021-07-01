package com.zn.springCloud.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.zn.springCloud.entities.SdkEntity.Student;
import com.zn.springCloud.entities.SdkEntity.User;
//import test.SignAddTest;

import java.util.ArrayList;
import java.util.List;

public class TestProject {
    public static void main(String[] args) {
        //SignAddTest.test();
        /*User user = new User();
        List<Student> students = new ArrayList<>();
        user.setName("一班");
        user.setAge(18);
        user.setSix("男女");
        Student studentOne = new Student();
        studentOne.setNameOne("张三");
        studentOne.setAgeOne(15);
        Student studentTwo = new Student();
        studentTwo.setNameOne("里斯");
        studentTwo.setAgeOne(17);
        students.add(studentOne);
        students.add(studentTwo);
        user.setList(students);
        String json = JSONArray.toJSON(user).toString();// 将bean转为json
        JSONObject jsonObject = JSONObject.parseObject(json);// 获取响应json对象
        List<Object> lists = (List<Object>)jsonObject.get("list");
        for (Object list:lists) {
            JSONObject jsonObjectResult = JSONObject.parseObject(list.toString());
            System.out.println(jsonObjectResult.get("nameOne").toString().trim());
            Integer one = (Integer) jsonObjectResult.get("ageOne");
            System.out.println(one);
        }*/
    }
}
