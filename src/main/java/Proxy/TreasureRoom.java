package Proxy;

import MineMultiton.ValuableStone;

import java.util.ArrayList;

public class TreasureRoom implements Treasury
{
  private final ArrayList<ValuableStone> stones;

  public TreasureRoom()
  {
    this.stones = new ArrayList<>();
  }

  @Override public void add(ValuableStone stone, Object actor)
  {
    this.stones.add(stone);
  }

  @Override public int look(Object actor)
  {
    return this.stones.size();
  }

  @Override public ValuableStone retrieve(Object actor)
  {
    return this.stones.remove(0);
  }
}
