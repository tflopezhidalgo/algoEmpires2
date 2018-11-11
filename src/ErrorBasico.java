
public class ErrorBasico extends Exception{

	String message;
	public ErrorBasico() {
        super();
    }
    public ErrorBasico(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
