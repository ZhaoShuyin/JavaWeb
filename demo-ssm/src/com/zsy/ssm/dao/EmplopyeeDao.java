package com.zsy.ssm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zsy.ssm.entity.Employee;

public interface EmplopyeeDao extends BaseMapper<Employee> {

    int updateAllColumnById(Employee employee);
}