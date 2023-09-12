package in.codegram.cm_api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import in.codegram.cm_api.domain.Project;

@Repository 
public interface ProjectRepository extends CrudRepository<Project, Long> {
	
   
    	Project findByProjectIdentifier(String projectId);
    
}
