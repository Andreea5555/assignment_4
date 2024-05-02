import Producer_Consumer.Miner;
import Producer_Consumer.Valuable_Transporter;
import main.Deposit;

public class Start
{
  public static void main(String[] args)
  {
    Deposit deposit= Deposit.getInstance();
    Miner miner=new Miner();
    Valuable_Transporter transporter=new Valuable_Transporter();

    Thread thread1=new Thread(miner);
    Thread thread2=new Thread(transporter);
    thread1.start();
    thread2.start();
  }
}
