package DepositAdapter;

import MineMultiton.ValuableStone;

public interface DepositInterface
{
  void addStonesToDeposit(String name);
  ValuableStone takeStone();
}
