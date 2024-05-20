package com.example.account.entities;

import com.example.account.enums.Role;
import com.example.department.entities.Department;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "ACCOUNT")
public class Account extends BaseTimeEntity {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    @Builder
    public Account(String name, String email, String picture, Role role, Department department) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
        this.department = department;
    }

    public Account update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public void addRole(Role role) {
        this.role = role;
    }

    public void addDepartment(Department department) {
        this.department = department;
    }
}
