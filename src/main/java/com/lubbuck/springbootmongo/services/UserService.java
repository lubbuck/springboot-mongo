package com.lubbuck.springbootmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lubbuck.springbootmongo.domain.User;
import com.lubbuck.springbootmongo.dto.UserDTO;
import com.lubbuck.springbootmongo.repositories.UserRepository;
import com.lubbuck.springbootmongo.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(String id) {
		Optional<User> obj = userRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não Encontrado. Id: " + id));
	}

	public User insert(User user) {
		return userRepository.insert(user);
	}

	public User update(User user) {
		User updatedUser = findById(user.getId());
		updateData(updatedUser, user);
		return userRepository.save(updatedUser);
	}

	public void delete(String id) {
		findById(id);
		userRepository.deleteById(id);
	}

	private void updateData(User updatedUser, User user) {
		updatedUser.setName(user.getName());
		updatedUser.setEmail(user.getEmail());
	}

	public User fromDTO(UserDTO userDTO) {
		return new User(userDTO.getId(), userDTO.getName(), userDTO.getEmail());
	}
}
