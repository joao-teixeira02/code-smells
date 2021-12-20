package pt.up.fe.ldts.example5;

public abstract class TurtleState {

    protected Turtle turtle;

    public void setTurtle(Turtle turtle){
        this.turtle = turtle;
    }

    public abstract void moveForward();
    public abstract void rotateLeft();
    public abstract void rotateRight();
}