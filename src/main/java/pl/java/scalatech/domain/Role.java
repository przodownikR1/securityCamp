package pl.java.scalatech.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Role extends PKEntity<Long>{

    private static final long serialVersionUID = 3005822664276373056L;
    private String desc;
    private String name;




}