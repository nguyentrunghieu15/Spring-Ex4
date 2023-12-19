package ex4.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ex4.Model.User;
import ex4.Repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;

	public List<User> getAllUser() {
		return this.userRepository.findAll();
	}
}
