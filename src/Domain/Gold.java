package Domain;

public class Gold extends Valuable
{
  @Override public String getValuableType()
  {
    return getClass().getName();
  }
}
