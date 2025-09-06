package vn.iotstar.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cate_id", columnDefinition = "INT")
    private int cate_id;
    @Column(name = "cate_name", columnDefinition = "NVARCHAR(255)")
    private String cate_name;
    @Column(name = "icons", columnDefinition = "NVARCHAR(255)")
    private String icons;

    public Category(int cate_id, String cate_name, String icons) {
        this.cate_id = cate_id;
        this.cate_name = cate_name;
        this.icons = icons;
    }

    public Category() {
    }

    public int getCate_id() {
        return cate_id;
    }

    public void setCate_id(int cate_id) {
        this.cate_id = cate_id;
    }

    public String getCate_name() {
        return cate_name;
    }

    public void setCate_name(String cate_name) {
        this.cate_name = cate_name;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }
}
