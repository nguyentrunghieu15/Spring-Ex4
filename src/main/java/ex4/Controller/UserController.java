package ex4.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ex4.Model.User;
import ex4.Service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;

	@GetMapping("")
	public List<User> getAllUser() {
		return this.userService.getAllUser();
	}

}
