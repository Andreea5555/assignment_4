package Writer_Reader;

import Domain.Valuable;

public interface Writer extends Reader
{
  void add(Valuable valuable,Object object);
}
