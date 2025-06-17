class Logger{
    private static Logger instance;
    private Logger() {
        System.out.println("Logger instance created.");
    }
    public static Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance; 
    }
    public void log(String message){
        System.out.println("Log " + message);
    }
}
public class Main{
    public static void main(String[] args){
        Logger logger1 = Logger.getInstance();
        logger1.log("Initialization System...");
        
        Logger logger2 = Logger.getInstance();
        logger2.log("System running.");
        
        System.out.println("logger1 == logger2? " + (logger1 == logger2));
    }
}