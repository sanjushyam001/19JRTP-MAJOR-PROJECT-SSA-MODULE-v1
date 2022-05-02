package in.ashokit.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.SSNService;

@RestController
@RequestMapping("ssa")
public class SSNRestController {

	@Autowired
	private SSNService ssnService;

	@GetMapping("/ssn/{ssn}")
	public ResponseEntity<?> getState(@PathVariable String ssn){
	
		ResponseEntity<?> resp=null;
		String state = ssnService.getStateNameBySSN(ssn);
		if(state!=""&&state!=null)
			resp=new ResponseEntity<String>(state, HttpStatus.NOT_FOUND);
		else 
			resp=new ResponseEntity<String>("not-found", HttpStatus.OK);
		return resp;
	}
}
