package in.ashokit.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.repository.SSNRepository;
import in.ashokit.service.SSNService;

@Service
public class SSNServiceImpl implements SSNService {

	@Autowired
	private SSNRepository ssnRepo;
	
	@Override
	public String getStateNameBySSN(String ssn) {
		if(isValidSSN(ssn)) {
			if(ssnRepo.findBySSN(ssn)!=null) {
				return ssnRepo.findBySSN(ssn).getStateName();
			}else {
				return "not-found";
			}
		}
		return "invalid-ssn";
	}

	private boolean isValidSSN(String ssn) {
		if(ssn!=null&&ssn.trim()!=""&&ssn.trim().length()==9) {
			return true;
		}
		return false;
	}
}
