package q4.no7;

public class WrongPasswordException extends Exception{
	public WrongPasswordException() {}
	public WrongPasswordException(String message) throws Exception {
		throw new Exception(message);
	}
}
