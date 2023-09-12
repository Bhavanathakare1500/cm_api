package in.codegram.cm_api.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codegram.cm_api.domain.Project;
import in.codegram.cm_api.exception.ProjectIdException;
import in.codegram.cm_api.repository.ProjectRepository;
import in.codegram.cm_api.service.ProjectService;

@Service
public class ProjectServiceImpl  implements ProjectService{
	
	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project saveOrUpdate(Project project) {
		try {
		return projectRepository.save(project);
	}catch(Exception ex) {
		throw new ProjectIdException("projectId:"+project.getProjectIdentifier()+"already exists");
	}
	}
	@Override
	public Iterable<Project> findAllProjects() {
		
		return projectRepository.findAll();
	}

	@Override
	public void delete(String projectId) {
	 Project project=projectRepository.findByProjectIdentifier(projectId);//FP01,FP02
	 projectRepository.delete(project);
	}

}
