package Proxy;

import Domain.Valuable;

public interface Treasury
{ void add(Valuable valuable,);
  Valuable retrieve();
  void look(Valuable valuable);
}
