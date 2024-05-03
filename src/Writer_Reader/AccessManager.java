package Writer_Reader;

import Domain.Valuable;
import Proxy.Treasury;

public interface AccessManager
{
//  void releaseRead();
//  Treasury requestWrite() throws InterruptedException;
//  void releaseWrite();
//  Treasury requestRead() throws InterruptedException;
  void releaseRead();
  Reader requestRead() throws InterruptedException;
  void releaseWrite();
  Writer requestWrite() throws InterruptedException;
}
