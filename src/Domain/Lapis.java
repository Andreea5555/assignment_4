package Domain;

public class Lapis extends Valuable
{
  @Override public String getValuableType()
  {
    return getClass().getName();
  }
}
