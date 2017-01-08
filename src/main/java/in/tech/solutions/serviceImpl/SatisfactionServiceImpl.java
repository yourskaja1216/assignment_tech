package in.tech.solutions.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import in.tech.solutions.model.BaseEntity;
import in.tech.solutions.service.SatisfactionService;
import in.tech.solutions.utils.HelperUtils;

/**
 * The Class SatisfactionServiceImpl.
 * 
 * @author hari kaja
 */
@Service("satisfactionService")
public class SatisfactionServiceImpl implements SatisfactionService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(SatisfactionServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * in.tech.solutions.service.SatisfactionService#findMaxSatisfaction(in.tech
	 * .solutions.model.BaseEntity)
	 */
	@Override
	public void findMaxSatisfaction(BaseEntity inputs) {
		LOGGER.info("Find the maximum Satisfaction score with the given time limit" + inputs.getGivenTime() + " over "
				+ inputs.getNumberOfItems() + " items(s)");
		int indexForItems, indexForSatisfaction;
		// Possible Max Satisfaction will be in S
		int[][] S = new int[inputs.getNumberOfItems() + 1][inputs.getGivenTime() + 1];

		for (indexForItems = 0; indexForItems <= inputs.getNumberOfItems(); indexForItems++) {
			for (indexForSatisfaction = 0; indexForSatisfaction <= inputs.getGivenTime(); indexForSatisfaction++) {
				if (indexForItems == 0 || indexForSatisfaction == 0)
					S[indexForItems][indexForSatisfaction] = 0;
				else if (inputs.getTimeTaken().get(indexForItems - 1) <= indexForSatisfaction)
					S[indexForItems][indexForSatisfaction] = HelperUtils.max(
							inputs.getAmountOfSatisfaction().get(indexForItems - 1)
									+ S[indexForItems - 1][indexForSatisfaction
											- inputs.getTimeTaken().get(indexForItems - 1)],
							S[indexForItems - 1][indexForSatisfaction]);
				else
					S[indexForItems][indexForSatisfaction] = S[indexForItems - 1][indexForSatisfaction];
			}
		}
		LOGGER.debug("Result is: " + S[inputs.getNumberOfItems()][inputs.getGivenTime()]);
		inputs.setResult(S[inputs.getNumberOfItems()][inputs.getGivenTime()]);
	}

}
