package Domain;

public class Diamond extends Valuable
{
  @Override public String getValuableType()
  {
    return getClass().getName();
  }
}
