package Proxy;

import Domain.Valuable;
import Producer_Consumer.Valuable_Transporter;
import Writer_Reader.Writer;
import main.Log;

import java.util.ArrayList;

public class TreasureRoom
{
  private Valuable_Transporter transporter;
  private ArrayList<Valuable> valuables;

  public TreasureRoom()
  {

    this.valuables = new ArrayList<>();
  }
  public void add(Valuable valuable){
    valuables.add(valuable);
  }
  public Valuable retrieve(int index){
     return valuables.get(index);
  }
  public int look(){
    return valuables.size();
  }
}
