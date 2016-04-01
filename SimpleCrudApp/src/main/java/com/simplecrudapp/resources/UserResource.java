package com.simplecrudapp.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplecrudapp.domain.User;
import com.simplecrudapp.service.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		Integer userId = userService.save(user);
		if(userId != null){
			return new ResponseEntity<User>(user, HttpStatus.CREATED);
		}
		return new ResponseEntity<User>(HttpStatus.CONFLICT);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> list() {
		List<User> users = userService.listUsers();
		if (users != null && users.size() > 0){
			return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		}else{
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> findById(@PathVariable("id") Integer id) {
		User user = userService.getById(id);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
	}
	
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable("id") Integer id, @RequestBody User user) {
        User currentUser = userService.getById(id);
         
        if (currentUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        currentUser.setName(user.getName());
        currentUser.setAddress(user.getAddress());
        currentUser.setBirth(user.getBirth());
        userService.update(currentUser);
        
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
 	
    
   @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
   public ResponseEntity<User> deleteUser(@PathVariable("id") Integer id) {
       User currentUser = userService.getById(id);
       
       if (currentUser == null) {
           return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
       }
       userService.delete(currentUser);
       return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
   }    
}
