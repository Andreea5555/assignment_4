package Proxy;

import Domain.Valuable;

public interface Treasury
{
  void add(Valuable valuable);
  Valuable retrieve(int index);
  void look();
}
