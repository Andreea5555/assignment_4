package Writer_Reader;

import Domain.Valuable;

public interface Reader
{
  Valuable retrieve(int index, Object object);
  int look(Object object);
}
