package com.demo.ormjpa.repository;

import com.demo.ormjpa.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Paul
 * @version 1.0
 * @date 2020/4/22 16:22
 */
@Repository
public interface DepartmentDao extends JpaRepository<Department,Long> {

    /**
     * 根据层级查询部门
     * @param level {层级}
     * @return departmentList
     */
    List<Department> findDepartmentByLevels(Integer level);
}
