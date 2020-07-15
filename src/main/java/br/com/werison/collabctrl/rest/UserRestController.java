package br.com.werison.collabctrl.rest;

import java.util.Optional;

import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.werison.collabctrl.entities.User;
import br.com.werison.collabctrl.services.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	UserService service;

	/* GET */
	@ResponseBody
	@RequestMapping(method = { RequestMethod.GET }, name = "getUser", path = {}, produces = {
			MediaType.APPLICATION_JSON }, value = {})
	public Iterable<User> get() throws Exception {
		return service.findAll();
	}

	@ResponseBody
	@RequestMapping(method = { RequestMethod.GET }, name = "getUserById", path = { "/{id}" }, produces = {
			MediaType.APPLICATION_JSON }, value = { "/{id}" })
	public Optional<User> getById(@PathVariable("id") int id) throws Exception {
		return service.findById(id);
	}

	/* DELETE, PATCH, POST, PUT */
	@ResponseBody
	@RequestMapping(method = { RequestMethod.DELETE }, name = "deleteUser", path = { "/{id}" }, produces = {
			MediaType.APPLICATION_JSON }, value = { "/{id}" })
	public void delete(@PathVariable("id") int id) throws Exception {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.PATCH, consumes = {
			MediaType.APPLICATION_JSON }, name = "inactivateUser", headers = { "content-type=application/json",
					"content-type=text/html", "content-type=text/plain" }, path = {}, produces = {
							MediaType.APPLICATION_JSON, MediaType.TEXT_HTML }, value = {})
	public User inactivate(@RequestBody User item) throws Exception {
		return service.inactivate(item);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON }, name = "insertUser", headers = { "content-type=application/json",
					"content-type=text/html", "content-type=text/plain" }, path = {}, produces = {
							MediaType.APPLICATION_JSON, MediaType.TEXT_HTML }, value = {})
	public User insert(@RequestBody User item) throws Exception {
		return service.save(item);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON }, name = "updateUser", headers = { "content-type=application/json",
					"content-type=text/html", "content-type=text/plain" }, path = {}, produces = {
							MediaType.APPLICATION_JSON, MediaType.TEXT_HTML }, value = {})
	public User update(@RequestBody User item) throws Exception {
		return service.save(item);
	}
}
