package Proxy;

import Domain.Valuable;
import Writer_Reader.Reader;
import Writer_Reader.Writer;

public class TreasureRoomGuardsman implements Treasury
{

  @Override public void add(Valuable valuable, Writer writer)
  {

  }

  @Override public Valuable retrieve(int index, Reader reader)
  {
    return null;
  }

  @Override public int look(Reader reader)
  {
    return 0;
  }
}
