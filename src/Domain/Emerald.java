package Domain;

public class Emerald extends Valuable
{
  @Override public String getValuableType()
  {
    return getClass().getName();
  }
}
