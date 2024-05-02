public class Start
{
  public static void main(String[] args)
  {
    Miner miner=new Miner(15);
    Thread thread1=new Thread(miner);
    thread1.start();
  }
}
