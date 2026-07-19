package roro.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import roro.app.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    
}
