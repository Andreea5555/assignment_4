package main;

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
    }
    return instance;
  }
  public void print(String message){
    System.out.println(message);
  }

}
