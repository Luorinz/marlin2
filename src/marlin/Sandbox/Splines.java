package marlin.Sandbox;

import marlin.UC;
import marlin.graphicsLib.G;
import marlin.graphicsLib.Window;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Splines extends Window {
    public Splines() {
        super("splines", UC.screenWidth, UC.screenHeight);
    }
    public static Point[] points = {new Point(100, 100), new Point(100, 200), new Point(300, 300)};
    public static int cPoint = 0;

    public void paintComponent(Graphics g){
        G.fillBackground(g, Color.white);
        g.setColor(Color.red);
        G.poly.reset();
        G.pSpline(points[0].x, points[0].y, points[1].x, points[1].y, points[2].x, points[2].y, 6);
        g.fillPolygon(G.poly);
    }

    // mouse event
    public void mousePressed(MouseEvent me) {
        cPoint = closestPoint(me.getX(), me.getY());
        repaint();
    }
    public void mouseDragged(MouseEvent me) {
        points[cPoint].x = me.getX();
        points[cPoint].y = me.getY();
        repaint();
    }
    public void mouseReleased(MouseEvent me) {
        repaint();
    }

    //helper
    public int closestPoint(int x, int y){ // find the closest point
        int result = 0;
        int closestDistance = 10000001;
        for (int i = 0; i < points.length; i++){
            Point p = points[i];
            int d = (p.x - x) * (p.x - x) + (p.y - y) * (p.y - y);
            if  (d < closestDistance) {
                closestDistance = d;
                result = i;
            }
        }
        return result;
    }
}
