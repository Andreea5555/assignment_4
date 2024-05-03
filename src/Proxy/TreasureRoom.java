package Proxy;

import Domain.Valuable;


import java.util.ArrayList;

public class TreasureRoom implements Treasury
{
  private ArrayList<Valuable> valuables;

  public TreasureRoom()
  {
    this.valuables = new ArrayList<>();
  }

  @Override public void add(Valuable valuable, Object object)
  {
    this.valuables.add(valuable);
  }

  @Override public Valuable retrieve(int index, Object object)
  {
    return valuables.remove(index);
  }

  @Override public int look(Object object)
  {
    return valuables.size();
  }
}