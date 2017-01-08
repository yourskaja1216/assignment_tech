package in.tech.solutions.service;

import in.tech.solutions.model.BaseEntity;

/**
 * The Interface SatisfactionService.
 * 
 * @author hari kaja
 */
public interface SatisfactionService {

	/**
	 * Find max satisfaction.
	 *
	 * @param baseEntity
	 *            the base entity
	 */
	void findMaxSatisfaction(BaseEntity baseEntity);

}
