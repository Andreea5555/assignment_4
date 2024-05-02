package Proxy;

import Domain.Valuable;

import java.util.ArrayList;

public class TreasureRoom implements Treasury
{
  private ArrayList<Valuable> valuables;

  public TreasureRoom() {
    this.valuables = new ArrayList<>();
  }

  @Override public void add(Valuable valuable)
  {
    this.valuables.add(valuable);
  }

  @Override public Valuable retrieve(int index)
  {
    return this.valuables.get(index);
  }

  @Override public void look()
  {

  }
}
