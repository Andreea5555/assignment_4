package LoggerSingleton;

public class Log
{
  private static Log instance;

  private Log() {

  }

  public static synchronized Log getInstance() {
    if (instance == null) {
      instance = new Log();
    }

    return instance;
  }

  public synchronized void log(String message) {
    System.out.println(message);
  }
}
