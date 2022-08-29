package q4.no7;

public class NotExistIDException extends Exception{
	public NotExistIDException() {}
	public NotExistIDException(String message) throws Exception {
		throw new Exception(message);
	}
}
