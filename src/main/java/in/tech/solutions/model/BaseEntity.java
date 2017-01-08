package in.tech.solutions.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class BaseEntity.
 * 
 * @author hari kaja
 */
public class BaseEntity {

	/** The result. */
	private Integer result;

	/** The time allowed. */
	private Integer givenTime;

	/** The number of items. */
	private Integer numberOfItems;

	/** The amount of satisfaction. */
	private List<Integer> amountOfSatisfaction;

	/** The time taken. */
	private List<Integer> timeTaken;

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public Integer getResult() {
		return result;
	}

	/**
	 * Gets the given time.
	 *
	 * @return the given time
	 */
	public Integer getGivenTime() {
		return givenTime;
	}

	/**
	 * Gets the number of items.
	 *
	 * @return the number of items
	 */
	public Integer getNumberOfItems() {
		return numberOfItems;
	}

	/**
	 * Gets the amount of satisfaction.
	 *
	 * @return the amount of satisfaction
	 */
	public List<Integer> getAmountOfSatisfaction() {
		if (null == amountOfSatisfaction) {
			amountOfSatisfaction = new ArrayList<>();
		}
		return amountOfSatisfaction;
	}

	/**
	 * Gets the time taken.
	 *
	 * @return the time taken
	 */
	public List<Integer> getTimeTaken() {
		if (null == timeTaken) {
			timeTaken = new ArrayList<>();
		}
		return timeTaken;
	}

	/**
	 * Sets the result.
	 *
	 * @param result
	 *            the new result
	 */
	public void setResult(Integer result) {
		this.result = result;
	}

	/**
	 * Sets the given time.
	 *
	 * @param givenTime
	 *            the new given time
	 */
	public void setGivenTime(Integer givenTime) {
		this.givenTime = givenTime;
	}

	/**
	 * Sets the number of items.
	 *
	 * @param numberOfItems
	 *            the new number of items
	 */
	public void setNumberOfItems(Integer numberOfItems) {
		this.numberOfItems = numberOfItems;
	}

	/**
	 * Sets the amount of satisfaction.
	 *
	 * @param amountOfSatisfaction
	 *            the new amount of satisfaction
	 */
	public void setAmountOfSatisfaction(List<Integer> amountOfSatisfaction) {
		this.amountOfSatisfaction = amountOfSatisfaction;
	}

	/**
	 * Sets the time taken.
	 *
	 * @param timeTaken
	 *            the new time taken
	 */
	public void setTimeTaken(List<Integer> timeTaken) {
		this.timeTaken = timeTaken;
	}

	/**
	 * Checks if is valid input.
	 *
	 * @return true, if is valid input
	 */
	public boolean isValidInput() {
		return this.givenTime != null && this.numberOfItems != null && null != this.amountOfSatisfaction
				&& this.amountOfSatisfaction.size() > 0 && null != this.timeTaken && this.timeTaken.size() > 0;
	}

	/**
	 * Validate.
	 *
	 * @return the string
	 */
	public String validate() {
		if (this.givenTime == null) {
			return "Max Time allowed is not provided.";
		}

		if (this.numberOfItems == null) {
			return "Number of items are provided.";
		}

		if (this.amountOfSatisfaction == null) {
			return "Amount of Satisfaction data is not provided.";
		}

		if (this.timeTaken == null) {
			return "Time spent of eating the a item is not provided.";
		}
		return "success";
	}

}