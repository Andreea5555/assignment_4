package Proxy;

import Domain.Valuable;
import Producer_Consumer.Valuable_Transporter;
import Writer_Reader.Writer;
import main.Log;

import java.util.ArrayList;

public class TreasureRoom implements Treasury
{
  private ArrayList<Valuable> valuables;
  private Valuable_Transporter valuableTransporter;
  private Log logger;

  public TreasureRoom() {
    logger=Log.getInstance();
    this.valuables = new ArrayList<>();
    this.valuableTransporter=new Valuable_Transporter();
  }

  @Override public void add(Valuable valuable,Writer writer)
  {
    this.valuables.add(valuable);
  }

  @Override public Valuable retrieve(int index)
  {
    return this.valuables.get(index);
  }

  @Override public int look()
  {
 return valuables.size();
  }
}
