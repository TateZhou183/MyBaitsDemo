package com.zy.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author gacl
 * users表所对应的实体类
 */
public class User  implements Serializable{

    //实体类的属性和表的字段名称一一对应
    private int id;
    private String name;
    private int age;
    private List<Role> role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    
    public List<Role> getRole() {
		return role;
	}

	public void setRole(List<Role> role) {
		this.role = role;
	}

	@Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }
}
