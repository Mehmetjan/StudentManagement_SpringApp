package net.studentInfo.studentManagement.repository;

import net.studentInfo.studentManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
