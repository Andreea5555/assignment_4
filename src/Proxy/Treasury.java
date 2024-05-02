package Proxy;

import Domain.Valuable;
import Producer_Consumer.Valuable_Transporter;
import Writer_Reader.Reader;
import Writer_Reader.Writer;

public interface Treasury
{
  void add(Valuable valuable, Writer writer);
  Valuable retrieve(int index, Reader reader);
  int look(Reader reader);
}
