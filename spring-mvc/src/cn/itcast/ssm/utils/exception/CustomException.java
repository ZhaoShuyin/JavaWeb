package cn.itcast.ssm.utils.exception;

@SuppressWarnings("serial")
public class CustomException extends Exception{
	
	private String message;
	
	public CustomException(String message){
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
}
