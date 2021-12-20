package pt.up.fe.ldts.example5;

public class East extends TurtleState{

    public East(Turtle turtle){
        this.turtle = turtle;
    }

    @Override
    public void moveForward(){
        turtle.setColumn(turtle.getColumn()+1);
    }

    @Override
    public void rotateLeft(){
        turtle.setDirection(new North(turtle));
    }

    @Override
    public void rotateRight(){
        turtle.setDirection(new South(turtle));
    }
}