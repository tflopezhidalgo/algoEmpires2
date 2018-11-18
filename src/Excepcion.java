public class Excepcion extends Exception{

	String message;

	public Excepcion() {

        super();
    }

    public Excepcion(String message) {
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
