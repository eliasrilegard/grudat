/**
 * A test class for all unit tests of the class Vector.
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2021-05-18
 */

import vector.*;

class VectorTest {
  private static final float Zero = 0.000001f;
  private static final float zero = -0.000001f;
  private static final float One = 1.000001f;
  private static final float one = 0.999999f;

  private static void testConstructor() {
    Vector v = new Vector();
    assert v.x == 0 && v.y == 0 && v.z == 0;

    v = new Vector(1, 2);
    assert v.x == 1 && v.y == 2 && v.z == 0;

    v = new Vector(3, 4, 5);
    assert v.x == 3 && v.y == 4 && v.z == 5;
  }

  private static void testSet() {
    Vector v = new Vector();
    v.set(1, 3);
    assert v.x == 1 && v.y == 3 && v.z == 0;

    v.set(3, 5);
    assert v.x == 3 && v.y == 5 && v.z == 0;

    v.set(2, 4, 6);
    assert v.x == 2 && v.y == 4 && v.z == 6;

    v.set(3, 5);
    assert v.x == 3 && v.y == 5 && v.z == 6;

    v.set(1, 1, 1);
    assert v.x == 1 && v.y == 1 && v.z == 1;

    Vector v2 = new Vector();
    v2.set(v);
    assert v2.x == 1 && v2.y == 1 && v2.z == 1;

    v.set(v);
    assert v.x == 1 && v.y == 1 && v.z == 1;
  }

  private static void testRandom2D() {
    Vector v = Vector.random2D();
    float magSq = v.x * v.x + v.y * v.y;
    assert magSq >= one && magSq <= One;
    assert v.z == 0;
  }

  private static void testRandom3D() {
    Vector v = Vector.random3D();
    float magSq = v.x * v.x + v.y * v.y + v.z * v.z;
    assert magSq >= one && magSq <= One;
  }

  private static void testFromAngle() {
    Vector v = Vector.fromAngle(0);
    assert v.x == 1 && v.y == 0;

    float magSq = v.x * v.x + v.y * v.y + v.z * v.z;
    assert magSq >= one && magSq <= One;

    v = Vector.fromAngle((float) Math.PI * 2);
    assert v.x >= one && v.x <= One;
    assert v.y >= zero && v.y <= Zero;

    magSq = v.x * v.x + v.y * v.y + v.z * v.z;
    assert magSq >= one && magSq <= One;

    v = Vector.fromAngle((float) Math.PI / 2);
    assert v.x >= zero && v.x <= Zero;
    assert v.y >= one && v.y <= One;

    magSq = v.x * v.x + v.y * v.y + v.z * v.z;
    assert magSq >= one && magSq <= One;

    v = Vector.fromAngle((float) Math.PI / 4);
    assert v.x - v.y >= zero && v.x - v.y <= Zero;

    magSq = v.x * v.x + v.y * v.y + v.z * v.z;
    assert magSq >= one && magSq <= One;
  }

  private static void testCopy() {
    Vector v1 = Vector.random3D();
    Vector v2 = v1.copy();
    assert v1.x == v2.x && v1.y == v2.y && v1.z == v2.z;

    float magSq = v2.x * v2.x + v2.y * v2.y + v2.z * v2.z;
    assert magSq >= one && magSq <= One;
  }

  private static void testNorm() {
    Vector v = new Vector();
    assert v.norm() == 0;

    v.set(0, 0, 0);
    assert v.norm() == 0;

    v = new Vector(1, 0, 0);
    assert v.norm() == 1;

    v = new Vector(3, 4, 12);
    assert v.norm() == 13;

    v = Vector.random3D();
    assert v.norm() >= one && v.norm() <= One;
  }

  private static void testAdd() {
    Vector v1 = Vector.random3D();
    Vector v2 = Vector.random3D();
    Vector v = Vector.add(v1, v2);
    assert v.x == v1.x + v2.x && v.y == v1.y + v2.y && v.z == v1.z + v2.z;

    v = v1.copy();
    v.add(v2);
    assert v.x == v1.x + v2.x && v.y == v1.y + v2.y && v.z == v1.z + v2.z;

    v = new Vector(1, 1, 1);
    v.add(1, 2, 4);
    assert v.x == 2 && v.y == 3 && v.z == 5;

    v.add(1, 1);
    assert v.x == 3 && v.y == 4 && v.z == 5;

    v.add(0, 0, -1);
    assert v.x == 3 && v.y == 4 && v.z == 4;
  }

  private static void testSub() {
    Vector v1 = Vector.random3D();
    Vector v2 = Vector.random3D();
    Vector v = Vector.sub(v1, v2);
    assert v.x == v1.x - v2.x && v.y == v1.y - v2.y && v.z == v1.z - v2.z;

    v = v1.copy();
    v.sub(v2);
    assert v.x == v1.x - v2.x && v.y == v1.y - v2.y && v.z == v1.z - v2.z;

    v = new Vector(1, 1, 1);
    v.sub(1, 2, 4);
    assert v.x == 0 && v.y == -1 && v.z == -3;

    v.sub(1, 1);
    assert v.x == -1 && v.y == -2 && v.z == -3;

    v.sub(0, 0, -1);
    assert v.x == -1 && v.y == -2 && v.z == -2;
  }

  private static void testMult() {
    Vector v = new Vector(1, 1, 1);
    v.mult(2);
    assert v.x == 2 && v.y == 2 && v.z == 2;

    v.set(3, 4, 12);
    v.mult(2);
    assert v.norm() >= one * 26 && v.norm() <= One * 26;

    v.mult(-1);
    assert v.norm() >= one * 26 && v.norm() <= One * 26;

    v.mult(0);
    assert v.norm() >= zero && v.norm() <= Zero;
  }

  private static void testDivide() {
    Vector v = new Vector(2, 2, 2);
    v.divide(2);
    assert v.x == 1 && v.y == 1 && v.z == 1;

    v.set(6, 8, 24);
    v.divide(2);
    assert v.norm() >= one * 13 && v.norm() <= One * 13;

    v.divide(-1);
    assert v.norm() >= one * 13 && v.norm() <= One * 13;

    try {
      v.divide(0);
    }
    catch (ArithmeticException e) {
      assert e.getMessage().equals("Cannot divide by 0");
    }
  }

  private static void testDist() {
    Vector v0 = new Vector(0, 0, 0);
    Vector v1 = new Vector(1, 0, 0);
    assert Vector.dist(v0, v1) == 1;
    assert v0.dist(v1) == 1;
    assert v1.dist(v0) == 1;

    v1 = Vector.random3D();
    assert Vector.dist(v0, v1) >= one && Vector.dist(v0, v1) <= One;

    Vector v = Vector.random3D();
    assert v.dist(v) == 0;
  }

  private static void testDot() {
    Vector v1 = new Vector(1, 2, 3);
    Vector v2 = new Vector(4, 5, 6);
    assert Vector.dot(v1, v2) == 32;

    v1.set(1, 0, 0);
    v2.set(0, 1, 0);
    assert v1.dot(v2) == 0;

    v2.set(-1, 0, 0);
    assert v1.dot(v2) == -1;

    Vector v = Vector.random3D();
    assert v.dot(v) >= one && v.dot(v) <= One;
  }

  private static void testCross() {
    Vector v1 = new Vector(1, 0, 0);
    Vector v2 = new Vector(0, 1, 0);
    Vector v = Vector.cross(v1, v2);
    assert v.dot(v1) == 0;
    assert v.dot(v2) == 0;
    assert v.norm() == 1;

    v1 = Vector.random3D();
    v2 = Vector.random3D();
    v = v1.cross(v2);
    assert v.dot(v1) >= zero && v.dot(v1) <= Zero;
    assert v.dot(v2) >= zero && v.dot(v2) <= Zero;

    Vector v3 = v2.cross(v1);
    v3.mult(-1);
    assert v3.x == v.x && v3.y == v.y && v3.z == v.z;

    v = v1.cross(v1);
    assert v.x == 0 && v.y == 0 && v.z == 0;
  }

  private static void testNormalize() {
    Vector v = Vector.random3D();
    v.mult((float) Math.random() * 10);
    v.normalize();
    assert v.norm() >= one && v.norm() <= One;
  }

  private static void testSetMag() {
    Vector v = Vector.random3D();
    v.mult((float) Math.random() * 10);
    float mag = (float) Math.random() * 10 + 10;
    v.setMag(mag);
    assert v.norm() >= one * mag && v.norm() <= One * mag;
    v.setMag(0);
    assert v.x == 0 && v.y == 0 && v.z == 0;
  }

  private static void testRotate() {
    // 2D
    Vector v = new Vector(1,0);
    v.rotate((float) Math.PI / 2);
    assert v.x >= zero && v.x <= Zero;
    assert v.y >= one && v.y <= One;
    assert v.z == 0;
    assert v.norm() >= one && v.norm() <= One;
    v.rotate((float) (Math.random() * 2 * Math.PI));
    assert v.norm() >= one && v.norm() <= One;

    Vector v1 = v.copy();
    v1.rotate(0);
    assert v.x - v1.x >= zero && v.x - v1.x <= Zero;
    assert v.y - v1.y >= zero && v.y - v1.y <= Zero;
    assert v1.z == 0;

    v1.rotate((float) Math.PI * 2);
    assert v.x - v1.x >= zero && v.x - v1.x <= Zero;
    assert v.y - v1.y >= zero && v.y - v1.y <= Zero;
    assert v1.z == 0;

    // 3D
    Vector axis = new Vector(1, 1, 1);
    v = new Vector(1, 0, 0);
    v.rotate(axis, (float) Math.PI * 2 / 3);
    assert v.x >= zero && v.x <= Zero;
    assert v.y >= one && v.y <= One;
    assert v.z >= zero && v.z <= Zero;
    assert v.norm() >= one && v.norm() <= One;

    axis.set(0, 1, 0);
    v.set(1, 0, 0);
    v.rotate(axis, (float) Math.PI / 2);
    assert v.x >= zero && v.x <= Zero;
    assert v.y >= zero && v.y <= Zero;
    assert v.z <= -1 * one && v.z >= -1 * One;

    v.rotate(axis, 0);
    assert v.x >= zero && v.x <= Zero;
    assert v.y >= zero && v.y <= Zero;
    assert v.z <= -1 * one && v.z >= -1 * One;

    v.set(1, 0, 0);
    v1 = v.copy();
    v.rotate(v, 1);
    assert v.x == v1.x && v.y == v1.y && v.z == v1.z;
  }

  private static void testLerp() {
    Vector v1 = new Vector(1, 0, 0);
    Vector v2 = new Vector(-1, 0, 0);
    Vector v = Vector.lerp(v1, v2, 0.5f);
    assert v.x == 0 && v.y == 0 && v.z == 0;

    v.set(v1);
    v.lerp(v2, 0);
    assert v.x == v1.x && v.y == v1.y && v.z == v1.z;

    v.lerp(v2, 1);
    assert v.x == v2.x && v.y == v2.y && v.z == v2.z;
    
    v1 = Vector.random3D();
    v2 = Vector.random3D();
    v = Vector.lerp(v1, v2, (float) Math.random());
    assert v2.dot(v) >= v2.dot(v1);
  }

  private static void testAngleBetween() {
    Vector v1 = new Vector(1, 0, 0);
    Vector v2 = new Vector(0, 1, 0);
    assert v1.angleBetween(v2) >= one * (float) Math.PI / 2 && v1.angleBetween(v2) <= One * (float) Math.PI / 2;

    v1 = Vector.random3D();
    v2 = Vector.random3D();
    assert Vector.angleBetween(v1, v2) >= 0;
  }

  private static void testArray() {
    Vector v = Vector.random3D();
    float[] array = v.array();
    assert array[0] == v.x && array[1] == v.y && array[2] == v.z;
  }

  private static void testEquals() {
    Vector v1 = new Vector();
    Object obj = new Object();
    assert !(v1.equals(obj));

    v1.set(1, 0, 0);
    Vector v2 = new Vector(0, 1, 0);
    assert !(v1.equals(v2));

    v2.set(1, 0, 0);
    assert v1.equals(v2);
    assert v1.equals(v1);

    v1.set(0, 0, 0);
    assert v1.equals(v1);
  }

  private static void testToString() {
    Vector v = new Vector();
    assert v.toString().equals("[0.0, 0.0, 0.0]");

    v.set(1, -2.7182f, 3.1415f);
    assert v.toString().equals("[1.0, -2.7182, 3.1415]");
  }

  /**
   * Unit test. Usage:
   * $ javac -d . Vector.java
   * $ java -ea VectorTest.java
   */
  public static void main(String[] args) {
    testConstructor();
    testSet();
    testRandom2D();
    testRandom3D();
    testFromAngle();
    testCopy();
    testNorm();
    testAdd();
    testSub();
    testMult();
    testDivide();
    testDist();
    testDot();
    testCross();
    testNormalize();
    testSetMag();
    testRotate();
    testLerp();
    testAngleBetween();
    testArray();
    testEquals();
    testToString();
  }
}