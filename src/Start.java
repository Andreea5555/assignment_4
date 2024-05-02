import Producer_Consumer.Miner;
import Producer_Consumer.Valuable_Transporter;

public class Start
{
  public static void main(String[] args)
  {
     int capacity=40;
    Miner miner=new Miner(capacity);
    Valuable_Transporter transporter=new Valuable_Transporter(capacity);

    Thread thread1=new Thread(miner);
    Thread thread2=new Thread(transporter);
    thread1.start();
    thread2.start();
  }
}
