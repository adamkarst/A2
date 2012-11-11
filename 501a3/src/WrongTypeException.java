
public class WrongTypeException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String errorNo;
	
	public WrongTypeException() {
		super();
		errorNo = "-1";
	}
	
	public WrongTypeException(String num) {
		super(num);
		errorNo = num;
	}
	
	public String getError() {
		return errorNo;
	}
}
