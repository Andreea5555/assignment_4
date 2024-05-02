public class Log
{
  private static Log instance;

  private Log()
  {
  }

  public static Log getInstance()
  {
    if (instance == null)
    {
      instance = new Log();
      System.out.println("BLAH");
    }
    return instance;
  }
  public void print(String message){
    System.out.println(message);
  }

}
