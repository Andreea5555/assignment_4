package Writer_Reader;

public interface AccessManager
{
  void releaseRead();
  void requestWrite() throws InterruptedException;
  void releaseWrite();
}
