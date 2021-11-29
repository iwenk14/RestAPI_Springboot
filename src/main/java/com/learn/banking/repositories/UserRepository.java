package com.learn.banking.repositories;

import com.learn.banking.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByidBarang(String idBarang);

}
