package com.example.VirtualBookStore.Repository;

import com.example.VirtualBookStore.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
