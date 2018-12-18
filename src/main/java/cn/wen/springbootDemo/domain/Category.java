package cn.wen.springbootDemo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
/**
 * @Entity 注解表示这是个实体类
@Table(name = "category_") 表示这个类对应的表名是 category_ ，注意有下划线哦
@Id 表明主键
@GeneratedValue(strategy = GenerationType.IDENTITY) 表明自增长方式
@Column(name = "id") 表明对应的数据库字段名
 * @JsonIgnoreProperties是忽略Hibernate的延迟加载的一些属性"hibernateLazyInitializer", "handler", "fieldHandler"，
 * 这些属性在实体类里没有所以要忽略掉，否则json化时会报错
 *
 */
@Entity
@Table(name = "category_")
@JsonIgnoreProperties(ignoreUnknown = true, value = {"hibernateLazyInitializer", "handler", "fieldHandler"})
public class Category {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
     
    @Column(name = "name")
    private String name;
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
    public String toString() {
        return "Category [id=" + id + ", name=" + name + "]";
    }
}