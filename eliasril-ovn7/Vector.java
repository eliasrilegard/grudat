/**
 * A class to describe a two or three dimensional vector.
 * <p>
 * This class was made as a solution to grudat21 uppgift 7, being the final project of the course.
 *
 * @author Elias Rilegård
 * @version 1.0
 * @since 2021-05-18
 */

package vector;

public class Vector {
  /**
   * The x component of the Vector. This can be used to both set and get the value.
   */
  public float x;

  /**
   * The y component of the Vector. This can be used to both set and get the value.
   */
  public float y;
  
  /**
   * The z component of the Vector. This can be used to both set and get the value.
   */
  public float z;

  /**
   * Constructor for an empty Vector.
   */
  public Vector() {
  }

  /**
   * Constructor for a 2D Vector object with specified coordinates.
   *
   * @param x The x component.
   * @param y The y component.
   */
  public Vector(float x, float y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Constructor for a 3D Vector object with specified coordinates.
   *
   * @param z The z component.
   */
  public Vector(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  /**
   * Set the components of the Vector.
   *
   * @param x The x component to be set.
   * @param y The y component to be set.
   */
  public Vector set(float x, float y) {
    this.x = x;
    this.y = y;
    return this;
  }

  /**
   * @param z The z component to be set.
   */
  public Vector set(float x, float y, float z) {
    this.x = x;
    this.y = y;
    this.z = z;
    return this;
  }

  /**
   * @param v Any variable of type Vector.
   */
  public Vector set(Vector v) {
    this.x = v.x;
    this.y = v.y;
    this.z = v.z;
    return this;
  }
  
  /**
   * Create a new 2D unit Vector pointing in a random direction.
   *
   * @return The random Vector.
   */
  public static Vector random2D() {
    double angle = Math.random() * 2 * Math.PI;
    return new Vector((float) Math.cos(angle), (float) Math.sin(angle));
  }

  /**
   * Create a new 3D unit Vector pointing in a random direction.
   *
   * @return The random Vector.
   */
  public static Vector random3D() {
    float angle = (float) (Math.random() * 2 * Math.PI);
    float vz = (float) (Math.random() * 2 - 1);
    float vx = (float) (Math.sqrt(1 - vz * vz) * Math.cos(angle));
    float vy = (float) (Math.sqrt(1 - vz * vz) * Math.sin(angle));
    return new Vector(vx, vy, vz);
  }
  
  /**
   * Create a new 2D Vector from an angle.
   *
   * @param angle The angle from the horizontal axis for which to create the Vector from.
   * @return The new unit Vector.
   */
  public static Vector fromAngle(float angle) {
    return new Vector((float) Math.cos(angle), (float) Math.sin(angle));
  }

  /**
   * Create a copy of the Vector.
   *
   * @return A copy of the Vector.
   */
  public Vector copy() {
    return new Vector(this.x, this.y, this.z);
  }

  /**
   * Get the magnitude (norm) of the Vector
   *
   * @return The norm of the Vector.
   */
  public float norm() {
    return (float) Math.sqrt(x * x + y * y + z * z);
  }

  /**
   * Add a Vector to this one.
   *
   * @param v The Vector to add.
   */
  public Vector add(Vector v) {
    this.x += v.x;
    this.y += v.y;
    this.z += v.z;
    return this;
  }

  /**
   * Add a Vector to this one in component form.
   *
   * @param x The x component of the Vector to add.
   * @param y The y component of the Vector to add.
   */
  public Vector add(float x, float y) {
    this.x += x;
    this.y += y;
    return this;
  }

  /**
   * @param z The z component of the Vector to add.
   */
  public Vector add(float x, float y, float z) {
    this.x += x;
    this.y += y;
    this.z += z;
    return this;
  }

  /**
   * Adds two Vectors and return the result.
   *
   * @param v1 The first Vector.
   * @param v2 The second Vector.
   * @return The resulting Vector v1 + v2.
   */
  public static Vector add(Vector v1, Vector v2) {
    return new Vector(v1.x + v2.x, v1.y + v2.y, v1.z + v2.z);
  }

  /**
   * Subtract a Vector from this one.
   *
   * @param v The Vector to subtract off.
   */
  public Vector sub(Vector v) {
    this.x -= v.x;
    this.y -= v.y;
    this.z -= v.z;
    return this;
  }

  /**
   * Subtract a Vector in component from off of this one.
   *
   * @param x The x component of the Vector to subtract off.
   * @param y The y component of the Vector to subtract off.
   */
  public Vector sub(float x, float y) {
    this.x -= x;
    this.y -= y;
    return this;
  }

  /**
   * @param z The z component of the Vector to subtract off.
   */
  public Vector sub(float x, float y, float z) {
    this.x -= x;
    this.y -= y;
    this.z -= z;
    return this;
  }

  /**
   * Subtract two Vectors and returns the result.
   *
   * @param v1 The "base" Vector.
   * @param v2 The Vector to subtract off.
   * @return The resulting Vector v1 - v2.
   */
  public static Vector sub(Vector v1, Vector v2) {
    return new Vector(v1.x - v2.x, v1.y - v2.y, v1.z - v2.z);
  }

  /**
   * Multiply the vector by a scalar.
   *
   * @param scalar The scalar to multiply by.
   */
  public Vector mult(float scalar) {
    this.x *= scalar;
    this.y *= scalar;
    this.z *= scalar;
    return this;
  }

  /**
   * Divide the vector by a scalar.
   *
   * @param scalar The scalar to divide by.
   * @throws ArithmeticException If passed a scalar equal to 0.
   */
  public Vector divide(float scalar) {
    if (scalar == 0) throw new ArithmeticException("Cannot divide by 0");
    this.x /= scalar;
    this.y /= scalar;
    this.z /= scalar;
    return this;
  }

  /**
   * Calculate the distance between this vector and another one.
   *
   * @param v The x, y & z coordinates of a Vector.
   * @return The Euclidian distance between this Vector and v.
   */
  public float dist(Vector v) {
    float dx = this.x - v.x;
    float dy = this.y - v.y;
    float dz = this.z - v.z;
    return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
  }

  /**
   * Calculate the distance between two points.
   *
   * @param v1 Any variable of type Vector.
   * @param v2 Any variable of type Vector.
   * @return The Euclidian distance between v1 and v2 .  
   */
  public static float dist(Vector v1, Vector v2) {
    float dx = v1.x - v2.x;
    float dy = v1.y - v2.y;
    float dz = v1.z - v2.z;
    return (float) Math.sqrt(dx * dx + dy * dy + dz * dz);
  }

  /**
   * Calculate the dot product of this Vector with another one.
   *
   * @param v Any variable of type Vector.
   * @return The dot product of this and v.
   */
  public float dot(Vector v) {
    return this.x * v.x + this.y * v.y + this.z * v.z;
  }

  /**
   * Calculate and return the dot product of two Vectors.
   *
   * @param v1 Any variable of type Vector.
   * @param v2 Any variable of type Vector.
   * @return v1 (dot) v2.
   */
  public static float dot(Vector v1, Vector v2) {
    return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
  }

  /**
   * Calculate the cross product of this Vector with another one.
   *
   * @param v Any variable of type Vector.
   * @return this (cross) v.
   */
  public Vector cross(Vector v) {
    return cross(this, v);
  }

  /**
   * Calculate and return the cross product of two vectors.
   *
   * @param v1 Any variable of type Vector.
   * @param v2 Any variable of type Vector.
   * @return v1 (cross) v2.
   */
  public static Vector cross(Vector v1, Vector v2) {
    float crossX = v1.y * v2.z - v2.y * v1.z;
    float crossY = v1.z * v2.x - v2.z * v1.x;
    float crossZ = v1.x * v2.y - v2.x * v1.y;
    return new Vector(crossX, crossY, crossZ);
  }

  /**
   * Normalize the Vector.
   */
  public Vector normalize() {
    float m = this.norm();
    if (m != 0 && m != 1)
      this.divide(m);
    return this;
  }

  /**
   * Set the magnitude of the Vector.
   *
   * @param mag The magnitude to set the Vector to.
   */
  public Vector setMag(float mag) {
    this.normalize();
    this.mult(mag);
    return this;
  }

  /**
   * Rotate a 2D Vector by an angle (CCW).
   *
   * @param angle The angle to rotate the Vector by.
   */
  public Vector rotate(float angle) {
    float newX = this.x * (float) Math.cos(angle) - this.y * (float) Math.sin(angle);
    float newY = this.x * (float) Math.sin(angle) + this.y * (float) Math.cos(angle);
    this.set(newX, newY);
    return this;
  }

  /**
   * Rotate a 3D Vector around an axis by an angle.
   *
   * @param axis The axis to rotate the Vector around. Can be any length.
   * @param angle The angle to rotate the Vector by.
   */
  public Vector rotate(Vector axis, float angle) {
    if (this.equals(axis)) return this;

    // For details see Rodrigues' rotation formula
    Vector k = axis.normalize();
    Vector cross = cross(k, this);
    float dot = dot(k, this);
    float cos = (float) (1 - Math.cos(angle));

    this.mult((float) Math.cos(angle));
    this.add(cross.mult((float) Math.sin(angle)));
    this.add(k.mult(dot * cos));
    return this;
  }

  /**
   * Linear interpolate the Vector to another vector.
   *
   * @param v The Vector to lerp to.
   * @param amt The amount of interpolation; any value between 0.0 (this Vector) and 1.0 (v). 0.1 is near this Vector, 0.5 is halfway in between.
   * @throws IllegalArgumentException If amt is not in between (or equal to) 0 and 1.
   */
  public Vector lerp(Vector v, float amt) {
    if (amt > 1 || amt < 0) throw new IllegalArgumentException("Cannot interpolate to a value < 0 or > 1.");
    this.mult(1 - amt);
    this.add(v.copy().mult(amt));
    return this;
  }

  /**
   * Linear interpolate two Vectors and return the result.
   *
   * @param v1 The Vector to start from.
   * @param v2 The Vector to interpolate to.
   * @return The interpolated Vector.
   */
  public static Vector lerp(Vector v1, Vector v2, float amt) {
    if (amt > 1 || amt < 0) throw new IllegalArgumentException("Cannot interpolate to a value < 0 or > 1.");
    Vector v = new Vector();
    v.set(v1.copy().mult(1 - amt));
    v.add(v2.copy().mult(amt));
    return v;
  }

  /**
   * Calculate the angle between two Vectors.
   *
   * @param v1 Any variable of type Vector.
   * @param v2 The Vector for which to calculate the angle between it and the first one.
   * @return The angle between the Vectors.
   */
  public static float angleBetween(Vector v1, Vector v2) {
    if ((v1.x == 0 && v1.y == 0 && v1.z == 0) ||
        (v2.x == 0 && v2.y == 0 && v2.z == 0))
      return 0.0f;

    double dot = v1.x * v2.x + v1.y * v2.y + v1.z * v2.z;
    double v1norm = Math.sqrt(v1.x * v1.x + v1.y * v1.y + v1.z * v1.z);
    double v2norm = Math.sqrt(v2.x * v2.x + v2.y * v2.y + v2.z * v2.z);
    double amt = dot / (v1norm * v2norm);

    if (amt >= 1) return 0.0f;
    else if (amt <= -1) return (float) Math.PI;

    return (float) Math.acos(amt);
  }

  /**
   * Instance version of the method above.
   */
  public float angleBetween(Vector v) {
    return angleBetween(this, v);
  }

  /**
   * Return a float array representation of the Vector.
   *
   * @return A float array representation of the Vector.
   */
  public float[] array() {
    float[] array = new float[3];
    array[0] = this.x;
    array[1] = this.y;
    array[2] = this.z;
    return array;
  }

  /**
   * Compares this Vector to another one.
   *
   * @param v The Vector to compare to.
   * @return True if all components match, false otherwise.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == this) return true;
    if (!(obj instanceof Vector)) return false;
    Vector v = (Vector) obj;
    return this.x == v.x && this.y == v.y && this.z == v.z;
  }

  /**
   * Returns a string representation of this Vector.
   * Each component is separated by commas, and the string is enclosed in brackets "[]".
   *
   * @return A string representation of the Vector.
   */
  @Override
  public String toString() {
    return "[" + this.x + ", " + this.y + ", " + this.z + "]";
  }
}