package homework20240506;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(){
        super();
    }
    public WrongPasswordException(String string){
        super(string);
    }
}
