import processing.core.PApplet;

public class Sketch extends PApplet{
    public static Sketch s;
    private Node end;
    public void draw(){
        background(255);
        for(int row=1;row<=AStar.ROWS;row++){
            for(int col=1;col<=AStar.COLS;col++){

                noStroke();
                fill(0);
                ellipse(col*25, row*25, 5, 5);
            }
        }
        AStar.reconstructPath(AStar.aStar(this), this);

    }

    public void settings(){
        size(425, 425);
        s = this;

    }
    public void setup(){

    }
    public static void main(String[] args){

       PApplet.main("Sketch");

    }
    public void mouseClicked(){

        AStar.GOAL_COL  = Math.floorDiv(mouseX, 25);
        AStar.GOAL_ROW = Math.floorDiv(mouseY, 25);
    }
}
