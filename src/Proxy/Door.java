package Proxy;

import Domain.Valuable;
import Proxy.Treasury;
import Writer_Reader.AccessManager;

public class Door implements AccessManager
{
    private int readers;
    private int writers;
    private Treasury treasure;

    public Door(Treasury treasure) {
        readers = 0;
        writers = 0;
        this.treasure = treasure;
    }

    @Override
    public synchronized void releaseRead() {
        readers--;
        if (readers == 0) {
            notifyAll();
        }
    }

    @Override
    public synchronized Treasury requestWrite() throws InterruptedException {
        while (readers > 0 || writers > 0) {
            wait();
        }
        writers++;
        return treasure;
    }

    @Override
    public synchronized void releaseWrite() {
        writers--;
        if (writers == 0){
            notifyAll();
        }
    }

    @Override
    public synchronized Treasury requestRead() throws InterruptedException {
        while (writers > 0) {
            wait();
        }
        readers++;
        return treasure;
    }
}
