package net.studentInfo.studentManagement.service;

import lombok.AllArgsConstructor;
import net.studentInfo.studentManagement.entity.User;
import net.studentInfo.studentManagement.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(int userId) {
        Optional<User> optionalUser= userRepository.findById(userId);
        return optionalUser.get();
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(User user) {
        User existingUser= userRepository.findById(user.getId()).get();
        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastName(user.getLastName());
        existingUser.setEmail(user.getEmail());
        User updateduser=  userRepository.save(existingUser);
          return updateduser;
    }

    @Override
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }
}
