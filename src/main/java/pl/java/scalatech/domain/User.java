package pl.java.scalatech.domain;

import static com.google.common.collect.Lists.newArrayList;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.Valid;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="users")
public class User  extends PKEntity<Long>{

    private static final long serialVersionUID = -2985714900688722768L;
    private String login;
    private String password;
    private String email;
    private BigDecimal salary;
    private String firstName;
    private String lastName;

    @ManyToMany(fetch = LAZY, cascade = { PERSIST, MERGE })
    @JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "userId") }, inverseJoinColumns = { @JoinColumn(name = "roleId") })
    @Valid
    private List<Role> roles = newArrayList();

}
