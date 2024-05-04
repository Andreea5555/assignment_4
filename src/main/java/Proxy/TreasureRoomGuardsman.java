package Proxy;

import MineMultiton.ValuableStone;
import ProducerConsumer.ValuablesTransporter;
import ReaderWriter.Accountant;
import ReaderWriter.King;

public class TreasureRoomGuardsman implements Treasury
{
  private final TreasureRoom treasureRoom;

  public TreasureRoomGuardsman(TreasureRoom treasureRoom)
  {
    this.treasureRoom = treasureRoom;
  }

  @Override public void add(ValuableStone stone, Object actor)
  {
    if (actor instanceof ValuablesTransporter || actor instanceof King) {
      treasureRoom.add(stone, actor);
    }
  }

  @Override public int look(Object actor)
  {
    if (actor instanceof Accountant || actor instanceof King) {
      return treasureRoom.look(actor);
    }

    return -1;
  }

  @Override public ValuableStone retrieve(Object actor)
  {
    if (actor instanceof King) {
      return treasureRoom.retrieve(actor);
    }

    return null;
  }
}
