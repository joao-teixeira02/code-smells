package pt.up.fe.ldts.example5;

public class South extends TurtleState{

    public South(Turtle turtle){
        this.turtle = turtle;
    }

    @Override
    public void moveForward(){
        turtle.setRow(turtle.getRow()+1);
    }

    @Override
    public void rotateLeft(){
        turtle.setDirection(new East(turtle));
    }

    @Override
    public void rotateRight(){
        turtle.setDirection(new West(turtle));
    }
}