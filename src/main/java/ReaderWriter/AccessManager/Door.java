package ReaderWriter.AccessManager;

import DepositAdapter.DepositAdapter;
import ProducerConsumer.ValuablesTransporter;
import Proxy.TreasureRoom;
import Proxy.TreasureRoomGuardsman;
import ReaderWriter.Accountant;
import ReaderWriter.King;
import ReaderWriter.Reader;
import ReaderWriter.Writer;

public class Door implements AccessManager
{
  private final DepositAdapter depositAdapter;
  private final TreasureRoomGuardsman guardsman;
  private int readers;
  private int writers;
  private int current;
  private int next;

  public Door(DepositAdapter depositAdapter, TreasureRoom treasureRoom) {
    this.depositAdapter = depositAdapter;
    this.guardsman = new TreasureRoomGuardsman(treasureRoom);
    this.readers = 0;
    this.writers = 0;
    this.current = 0;
    this.next = 0;
  }

  public TreasureRoomGuardsman getGuardsman()
  {
    return guardsman;
  }

  @Override public synchronized void releaseRead()
  {
    readers--;
    if (readers == 0) {
      notifyAll();
    }
  }

  @Override public synchronized void releaseWrite()
  {
    writers--;
    if (writers == 0) {
      notifyAll();
    }
  }

  @Override public synchronized Reader requestRead() throws InterruptedException
  {
    int myNumber = next;
    next++;
    while(myNumber != current) {
      wait();
    }
    while (writers > 0) {
      wait();
    }
    readers++;
    current++;
    notifyAll();
    return new Accountant(this);
  }

  @Override public synchronized Writer requestWrite(int who) throws InterruptedException
  {
    int myNumber = next;
    next++;
    while (myNumber != current) {
      wait();
    }
    while (writers > 0 || readers > 0) {
      wait();
    }
    writers++;
    current++;
    notifyAll();
    return who == 0 ? new ValuablesTransporter(this.depositAdapter, this) : new King(this);
  }
}
