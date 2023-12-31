package in.codegram.cm_api.web;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.codegram.cm_api.domain.Project;
import in.codegram.cm_api.service.MapValidationErrorService;
import in.codegram.cm_api.service.ProjectService;


@RestController
@RequestMapping("/api/projects")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private MapValidationErrorService mapValidationErrorService;
	@PostMapping("")
	public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project,BindingResult result)
	{
	    ResponseEntity<?> errorMap=mapValidationErrorService.mapValidationError(result);
	    if(errorMap!=null) {
	    	return errorMap;
	    }
		Project proj=projectService.saveOrUpdate(project);
		return new ResponseEntity<Project>(proj,HttpStatus.CREATED);
	}
	@GetMapping("/all")
    public Iterable<Project>getAllProjects(){
    	return projectService.findAllProjects();
    }
	@DeleteMapping("/{projectId}")
	    public ResponseEntity<?>removeProject(@PathVariable String projectId) {
		projectService.delete(projectId);
		return new ResponseEntity<String>("Project Deleted Successfully",HttpStatus.OK);
	}
}

