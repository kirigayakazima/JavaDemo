package com.qym.dao;

import com.qym.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departmentDaoMap = null;

    static {
        departmentDaoMap=new HashMap<Integer, Department>();
        departmentDaoMap.put(101, new Department(101, "教育部"));
        departmentDaoMap.put(102, new Department(102, "研究部"));
        departmentDaoMap.put(103, new Department(103, "后勤部"));
        departmentDaoMap.put(104, new Department(104, "运营部"));
        departmentDaoMap.put(105, new Department(105, "开发部"));
    }

    //增删改查
//拿到所有部门信息
    public Collection<Department> getDepartments() {
        return departmentDaoMap.values();
    }

    //通过Id得到部门
    public Department getDepartmentById(Integer id) {
        return departmentDaoMap.get(id);
    }


}