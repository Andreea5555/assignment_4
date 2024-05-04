package MineMultiton;

import java.util.HashMap;
import java.util.Map;

public class ValuableMultiton
{
  private static final Map<String, ValuableStone> instances = new HashMap<>();

  private ValuableMultiton() {}

  public static synchronized ValuableStone getInstance(String name) {
    if (!instances.containsKey(name)) {
      instances.put(name, new ValuableStone(name));
    }
    return instances.remove(name);
  }

  public static synchronized int getSize() {
    if (!instances.isEmpty()) {
      return instances.size();
    }
    return 0;
  }
}
