package Proxy;

import Domain.Valuable;
import Producer_Consumer.Valuable_Transporter;
import Writer_Reader.Reader;
import Writer_Reader.Writer;

public interface Treasury
{
  void add(Valuable valuable,Object object);
  Valuable retrieve(int index, Object object);
  int look(Object object);
}
