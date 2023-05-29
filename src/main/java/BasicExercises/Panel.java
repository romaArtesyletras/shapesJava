package BasicExercises;

import javax.print.attribute.standard.Sides;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

/**
 *
 * @author PC1-17
 */
public class Panel extends JPanel {

    private static final long serialVersionUID = 1L;

    private double x1 = 0;
    private double x2 = 0;
    private double y1 = 0;
    private double y2 = 0;

    private Point2D px = new Point2D.Double(x1, y1);
    private Point2D py = new Point2D.Double(x2, y2);

    private Point2D pxTempo = new Point2D.Double(x2, y2);
    private Point2D pyTempo = new Point2D.Double(x1, y1);

    private boolean init = true;

    static ArrayList<Polygon> polygons = new ArrayList<Polygon>();
    static ArrayList<Color> colors = new ArrayList<Color>();

    // METHODS

    private void reset() {
        x1 = 0;
        x2 = 0;
        y1 = 0;
        y2 = 0;

        px = new Point2D.Double(x1, y1);
        py = new Point2D.Double(x2, y2);

        pxTempo = new Point2D.Double(x2, y2);
        pyTempo = new Point2D.Double(x1, y1);

        init = true;
    }

    private void paintPolygon(Graphics g) {
        super.paint(g);
        for(int i = 0; i < colors.size(); i++){
            g.setColor(colors.get(i));
            g.fillPolygon(polygons.get(i));
        }
    }

    private void paintLine(double[][] coordinate, Graphics gra, boolean end, float top, Color trace) {
        Graphics2D g2 = (Graphics2D)gra;

        Stroke pencil = new BasicStroke(top);
        g2.setStroke(pencil);

        g2.setColor(trace);

        reset();

        for (int e = 0; e < coordinate.length; e++) {
            boolean flight = false;

            if(Math.pow(-1, (e+1))> 0) flight = true;

            Line2D lMoon = paintCoordinate(coordinate[e][0], coordinate[e][1], flight);
            init = false;

            if(init == false && e > 0) g2.draw(lMoon);

            if(e == coordinate.length-1 && end == true) {
                lMoon = new Line2D.Double(pyTempo, pxTempo);
                g2.draw(lMoon);
            }
        }
    }

    private void createPolygon(int[] coordinateX, int[] coordinateY, Graphics gra, Color color, int sides) {
        super.paint(gra);
        Polygon polygon = new Polygon(coordinateX, coordinateY, sides);

        polygons.add(polygon);
        colors.add(color);
    }

    private Line2D paintCoordinate(double pMoon, double pMoon2, boolean flight) {
        
        if(flight == false && init == true) {
            x1 = pMoon;
            y1 = pMoon2;

            px = new Point2D.Double(x1, y1);
            pxTempo = px;
            pyTempo = px;
        }

        if(!init) {
            px = pxTempo;
            x2 = pMoon;
            y2 = pMoon2;
            py = new Point2D.Double(x2, y2);
            pxTempo = py;
        }
        
        Line2D lActual = new Line2D.Double(px, py);

        return lActual;
    }


    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // uncomment to active every draw
        
        // paintCube(g2);
        // paintLadyBug(g2);
        // paintRooster(g2);
        // paintTrain(g2);
        // paintWich(g2);
    }

    public void paintCube(Graphics2D g2) {
        // Front square
        Line2D line1 = new Line2D.Double(100, 130, 100, 280);
        Line2D line2 = new Line2D.Double(250, 130, 250, 280);
        Line2D line3 = new Line2D.Double(100, 130, 250, 130);
        Line2D line4 = new Line2D.Double(100, 280, 250, 280);

        // Back square
        Line2D line5 = new Line2D.Double(175, 90, 175, 240);
        Line2D line6 = new Line2D.Double(325, 90, 325, 240);
        Line2D line7 = new Line2D.Double(175, 90, 325, 90);
        Line2D line8 = new Line2D.Double(175, 240, 325, 240);

        // Intersections
        Line2D line9 = new Line2D.Double(100, 130, 175, 90);
        Line2D line10 = new Line2D.Double(250, 130, 325, 90);
        Line2D line11 = new Line2D.Double(100, 280, 172, 240);
        Line2D line12 = new Line2D.Double(250, 280, 325, 240);

        // pincel
        Stroke pincel = new BasicStroke(4.0f);
        g2.setStroke(pincel);

        // Draw
        g2.draw(line1);
        g2.draw(line2);
        g2.draw(line3);
        g2.draw(line4);
        g2.draw(line5);
        g2.draw(line6);
        g2.draw(line7);
        g2.draw(line8);
        g2.draw(line9);
        g2.draw(line10);
        g2.draw(line11);
        g2.draw(line12);
    }

    public void paintLadyBug(Graphics2D g2) {
        
        // COLORS 
        Color cYellow = new Color(247, 208, 96);
        Color cRed = new Color(205, 109, 96);
        Color cBlack = new Color(45, 39, 39);

        // Main size
        Stroke brush = new BasicStroke(1.5f);
        g2.setStroke(brush);

        // BODY
        // FRAMEBITS, ERROR, ALLBITS, ABORT
        Line2D LineC = new Line2D.Double(200, 172, 200, 265);
        
        Ellipse2D body = new Ellipse2D.Double(135, 135, 130, 130);
        Ellipse2D center = new Ellipse2D.Double(174, 120, 50, 50);

        // Eyes
        Ellipse2D eye1 = new Ellipse2D.Double(178, 115, 22, 22);
        Ellipse2D eye1a = new Ellipse2D.Double(186, 116, 10, 10);

        Ellipse2D eye2 = new Ellipse2D.Double(199, 115, 22, 22);
        Ellipse2D eye2a = new Ellipse2D.Double(203, 116, 10, 10);

        // Antennae
        Ellipse2D at1 = new Ellipse2D.Double(165, 95, 8, 8);
        Ellipse2D at2 = new Ellipse2D.Double(225, 95, 8, 8);

        // SOMEBITS, PROPERTIES, HEIGHT, FRAMEBITS, ERROR, ALLBITS, ABORT
        Arc2D arc1 = new Arc2D.Double(157, 100, 30, 30, 0, 90, Arc2D.OPEN);
        Arc2D arc2 = new Arc2D.Double(210, 100, 30, 30, 90, 90, Arc2D.OPEN);

        // Mouth
        Line2D mouth1 = new Line2D.Double(183, 150, 180, 155);
        Line2D mouth2 = new Line2D.Double(214, 150, 218, 157);

        Arc2D arc3 = new Arc2D.Double(183, 147, 32, 15, 180, 180, Arc2D.OPEN);
        Arc2D arc4 = new Arc2D.Double(187, 147, 25, 20, 200, 150, Arc2D.OPEN);

        // Yellow circles
        Ellipse2D yellow1 = new Ellipse2D.Double(160, 165, 17, 17);
        Ellipse2D yellow2 = new Ellipse2D.Double(150, 195, 17, 17);
        Ellipse2D yellow3 = new Ellipse2D.Double(160, 225, 17, 17);
        Ellipse2D yellow4 = new Ellipse2D.Double(222, 165, 17, 17);
        Ellipse2D yellow5 = new Ellipse2D.Double(232, 195, 17, 17);
        Ellipse2D yellow6 = new Ellipse2D.Double(222, 225, 17, 17);

        // Leg circles
        Ellipse2D legCircle1 = new Ellipse2D.Double(105, 135, 12, 12);
        Ellipse2D legCircle2 = new Ellipse2D.Double(260, 105, 12, 12);
        Ellipse2D legCircle3 = new Ellipse2D.Double(90, 190, 12, 12);
        Ellipse2D legCircle4 = new Ellipse2D.Double(300, 190, 12, 12);
        Ellipse2D legCircle5 = new Ellipse2D.Double(110, 270, 12, 12);
        Ellipse2D legCircle6 = new Ellipse2D.Double(290, 260, 12, 12);

        // Blue line circle leg
        Line2D legLine1 = new Line2D.Double(117, 140, 135, 132);
        Line2D legLine2 = new Line2D.Double(135, 132, 158, 150);

        Line2D legLine3 = new Line2D.Double(250, 160, 270, 145);
        Line2D legLine4 = new Line2D.Double(270, 145, 265, 117);

        Line2D legLine5 = new Line2D.Double(99, 191, 113, 178);
        Line2D legLine6 = new Line2D.Double(113, 178, 137, 183);

        Line2D legLine7 = new Line2D.Double(264, 183, 284, 178);
        Line2D legLine8 = new Line2D.Double(284, 178, 300, 191);

        Line2D legLine9 = new Line2D.Double(115, 270, 123, 248);
        Line2D legLine10 = new Line2D.Double(123, 248, 147, 237);

        Line2D legLine11 = new Line2D.Double(257, 230, 260, 240);
        Line2D legLine12 = new Line2D.Double(260, 240, 294, 260);

        // body drawing

        g2.setColor(cRed);
        g2.fill(body);
        g2.setColor(cBlack);
        g2.draw(body);

        // Body center
        g2.setColor(cBlack);
        g2.fill(center);

        // Central line
        g2.draw(LineC);

        // Eyes
        g2.setColor(cBlack);
        g2.fill(eye1);
        g2.setColor(cBlack);
        g2.fill(eye2);

        // Eyes center
        g2.setColor(Color.white);
        g2.fill(eye1a);
        g2.setColor(Color.WHITE);
        g2.fill(eye2a);

        // Antennae
        g2.setColor(cBlack);
        g2.fill(at1);
        g2.setColor(cBlack);
        g2.fill(at2);
        g2.setColor(cBlack);
        g2.fill(arc1);
        g2.setColor(cBlack);
        g2.fill(arc2);

        // Mouth
        g2.draw(mouth1);
        g2.draw(mouth2);
        g2.setColor(cBlack);
        g2.draw(arc1);
        g2.setColor(cBlack);
        g2.draw(arc2);
        g2.setColor(cBlack);
        g2.draw(arc3);
        g2.setColor(cBlack);
        g2.draw(arc4);

        // Yellow circles

        g2.setColor(cYellow);
        g2.fill(yellow1);
        g2.setColor(cBlack);
        g2.draw(yellow1);

        g2.setColor(cYellow);
        g2.fill(yellow2);
        g2.setColor(cBlack);
        g2.draw(yellow2);

        g2.setColor(cYellow);
        g2.fill(yellow3);
        g2.setColor(cBlack);
        g2.draw(yellow3);

        g2.setColor(cYellow);
        g2.fill(yellow4);
        g2.setColor(cBlack);
        g2.draw(yellow4);

        g2.setColor(cYellow);
        g2.fill(yellow5);
        g2.setColor(cBlack);
        g2.draw(yellow5);

        g2.setColor(cYellow);
        g2.fill(yellow6);
        g2.setColor(cBlack);
        g2.draw(yellow6);

        // Legs
        g2.setColor(cBlack);
        g2.fill(legCircle1);
        g2.draw(legCircle1);

        g2.setColor(cBlack);
        g2.fill(legCircle2);
        g2.draw(legCircle2);

        g2.setColor(cBlack);
        g2.fill(legCircle3);
        g2.draw(legCircle3);

        g2.setColor(cBlack);
        g2.fill(legCircle4);
        g2.draw(legCircle4);

        g2.setColor(cBlack);
        g2.fill(legCircle5);
        g2.draw(legCircle5);

        g2.setColor(cBlack);
        g2.fill(legCircle6);
        g2.draw(legCircle6);

        g2.setColor(cBlack);
        g2.draw(legLine1);
        g2.draw(legLine2);

        g2.draw(legLine3);
        g2.draw(legLine4);

        g2.draw(legLine5);
        g2.draw(legLine6);

        g2.draw(legLine7);
        g2.draw(legLine8);

        g2.draw(legLine9);
        g2.draw(legLine10);
        
        g2.draw(legLine11);
        g2.draw(legLine12);

    }
    
    public void paintRooster(Graphics2D g2) {
        // Colors 
        Color cRed = new Color(227, 73, 122);
        Color cPurple = new Color(156, 119, 207);
        Color cBlue = new Color(59, 168, 241);
        Color cPink = new Color(227, 73, 122);
        Color cYellow = new Color(244, 157, 49);


        // BODY
        int pointsX1[] = {200, 240, 260, 220, 180};
        int pointsY1[] = {170, 170, 215, 250, 215};

        Polygon polygon1 = new Polygon(pointsX1, pointsY1, 5);
        g2.setColor(cRed); // RGB Color
        g2.fillPolygon(polygon1);


        // Neck
        int pointsX2[] = {240, 240, 200};
        int pointsY2[] = {105, 168, 168};

        Polygon polygon2 = new Polygon(pointsX2, pointsY2, 3);
        g2.setColor(cPurple); // RGB Color
        g2.fillPolygon(polygon2);

        // Head
        int pointsX3[] = {262, 262, 242, 242};
        int pointsY3[] = {105, 125, 125, 105};

        Polygon polygon3 = new Polygon(pointsX3, pointsY3, 4);
        g2.setColor(cBlue); // RGB Color
        g2.fillPolygon(polygon3);

        // Crest
        int pointsX4[] = {235, 262, 227};
        int pointsY4[] = {75, 103, 103};

        Polygon polygon4 = new Polygon(pointsX4, pointsY4, 3);
        g2.setColor(cPink); // RGB Color
        g2.fillPolygon(polygon4);

        // Beak
        int pointsX5[] = {264, 280, 264};
        int pointsY5[] = {110, 125, 125};

        Polygon polygon5 = new Polygon(pointsX5, pointsY5, 3);
        g2.setColor(cYellow); // RGB Color
        g2.fillPolygon(polygon5);

        // Jaw
        int pointsX6[] = {252, 262, 242};
        int pointsY6[] = {127, 148, 148};

        Polygon polygon6 = new Polygon(pointsX6, pointsY6, 3);
        g2.setColor(cPink); // RGB Color
        g2.fillPolygon(polygon6);

        // Body tail 1
        // int pointsX7[] = {198, 272, 242};
        // int pointsY7[] = {170, 215, 170};

        // Body tail 1
        int pointsX7[] = {140, 178, 198};
        int pointsY7[] = {170, 215, 170};

        Polygon polygon7 = new Polygon(pointsX7, pointsY7, 3);
        g2.setColor(cYellow); // RGB Color
        g2.fillPolygon(polygon7);

        // Body tail 2
        int pointsX8[] = {168, 198, 138, 108};
        int pointsY8[] = {125, 168, 168, 125};

        Polygon polygon8 = new Polygon(pointsX8, pointsY8, 4);
        g2.setColor(cPink); // RGB Color
        g2.fillPolygon(polygon8);

        // Body tail 2
        int pointsX9[] = {168, 198, 138, 108};
        int pointsY9[] = {125, 168, 168, 125};

        Polygon polygon9 = new Polygon(pointsX9, pointsY9, 4);
        g2.setColor(cBlue); // RGB Color
        g2.fillPolygon(polygon9);

        // Tail 
        int pointsX10[] = {106, 136, 102};
        int pointsY10[] = {127, 168, 230};

        Polygon polygon10 = new Polygon(pointsX10, pointsY10, 3);
        g2.setColor(cPurple); // RGB Color
        g2.fillPolygon(polygon10);

        // Leg 
        int pointsX11[] = {222, 222, 218, 218};
        int pointsY11[] = {252, 300, 300, 252};

        Polygon polygon11 = new Polygon(pointsX11, pointsY11, 4);
        g2.setColor(new Color(244, 156, 48)); // RGB Color
        g2.fillPolygon(polygon11);

        // feet
        Ellipse2D feet = new Ellipse2D.Double(190, 301, 60, 14);
        g2.setColor(new Color(227, 73, 122));
        g2.fill(feet);
    }

    public void paintTrain(Graphics2D g2) {
        // Colors 
        Color cRed = new Color(227, 73, 122);
        Color cPurple = new Color(156, 119, 207);
        Color cBlue = new Color(59, 168, 241);
        Color cPink = new Color(227, 73, 122);
        Color cYellow = new Color(244, 157, 49);

        Rectangle2D base = new Rectangle2D.Double(74, 250, 221, 25);

        // Smoke boiler
        RoundRectangle2D boiler1 = new RoundRectangle2D.Double(170, 140, 25, 103,20,20);
        RoundRectangle2D boiler2 = new RoundRectangle2D.Double(199, 140, 25, 103,20,20);
        RoundRectangle2D boiler3 = new RoundRectangle2D.Double(228, 140, 25, 103,20,20);
        RoundRectangle2D boiler4 = new RoundRectangle2D.Double(257, 140, 25, 103,20,20);
        RoundRectangle2D boiler5 = new RoundRectangle2D.Double(286, 140, 25, 103,20,20);

        // Smokestack
        Rectangle2D SmokeStack = new Rectangle2D.Double(289, 105, 19, 43);
        int pointsX1[] = {311, 322, 311, 286, 275, 286};
        int pointsY1[] = {65, 85, 105, 105, 85, 65};
        Polygon poly1 = new Polygon(pointsX1, pointsY1, 6);
        
        // SmokeBox
        Rectangle2D smokeBox = new Rectangle2D.Double(314, 170, 10, 40);

        // Defense
        int pointsX2[] = {314, 350, 297, 297};
        int pointsY2[] = {235, 287, 287, 235};
        Polygon poly2 = new Polygon(pointsX2, pointsY2, 4);
        
        // cabin
        Rectangle2D cab = new Rectangle2D.Double(90, 174, 77, 35);
        Rectangle2D at = new Rectangle2D.Double(76, 170, 10, 40);
        Rectangle2D tec = new Rectangle2D.Double(87, 70, 80, 30);
        
        Line2D l1 = new Line2D.Double(95, 100, 120, 174);
        Line2D l2 = new Line2D.Double(160, 100, 160, 174);
        Line2D l3 = new Line2D.Double(90, 210, 107, 240);
        Line2D l4 = new Line2D.Double(107, 240, 167, 240);
        Line2D l5 = new Line2D.Double(167, 210, 167, 240);

        // Wheels
        Ellipse2D w1 = new Ellipse2D.Double(90, 223, 80, 80);
        Ellipse2D w2 = new Ellipse2D.Double(120, 253, 20, 20);
        Ellipse2D w3 = new Ellipse2D.Double(212, 223, 80, 80);
        Ellipse2D w4 = new Ellipse2D.Double(242, 253, 20, 20);

        Stroke pen1 = new BasicStroke(3.0f);
        
        // Drawing
        g2.setStroke(pen1);

        // Adding color
        g2.setColor(cBlue);
        g2.fill(base);

        g2.setColor(cPink);
        g2.fill(boiler1);

        g2.setColor(cRed);
        g2.fill(boiler2);

        g2.setColor(cPurple);
        g2.fill(boiler3);

        g2.setColor(cBlue);
        g2.fill(boiler4);

        g2.setColor(cPurple);
        g2.fill(boiler5);

        g2.setColor(cRed);
        g2.fill(smokeBox);

        g2.setColor(cBlue);
        g2.fill(SmokeStack);

        g2.setColor(cPink);
        g2.fill(cab);

        g2.setColor(cYellow);
        g2.fill(at);

        g2.setColor(cPink);
        g2.fill(tec);

        g2.setColor(cRed);
        g2.fill(l1);

        g2.setColor(cPurple);
        g2.fill(l2);

        g2.setColor(cBlue);
        g2.fill(l3);

        g2.setColor(cPink);
        g2.fill(l4);

        g2.setColor(cRed);
        g2.fill(l5);

        g2.setColor(cRed);
        g2.fill(w1);

        g2.setColor(cYellow);
        g2.fill(w2);

        g2.setColor(cBlue);
        g2.fill(w3);

        g2.setColor(cRed);
        g2.fill(w4);

        
        // Just drawing
        // g2.setColor(Color.WHITE);
        g2.draw(base);
        g2.draw(boiler1);
        g2.draw(boiler2);
        g2.draw(boiler3);
        g2.draw(boiler4);
        g2.draw(boiler5);
        g2.draw(smokeBox);
        g2.draw(SmokeStack);
        g2.draw(cab);
        g2.draw(at);
        g2.draw(tec);
        g2.draw(l1);
        g2.draw(l2);
        g2.draw(l3);
        g2.draw(l4);
        g2.draw(l5);
        g2.draw(w1);
        g2.draw(w2);
        g2.draw(w3);
        g2.draw(w4);

        g2.setColor(cRed);
        g2.drawPolygon(poly1);
        g2.fillPolygon(poly1);

        g2.setColor(cPurple);
        g2.drawPolygon(poly2);
        g2.fillPolygon(poly2);

    }

    public void paintWich(Graphics2D g2) {
        double[][] pMoon = new double[][] {
            {293, 11}, {304, 17}, {308, 26},
            {308, 43}, {304, 53}, {293, 59},
            {309, 59}, {319, 54}, {323, 43},
            {323, 26}, {318, 16}, {309, 11},
        };

        double[][] pHat = new double[][] {
            {225, 10}, {246, 26}, {234, 26},
            {246, 48}, {252, 59}, {257, 69},
            {192, 69}, {198, 59}, {204, 48},
        };

        double[][] c1Hat = new double[][] {
            {219, 48}, {230, 48},
            {230, 59}, {219, 59},
        };

        double[][] c2Hat = new double[][] {
            {214, 43}, {235, 43},
            {235, 64}, {214, 64},
        };

        double[][] a1Hat = new double[][] {
            {204, 48}, {214, 48},
            {214, 59}, {198, 59},
        };

        double[][] a2Hat = new double[][] {
            {246, 48}, {235, 48},
            {235, 59}, {252, 59},
        };

        double[][] alaHat = new double[][] {
            {165, 69}, {284, 69},
            {284, 75}, {165, 75},
        };

        double[][] hair1 = new double[][] {
            {191, 75}, {160, 101}, {166, 107},
            {187, 86}, {171, 107}, {177, 112},
            {190, 96}, {182, 117}, {188, 122},
            {204, 75},
        };

        double[][] eyeLeft = new double[][] {
            {203, 80}, {203, 96},
            {220, 96}, {220, 80},
        };

        double[][] eyeRight = new double[][] {
            {228, 80}, {228, 96},
            {245, 96}, {245, 80},
        };

        double[][] pupilLeft = new double[][] {
            {209, 85}, {209, 96},
            {220, 96}, {220, 85},
        };

        double[][] pupilRight = new double[][] {
            {228, 85}, {228, 96},
            {239, 96}, {239, 85},
        };

        double[][] face = new double[][] {
            {204, 75}, {193, 107}, {193, 117},
            {208, 132}, {241, 132}, {256, 117},
            {256, 110}, {244, 75},
        };

        double[][] nose = new double[][] {
            {245, 96}, {198, 96},
            {198, 106}, {231, 106},
        };

        double[][] mouth = new double[][] {
            {209, 112}, {209, 118}, {214, 122},
            {236, 122}, {241, 118}, {241, 112},
        };

        double[][] body = new double[][] {
            {208, 132}, {192, 175}, {192, 181},
            {256, 181}, {256, 175}, {241, 132},
        };

        double[][] rightArm = new double[][] {
            {208, 132}, {176, 165},
            {181, 170}, {201, 151},
        };

        double[][] leftArm = new double[][] {
            {241, 132}, {272, 128},
            {278, 133}, {247, 149},
        };

        double[][] rightHand = new double[][] {
            {176, 165}, {171, 170}, {171, 175},
            {181, 175}, {181, 170},
        };

        double[][] leftHand = new double[][] {
            {271, 128}, {272, 117}, {277, 117},
            {277, 122}, {283, 117}, {288, 127},
            {278, 133},
        };

        double[][] broom = new double[][] {
            {256, 175}, {283, 175}, {283, 181}, {256, 181},
        };

        double[][] broom1 = new double[][] {
            {166, 175}, {192, 175}, {192, 181}, {166, 181},
        };

        double[][] broom2 = new double[][] {
            {283, 175}, {287, 160}, {336, 160},
            {336, 196}, {287, 196}, {283, 181},
        };

        double[][] adesc1 = new double[][] {
            {192, 175}, {192, 181},
        };

        double[][] adesc2 = new double[][] {
            {256, 175}, {256, 181},
        };

        double[][] adesc3 = new double[][] {
            {283, 175}, {283, 181},
        };

        double[][] rightLeg = new double[][] {
            {207, 181}, {219, 205}, {240, 205},
            {246, 215}, {246, 198}, {225, 198},
            {218, 181},
        };

        double[][] leftLeg = new double[][] {
            {230, 181}, {239, 197}, {260, 197},
            {266, 207}, {266, 190}, {245, 190},
            {241, 181},
        };

        double[][] rightSock = new double[][] {
            {230, 198}, {230, 205},
            {235, 205}, {235, 198},
        };

        double[][] leftSock = new double[][] {
            {150, 190}, {250, 197},
            {255, 197}, {255, 190},
        };

        // coordinates of polygons
        int[] cMoonX = {293, 309, 318, 323, 323, 319, 309, 293, 304, 308, 308, 304};
        int[] cMoonY = {11, 11, 16, 26, 43, 54, 59, 59, 53, 43, 26, 17};

        int[] cHat1X = {214, 235, 235, 214};
        int[] cHat1Y = {214, 235, 235, 214};

        int[] cHat2X = {219, 230, 230, 219};
        int[] cHat2Y = {48, 48, 59, 59};

        int[] cHatA1X = {204, 214, 214, 198};
        int[] cHatA1Y = {48, 48, 59, 59};

        int[] cHairRightX = {191, 160, 166, 187, 171, 177, 190, 182, 188, 204};
        int[] cHairRightY = {75, 101, 107, 86, 107, 112, 96, 117, 122, 75};

        int[] cHairLeftX = {244, 260, 266, 258, 271, 277, 261, 282, 277, 257};
        int[] cHairLeftY = {75, 122, 117, 96, 112, 107, 86, 107, 107, 75};

        int[] cFaceX = {204, 193, 193, 208, 241, 256, 256, 244};
        int[] cFaceY = {75, 107, 117, 132, 132, 117, 110, 75};

        int[] cEyeRightX = {203, 220, 220, 203};
        int[] cEyeRightY = {80, 80, 96, 96};

        int[] cEyeLeftX = {228, 245, 245, 228};
        int[] cEyeLeftY = {80, 80, 96, 96};

        int[] cPupilRightX = {209, 220, 220, 209};
        int[] cPupilRightY = {85, 85, 96, 96};

        int[] cPupilLeftX = {228, 239, 239, 228};
        int[] cPupilLeftY = {85, 85, 96, 96};

        int[] cHatTopX = {204, 225, 246, 234, 246, 235, 214, 214};
        int[] cHatTopY = {48, 10, 26, 26, 48, 48, 43, 43, 48};

        int[] cHatBottomtX = {198, 192, 257, 252, 235, 235, 214, 214};
        int[] cHatBottomtY = {56, 69, 69, 59, 59, 64, 64, 59};

        int[] cHatAlaX = {69, 75, 75, 69};
        int[] cHatAlaY = {208, 201, 181, 176};

        int[] cArmRightX = {208, 201, 181, 176};
        int[] cArmRightY = {132, 151, 170, 165};

        int[] cArmLeftX = {241, 247, 278, 272};
        int[] cArmLeftY = {132, 149, 133, 128};

        int[] cBodyX = {208, 241, 256, 256, 192, 192};
        int[] cBodyY = {132, 132, 175, 181, 181, 175};

        int[] cHandRightX = {171, 171, 176, 181, 181};
        int[] cHandRightY = {175, 170, 165, 170, 175};

        int[] cHandLeftX = {272,272, 277, 277, 283, 288, 278};
        int[] cHandLeftY = {128, 117, 117, 122, 117, 127, 123};

        int[] cLegRightX = {207, 218, 225, 230, 230, 219};
        int[] cLegRightY = {181, 181, 198, 198, 205, 205};

        int[] cLegLeftX = {230, 241, 245, 250, 250, 239};
        int[] cLegLeftY = {181, 181, 190, 190, 197, 197};
        
        int[] cSockRightX = {230, 235, 235, 230};
        int[] cSockRightY = {205, 205, 198, 198};

        int[] cSockLeftX = {250, 255, 255, 250};
        int[] cSockLeftY = {197, 197, 190, 190};

        int[] cShoeRightX = {235, 240, 246, 246, 235};
        int[] cShoeRightY = {205, 205, 215, 198, 198};

        int[] cShoeLeftX = {255, 260, 266, 266, 255};
        int[] cShoeLeftY = {197, 197, 207, 190, 190};

        int[] cBroomX = {283, 287, 336, 336, 287, 283};
        int[] cBroomY = {175, 160, 160, 196, 196, 181};

        int[] cBroomSrickDX = {166, 192, 192, 166};
        int[] cBroomSrickDY = {175, 175, 181, 181};

        int[] cBroomSrickIX = {256, 283, 283, 256};
        int[] cBroomSrickIY = {175, 175, 181, 181};


        polygons.clear();
        colors.clear();

        Color CyellowMoon = new Color(239, 237, 48);
        Color CyellowSock = new Color(253, 247, 51);
        Color CYellowBroom = new Color(251, 208, 51);
        Color CbroomStick = new Color(182, 140, 95);
        Color Cpurple = new Color(146, 71, 204);
        Color CgreenSkin = new Color(133, 220, 78);
        Color Cblack = Color.BLACK;
        Color Cwhite = Color.WHITE;

        createPolygon(cMoonX, cMoonY, g2, CyellowMoon, 12);
        createPolygon(cHat1X, cHat1Y, g2, CyellowSock, 4);
        createPolygon(cHat2X, cHat2Y, g2, Cblack, 4);
        createPolygon(cHatA1X, cHatA1Y, g2, Cblack, 4);
        // createPolygon(cHatA2X, cHatA2Y, g2, Cblack, 4);
        createPolygon(cHatA1X, cHatA1Y, g2, Cblack, 4);
        createPolygon(cHatA1X, cHatA1Y, g2, Cblack, 4);
        


    }

    
}