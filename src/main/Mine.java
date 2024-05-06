package main;

import Domain.*;
import java.util.ArrayList;
import java.util.Random;

public class Mine
{
  private static Mine instance;
  private ArrayList<Valuable> valuables;

  private Mine()
  {
    valuables = new ArrayList<>();
    createValuables();
  }

  public synchronized static Mine getInstance()
  {
    if (instance == null)
    {
      instance = new Mine();
    }
    return instance;
  }

  private void createValuables()
  {
    Random random = new Random();
    int count = random.nextInt(100);
    for (int i = 0; i < count; i++)
    {
      valuables.add(new Diamond());
    }
    for (int i = 0; i < count; i++)
    {
      valuables.add(new Emerald());
    }
    for (int i = 0; i < count; i++)
    {
      valuables.add(new Gold());
    }
    for (int i = 0; i < count; i++)
    {
      valuables.add(new Ruby());
    }
    for (int i = 0; i < count; i++)
    {
      valuables.add(new Lapis());
    }
  }

  public Valuable mine()
  {
    if(valuables.isEmpty()){
      System.out.println("MINE IS EMPTY");
      throw new RuntimeException("No more jewels");
    }
    Random random = new Random();
    int count = random.nextInt(valuables.size());
    return valuables.remove(count);
  }
  public boolean isEmpty(){
    return valuables.isEmpty();
  }
}
