package pt.up.fe.ldts.example5;

public class West extends TurtleState{

    public West(Turtle turtle){
        this.turtle = turtle;
    }

    @Override
    public void moveForward(){
        turtle.setColumn(turtle.getColumn()-1);
    }

    @Override
    public void rotateLeft(){
        turtle.setDirection(new South(turtle));
    }

    @Override
    public void rotateRight(){
        turtle.setDirection(new North(turtle));
    }
}