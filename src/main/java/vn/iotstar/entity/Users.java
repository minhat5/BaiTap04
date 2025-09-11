package vn.iotstar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private int id;
    @Column(name = "email", columnDefinition = "NVARCHAR(100)")
    private String email;
    @Column(name = "username", columnDefinition = "NVARCHAR(50)")
    private String username;
    @Column(name = "fullname", columnDefinition = "NVARCHAR(100)")
    private String fullname;
    @Column(name = "password", columnDefinition = "NVARCHAR(255)")
    private String password;
    @Column(name = "avatar", columnDefinition = "NVARCHAR(255)")
    private String avatar;
    @Column(name = "roleid", columnDefinition = "INT")
    private int roleid;
    @Column(name = "phone", columnDefinition = "NVARCHAR(20)")
    private String phone;
    @Column(name = "createDate", columnDefinition = "DATETIME")
    private Date createDate;

    public Users(String email, String username, String fullname, String password, String avatar, int i, String phone, java.sql.Date date) {
        this.email = email;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.avatar = avatar;
        this.roleid = i;
        this.phone = phone;
        this.createDate = date;
    }
}
