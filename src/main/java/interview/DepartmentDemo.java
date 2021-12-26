package interview;

import cn.hutool.core.collection.CollectionUtil;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

@Data
public class DepartmentDemo {

    public static void main(String[] args) {
        List<Department> allDepartment = new ArrayList<>();
        Department dep1 = new Department(1, 0, "北京总部");
        Department dep3 = new Department(3, 1, "研发中心");
        Department dep4 = new Department(4, 3, "后端研发组");
        Department dep6 = new Department(6, 4, "后端实习生组");
        Department dep7 = new Department(7, 3, "前端研发组");
        Department dep8 = new Department(8, 1, "产品部");

        allDepartment.add(dep6);
        allDepartment.add(dep7);
        allDepartment.add(dep8);
        allDepartment.add(dep1);
        allDepartment.add(dep3);
        allDepartment.add(dep4);

        List<Department> subDepartments = DepartmentDemo.getSub1(1, allDepartment);
        for (Department subDepartment : subDepartments) {
            System.out.println(subDepartment);
        }
    }

    /**
     * 根据id，获取所有子部门列表(包括隔代子部门，一直到叶子节点)
     * 要求：不能新增参数，不能增加static变量
     */
    public static List<Department> getSub(int id, List<Department> allDepartment) {

        List<Department> result = new ArrayList<>(allDepartment.size());
        Map<Integer, List<Department>> pidMap = allDepartment.stream().collect(Collectors.groupingBy(Department::getPid));

        Queue<Department> q = new LinkedList<>(pidMap.get(id));
        while (CollectionUtil.isNotEmpty(q)) {
            Department first = q.poll();
            result.add(first);
            q.addAll(new LinkedList<>(pidMap.getOrDefault(first.getId(), Collections.emptyList())));
        }
        return result;
    }

    public static List<Department> getSub1(int id, List<Department> allDepartment) {
        List<Department> result = new ArrayList<>(allDepartment.size());
        Map<Integer, List<Department>> pidMap = allDepartment.stream().collect(Collectors.groupingBy(Department::getPid));
        get(id, result, pidMap);
        return result;
    }

    private static void get(Integer id, List<Department> result, Map<Integer, List<Department>> pidMap) {
        List<Department> children = pidMap.getOrDefault(id, Collections.emptyList());
        result.addAll(children);
        for (Department child : children) {
            get(child.getId(), result, pidMap);
        }
    }
}

@Data
@AllArgsConstructor
class Department {

    /**
     * id
     */
    private int id;
    /**
     * parent id
     */
    private int pid;
    /**
     * 名称
     */
    private String name;

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }
}
