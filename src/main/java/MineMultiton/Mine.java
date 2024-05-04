package MineMultiton;

import LoggerSingleton.Log;

public class Mine
{
  public Mine() {
    generateStone();
  }

  public void generateStone() {
    Log.getInstance().log("Generated stone: " +
        ValuableMultiton.getInstance("Stone" + (ValuableMultiton.getSize() + 1))
            .getName());
  }

  public String getAndRemoveStone(String name) {
    return ValuableMultiton.getInstance(name).getName();
  }
}
