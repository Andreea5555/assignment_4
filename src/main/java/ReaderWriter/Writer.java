package ReaderWriter;

import MineMultiton.ValuableStone;

public interface Writer
{
  void add(ValuableStone stone);
  ValuableStone retrieve();
}
