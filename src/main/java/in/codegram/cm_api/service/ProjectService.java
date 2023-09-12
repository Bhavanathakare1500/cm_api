package in.codegram.cm_api.service;

import java.util.List;

import in.codegram.cm_api.domain.Project;

public interface ProjectService {
	public Project saveOrUpdate(Project project);
	Iterable<Project> findAllProjects();
   void delete(String projectId);
}
