package com.example.department.entities;

import com.example.account.entities.Account;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "DEPARTMENT")
public class Department {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();

    @Builder
    public Department(String name) {
        this.name = name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.addDepartment(this);
    }

    public void removeAccount(Account account) {
        accounts.remove(account);
        account.addDepartment(null);
    }
}

