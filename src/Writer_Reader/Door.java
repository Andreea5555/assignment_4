package Writer_Reader;

import Producer_Consumer.Valuable_Transporter;

public interface Door
{ void releaseRead();

  void requestWrite() throws InterruptedException;
  void releaseWrite();


}
