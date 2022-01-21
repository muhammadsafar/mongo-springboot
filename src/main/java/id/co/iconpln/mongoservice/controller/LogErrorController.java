package id.co.iconpln.mongoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import id.co.iconpln.mongoservice.entities.Employee;
import id.co.iconpln.mongoservice.entities.HeLogError;
import id.co.iconpln.mongoservice.repo.EmployeeRepo;
import id.co.iconpln.mongoservice.repo.HeLogErrorRepo;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "http://localhost:1477")
@RestController
@RequestMapping("/mongo/api")
@Slf4j
public class LogErrorController {

	@Autowired
	private HeLogErrorRepo logRepo;

	public LogErrorController(HeLogErrorRepo logRepo) {
		this.logRepo = logRepo;
	}

	@Autowired
	private EmployeeRepo empRepo;

	@GetMapping("/check")
	public String check() {
		return "hello";
	}

	@GetMapping("/logs")
	public ResponseEntity<List<HeLogError>> retrieveLogs() {
		try {

			log.info("Retrieving data logs at Controller");
			List<HeLogError> logs = logRepo.findAll();

			if (logs.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(logs, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> retrieveEmployees() {
		try {

			log.info("Retrieving data employees at Controller");
			List<Employee> emp = empRepo.findAll();

			if (emp.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> employeeByName(@RequestParam String name) {
		try {

			log.info("Retrieving data employees by name at Controller");
			List<Employee> emp = empRepo.findByName(name);

			if (emp.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/employee/like")
	public ResponseEntity<List<Employee>> employeeLikesName(@RequestParam String name) {
		try {

			log.info("Retrieving data employees by like name at Controller");
			List<Employee> emp = empRepo.findByLikesName(name);

			if (emp.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(emp, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/employee")
	public ResponseEntity<?> saveEmployee(@RequestBody Employee employee) {

		Employee save = empRepo.save(employee);
		return ResponseEntity.ok(save);
	}

}
