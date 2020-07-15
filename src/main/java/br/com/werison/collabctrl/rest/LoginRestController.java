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

import br.com.werison.collabctrl.entities.Login;
import br.com.werison.collabctrl.services.LoginService;

@RestController
@RequestMapping("/login")
public class LoginRestController {

	@Autowired
	LoginService service;

	/* GET */
	@ResponseBody
	@RequestMapping(method = { RequestMethod.GET }, name = "getLogin", path = {}, produces = {
			MediaType.APPLICATION_JSON }, value = {})
	public Iterable<Login> get() throws Exception {
		return service.findAll();
	}

	@ResponseBody
	@RequestMapping(method = { RequestMethod.GET }, name = "getLoginById", path = { "/{id}" }, produces = {
			MediaType.APPLICATION_JSON }, value = { "/{id}" })
	public Optional<Login> getById(@PathVariable("id") int id) throws Exception {
		return service.findById(id);
	}

	/* DELETE, PATCH, POST, PUT */
	@ResponseBody
	@RequestMapping(method = { RequestMethod.DELETE }, name = "deleteLogin", path = { "/{id}" }, produces = {
			MediaType.APPLICATION_JSON }, value = { "/{id}" })
	public void delete(@PathVariable("id") int id) throws Exception {
		service.delete(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = {
			MediaType.APPLICATION_JSON }, name = "insertLogin", headers = { "content-type=application/json",
					"content-type=text/html", "content-type=text/plain" }, path = {}, produces = {
							MediaType.APPLICATION_JSON, MediaType.TEXT_HTML }, value = {})
	public Login insert(@RequestBody Login item) throws Exception {
		return service.save(item);
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = {
			MediaType.APPLICATION_JSON }, name = "updateLogin", headers = { "content-type=application/json",
					"content-type=text/html", "content-type=text/plain" }, path = {}, produces = {
							MediaType.APPLICATION_JSON, MediaType.TEXT_HTML }, value = {})
	public Login update(@RequestBody Login item) throws Exception {
		return service.save(item);
	}
}
