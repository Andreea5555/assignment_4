package Proxy;

import MineMultiton.ValuableStone;

public interface Treasury
{
  void add(ValuableStone stone, Object actor);
  int look(Object actor);
  ValuableStone retrieve(Object actor);
}

