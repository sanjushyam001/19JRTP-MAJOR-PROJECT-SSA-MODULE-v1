package in.ashokit.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import in.ashokit.entity.SSNEntity;

public interface SSNRepository extends JpaRepository<SSNEntity, Serializable> {

	@Query("SELECT s FROM SSNEntity s WHERE s.ssn = ?1")
	public SSNEntity findBySSN(String ssn);
}
