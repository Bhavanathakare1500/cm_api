package in.codegram.cm_api.serviceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import in.codegram.cm_api.service.MapValidationErrorService;

@Service
public class MapValidationErrorServiceImpl implements MapValidationErrorService {

	@Override
	public ResponseEntity<?> mapValidationError(BindingResult result) {
		// TODO Auto-generated method stub
		return null;
	}

}
