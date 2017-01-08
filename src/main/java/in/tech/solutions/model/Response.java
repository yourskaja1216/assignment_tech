package in.tech.solutions.model;

/**
 * The Class Response.
 * 
 * @author hari kaja
 *
 * @param <T>
 *            the generic type
 */
public class Response<T> {

	/**
	 * Instantiates a new response.
	 */
	public Response() {
		super();
	}

	/**
	 * Instantiates a new response.
	 *
	 * @param status
	 *            the status
	 */
	public Response(final int status) {
		super();
		this.status = status;
	}

	/**
	 * Instantiates a new response.
	 *
	 * @param result
	 *            the result
	 */
	public Response(final T result) {
		super();
		this.result = result;
	}

	/**
	 * Instantiates a new response.
	 *
	 * @param status
	 *            the status
	 * @param result
	 *            the result
	 */
	public Response(final int status, final T result) {
		super();
		this.status = status;
		this.result = result;
	}

	/**
	 * Instantiates a new response.
	 *
	 * @param status
	 *            the status
	 * @param errorMsg
	 *            the error msg
	 * @param rootCause
	 *            the root cause
	 */
	public Response(final int status, final String errorMsg, final String rootCause) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
		this.rootCause = rootCause;
		result = null;
	}

	/**
	 * Instantiates a new response.
	 *
	 * @param status
	 *            the status
	 * @param errorMsg
	 *            the error msg
	 */
	public Response(final int status, final String errorMsg) {
		super();
		this.status = status;
		this.errorMsg = errorMsg;
		rootCause = null;
		result = null;

	}

	/** The status. */
	private int status;

	/** The result. */
	private T result;

	/** The error msg. */
	private String errorMsg;

	/** The root cause. */
	private String rootCause;

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * Gets the result.
	 *
	 * @return the result
	 */
	public T getResult() {
		return result;
	}

	/**
	 * Gets the error msg.
	 *
	 * @return the error msg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * Gets the root cause.
	 *
	 * @return the root cause
	 */
	public String getRootCause() {
		return rootCause;
	}

	/**
	 * Sets the status.
	 *
	 * @param status
	 *            the new status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * Sets the result.
	 *
	 * @param result
	 *            the new result
	 */
	public void setResult(T result) {
		this.result = result;
	}

	/**
	 * Sets the error msg.
	 *
	 * @param errorMsg
	 *            the new error msg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * Sets the root cause.
	 *
	 * @param rootCause
	 *            the new root cause
	 */
	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

}
