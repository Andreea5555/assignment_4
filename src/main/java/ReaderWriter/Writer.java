package ReaderWriter;

import MineMultiton.ValuableStone;

public interface Writer extends Reader
{
  void add(ValuableStone stone);
  ValuableStone retrieve();
}
