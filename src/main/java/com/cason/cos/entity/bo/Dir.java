package com.cason.cos.entity.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Cason mo
 * Date: 2021/6/19
 * Time: 16:52
 */
@Entity
@Table(name = "dir")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Dir {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",length = 11)
    private Integer id;
    @Column(name = "name",length = 50)
    private String name;
    @Column(name = "p_id",length = 11)
    private Integer pid;
    @Column(name="current_flag")
    private Boolean currentFlag;

    public Dir(int id, String name, int pid) {
        this.setId(id);
        this.setName(name);
        this.setPid(pid);
    }
}
