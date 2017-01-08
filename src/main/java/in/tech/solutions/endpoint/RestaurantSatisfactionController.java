package in.tech.solutions.endpoint;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import in.tech.solutions.model.BaseEntity;
import in.tech.solutions.model.Response;
import in.tech.solutions.service.SatisfactionService;
import in.tech.solutions.utils.HelperUtils;

/**
 * The Class RestaurantSatisfactionController.
 * 
 * @author hari kaja
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class RestaurantSatisfactionController {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RestaurantSatisfactionController.class);

	/** The satisfaction service. */
	@Autowired
	SatisfactionService satisfactionService;

	/**
	 * Find max satisfaction.
	 *
	 * @param feedData
	 *            the feed date
	 * @return the response entity
	 */
	@PostMapping(value = "/satisfaction", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Response<BaseEntity>> findMaxSatisfaction(@RequestPart("feedData") MultipartFile feedData) {
		LOGGER.info("findMaxSatisfaction:: Execcution Started");
		ResponseEntity<Response<BaseEntity>> response = null;
		try {
			if (feedData != null && feedData.getSize() > 0) {
				final File uploadedFile = HelperUtils.multipartToFile(feedData);
				BaseEntity baseEntity = HelperUtils.parseFile(uploadedFile);
				if (!baseEntity.isValidInput()) {
					response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				} else {
					satisfactionService.findMaxSatisfaction(baseEntity);
					response = ResponseEntity.ok(new Response<>(baseEntity));
				}
			} else {
				response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		LOGGER.info("findMaxSatisfaction:: Execution Ended");
		return response;

	}

}
