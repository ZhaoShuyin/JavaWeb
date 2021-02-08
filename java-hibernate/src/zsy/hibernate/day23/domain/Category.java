package zsy.hibernate.day23.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//自我一对多：商品分类
public class Category implements Serializable {

    private Integer id;
    private String name;

    private Category parentCategory;//父类型：多对一

    private Set<Category> childCategory = new HashSet<Category>(0);//关联的子类：一对多


    public Category() {
    }

    public Category(String name) {
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    public Set<Category> getChildCategory() {
        return childCategory;
    }

    public void setChildCategory(Set<Category> childCategory) {
        this.childCategory = childCategory;
    }


}
