import java.util.*;

/**
 * LeetCode 735. Asteroid Collision
 * Positive values move right, negative values move left.
 * Simulate collisions: the smaller asteroid explodes; if equal, both explode.
 */
public class AsteroidCollision {

    public static int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (int asteroid : asteroids) {
            boolean alive = true;
            while (alive && asteroid < 0 && !stack.isEmpty() && stack.peek() > 0) {
                int top = stack.peek();
                if (top < -asteroid) {
                    // top asteroid explodes, current keeps moving
                    stack.pop();
                } else if (top == -asteroid) {
                    // both explode
                    stack.pop();
                    alive = false;
                } else {
                    // current asteroid explodes
                    alive = false;
                }
            }
            if (alive) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        System.out.println("Result: " + Arrays.toString(asteroidCollision(asteroids)));

        int[] asteroids2 = {8, -8};
        System.out.println("Result: " + Arrays.toString(asteroidCollision(asteroids2)));

        int[] asteroids3 = {10, 2, -5};
        System.out.println("Result: " + Arrays.toString(asteroidCollision(asteroids3)));
    }
}
