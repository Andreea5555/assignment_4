package ReaderWriter.AccessManager;

import ReaderWriter.Reader;
import ReaderWriter.Writer;

public interface AccessManager
{
  void releaseRead();
  void releaseWrite();
  Reader requestRead() throws InterruptedException;
  Writer requestWrite(int who) throws InterruptedException;
}
