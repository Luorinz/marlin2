package marlin;

import marlin.Reaction.Gesture;

import java.awt.*;

public interface I {
    public interface Show{
        public void show(Graphics g);
    }
    public interface Area{
        public boolean hit(int x,int y);
        public void dn(int x, int y);
        public void drag(int x, int y);
        public void up(int x, int y);

    }
    public interface Act{
        public void act(Gesture g);
    }
    public interface React extends Act{
        public int bid(Gesture g);
    }

}
