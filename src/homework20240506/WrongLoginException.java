package homework20240506;

public class WrongLoginException extends Exception{
    public WrongLoginException(){
        super();

    }
    public WrongLoginException(String string){
        super(string);
    }
}
