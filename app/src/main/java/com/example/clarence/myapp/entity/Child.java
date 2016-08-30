
package com.example.clarence.myapp.entity;


import com.example.clarence.datastorelibrary.db.DbException;
import com.example.clarence.datastorelibrary.db.DbManager;
import com.example.clarence.datastorelibrary.db.annotation.Column;
import com.example.clarence.datastorelibrary.db.annotation.Table;

@Table(name = "child")
public class Child {

    @Column(name = "id", isId = true)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "parentId" /*, property = "UNIQUE"//如果是一对一加上唯一约束*/)
    private long parentId; // 外键表id

    // 这个属性被忽略，不存入数据库
    private String willIgnore;

    @Column(name = "text")
    private String text;

    public Parent getParent(DbManager db) throws DbException {
        return db.findById(Parent.class, parentId);
    }

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWillIgnore() {
        return willIgnore;
    }

    public void setWillIgnore(String willIgnore) {
        this.willIgnore = willIgnore;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", parentId=" + parentId +
                ", willIgnore='" + willIgnore + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
