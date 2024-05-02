package Domain;

public class Ruby extends Valuable
{
  @Override public String getValuableType()
  {
    return getClass().getName();
  }
}
