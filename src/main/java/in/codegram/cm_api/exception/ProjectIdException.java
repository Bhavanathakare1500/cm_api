package in.codegram.cm_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {
	
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		/**
		 * this will create ProjectIDException object without error message 
		 */
		
		public ProjectIdException() {
			super();
		}
		/**
		 * 
		 *this will create ProjectIdException object with error message
		 */
		public ProjectIdException(String errMsg) {
			super(errMsg);
			
		}
	}

