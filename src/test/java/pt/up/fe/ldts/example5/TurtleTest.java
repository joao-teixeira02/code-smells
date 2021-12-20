package pt.up.fe.ldts.example5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TurtleTest {

    @Test
    public void testRotateLeft() {
        Turtle turtle = new Turtle(5, 5, new North(null));
        turtle.execute('L'); Assertions.assertTrue(turtle.getDirection() instanceof West);
        turtle.execute('L'); Assertions.assertTrue(turtle.getDirection() instanceof South);
        turtle.execute('L'); Assertions.assertTrue(turtle.getDirection() instanceof East);
        turtle.execute('L'); Assertions.assertTrue(turtle.getDirection() instanceof North);
        Assertions.assertEquals(5, turtle.getRow());
        Assertions.assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testRotateRight() {
        Turtle turtle = new Turtle(5, 5, new  North(null));
        turtle.execute('R'); Assertions.assertTrue(turtle.getDirection() instanceof East);
        turtle.execute('R'); Assertions.assertTrue(turtle.getDirection() instanceof South);
        turtle.execute('R'); Assertions.assertTrue(turtle.getDirection() instanceof West);
        turtle.execute('R'); Assertions.assertTrue(turtle.getDirection() instanceof North);
        Assertions.assertEquals(5, turtle.getRow());
        Assertions.assertEquals(5, turtle.getColumn());
    }

    @Test
    public void testForward() {
        Turtle turtleN = new Turtle(5, 5, new North(null));

        turtleN.execute('F');
        Assertions.assertEquals(4, turtleN.getRow());
        Assertions.assertEquals(5, turtleN.getColumn());

        Turtle turtleW = new Turtle(5, 5, new West(null));

        turtleW.execute('F');
        Assertions.assertEquals(5, turtleW.getRow());
        Assertions.assertEquals(4, turtleW.getColumn());

        Turtle turtleS = new Turtle(5, 5, new South(null));

        turtleS.execute('F');
        Assertions.assertEquals(6, turtleS.getRow());
        Assertions.assertEquals(5, turtleS.getColumn());

        Turtle turtleE = new Turtle(5, 5, new East(null));

        turtleE.execute('F');
        Assertions.assertEquals(5, turtleE.getRow());
        Assertions.assertEquals(6, turtleE.getColumn());
    }

}