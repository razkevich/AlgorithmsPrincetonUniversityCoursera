import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.Stack;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.Random;

/******************************************************************************
 * Compilation:  javac GrahamaScan.java
 * Execution:    java GrahamScan < input.txt
 * Dependencies: Point2D.java
 * Data files:   http://algs4.cs.princeton.edu/99hull/rs1423.txt
 * http://algs4.cs.princeton.edu/99hull/kw1260.txt
 * <p>
 * Create points from standard input and compute the convex hull using
 * Graham scan algorithm.
 * <p>
 * May be floating-point issues if x- and y-coordinates are not integers.
 * <p>
 * % java GrahamScan < input100.txt
 * (7486.0, 422.0)
 * (29413.0, 596.0)
 * (32011.0, 3140.0)
 * (30875.0, 28560.0)
 * (28462.0, 32343.0)
 * (15731.0, 32661.0)
 * (822.0, 32301.0)
 * (823.0, 15895.0)
 * (1444.0, 10362.0)
 * (4718.0, 4451.0)
 ******************************************************************************/


/**
 * The {@code GrahamScan} data type provides methods for computing the
 * convex hull of a set of <em>N</em> points in the plane.
 * <p>
 * The implementation uses the Graham-Scan convex hull algorithm.
 * It runs in O(<em>N</em> log <em>N</em>) time in the worst case
 * and uses O(<em>N</em>) extra memory.
 * <p>
 * For additional documentation, see <a href="http://algs4.cs.princeton.edu/99scientific">Section 9.9</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
public class GrahamScan extends JFrame {
    private Stack<Point2D> hull = new Stack<Point2D>();

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Point2D position : points) {
            g.drawOval(((int) (500 - position.x())), ((int) (500 - position.y())), 1,1);
        }
        g.setColor(Color.RED);
        Point2D prev = null;
        for (Point2D position : graham.hull()) {
            g.drawOval(((int) (500 - position.x())), ((int) (500 - position.y())), 1, 1);
            if (prev != null) {
                g.drawLine(500 - (int) (position.x()), 500 - (int) (position.y()), 500 - (int) (prev.x()), 500 - (int) (prev.y()));
            }
            prev = position;
        }
        Point2D first = graham.hull().iterator().next();
        g.drawLine(500 - (int) (first.x()), 500 - (int) (first.y()), 500 - (int) (prev.x()), 500 - (int) (prev.y()));
    }

    /**
     * Computes the convex hull of the specified array of points.
     *
     * @param pts the array of points
     * @throws NullPointerException if {@code points} is {@code null} or if any
     *                              entry in {@code points[]} is {@code null}
     */
    public GrahamScan(Point2D[] pts) {
        this.setPreferredSize(new Dimension(400, 400));
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // defensive copy
        int n = pts.length;
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++)
            points[i] = pts[i];

        // preprocess so that points[0] has lowest y-coordinate; break ties by x-coordinate
        // points[0] is an extreme point of the convex hull
        // (alternatively, could do easily in linear time)
        Arrays.sort(points);

        // sort by polar angle with respect to base point points[0],
        // breaking ties by distance to points[0]
        Arrays.sort(points, 1, n, points[0].polarOrder());

        hull.push(points[0]);       // p[0] is first extreme point

        // find index k1 of first point not equal to points[0]
        int k1;
        for (k1 = 1; k1 < n; k1++)
            if (!points[0].equals(points[k1])) break;
        if (k1 == n) return;        // all points equal

        // find index k2 of first point not collinear with points[0] and points[k1]
        int k2;
        for (k2 = k1 + 1; k2 < n; k2++)
            if (Point2D.ccw(points[0], points[k1], points[k2]) != 0) break;
        hull.push(points[k2 - 1]);    // points[k2-1] is second extreme point

        // Graham scan; note that points[n-1] is extreme point different from points[0]
        for (int i = k2; i < n; i++) {
            Point2D top = hull.pop();
            while (Point2D.ccw(hull.peek(), top, points[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(points[i]);
        }

        assert isConvex();
    }

    /**
     * Returns the extreme points on the convex hull in counterclockwise order.
     *
     * @return the extreme points on the convex hull in counterclockwise order
     */
    public Iterable<Point2D> hull() {
        Stack<Point2D> s = new Stack<Point2D>();
        for (Point2D p : hull) s.push(p);
        return s;
    }

    // check that boundary of hull is strictly convex
    private boolean isConvex() {
        int n = hull.size();
        if (n <= 2) return true;

        Point2D[] points = new Point2D[n];
        int k = 0;
        for (Point2D p : hull()) {
            points[k++] = p;
        }

        for (int i = 0; i < n; i++) {
            if (Point2D.ccw(points[i], points[(i + 1) % n], points[(i + 2) % n]) <= 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Unit tests the {@code GrahamScan} data type.
     * Reads in an integer {@code n} and {@code n} points (specified by
     * their <em>x</em>- and <em>y</em>-coordinates) from standard input;
     * computes their convex hull; and prints out the points on the
     * convex hull to standard output.
     *
     * @param args the command-line arguments
     */
    private static GrahamScan graham;
    private static Point2D[] points;

    public static void main(String[] args) {
        points = new Point2D[50];
        for (int i = 0; i < 50; i++) {
            points[i] = new Point2D((int) (new Random().nextFloat() * 500), ((int) (new Random().nextFloat() * 500)));
        }
        graham = new GrahamScan(points);
    }

}
