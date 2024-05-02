package Proxy;

import Domain.Valuable;
import Producer_Consumer.Valuable_Transporter;
import Writer_Reader.Reader;
import Writer_Reader.Writer;
import main.Log;

import java.util.ArrayList;

public class TreasureRoomGuardsman implements Treasury
{

  private TreasureRoom treasureRoom;
  private Log logger;

  public TreasureRoomGuardsman(TreasureRoom treasureRoom) {
    logger=Log.getInstance();
    this.treasureRoom=treasureRoom;
  }

  @Override public void add(Valuable valuable,Object object)
  {
    if(object instanceof Writer)
      treasureRoom.add(valuable);
  }

  @Override public Valuable retrieve(int index, Object object)
  {
    if(object instanceof Reader){
      return treasureRoom.retrieve(index);
    }
    return null;
  }

  @Override public int look(Object object)
  {
    if(object instanceof Reader){
      return treasureRoom.look();
    }
    return 0;
  }
}
