import processing.core.PApplet;

import java.util.HashSet;

public class Sketch extends PApplet{
    public static Sketch s;
    public static HashSet<Integer> blockedNodes = new HashSet<>();

    public void draw(){
        background(255);
        for(int col=1;col<=AStar.ROWS;col++){
            for(int row=1;row<=AStar.COLS;row++){
                fill(0);
                if(blockedNodes.contains(coordinate(col-1, row-1)))
                    fill(255,0,0);
                noStroke();

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
        blockedNodes.add(coordinate(4,3));
        blockedNodes.add(coordinate(3,3));
        blockedNodes.add(coordinate(5,3));
        blockedNodes.add(coordinate(4,3));
        blockedNodes.add(coordinate(3,4));
        blockedNodes.add(coordinate(3,5));
        blockedNodes.add(coordinate(3,6));
        blockedNodes.add(coordinate(3,7));
    }
    public static void main(String[] args){

       PApplet.main("Sketch");

    }
    public void mouseClicked(){

        AStar.GOAL_COL  = Math.floorDiv(mouseX, 25);
        AStar.GOAL_ROW = Math.floorDiv(mouseY, 25);
    }
    public static int coordinate(int x, int y){
        return x+(y*AStar.COLS);
    }
}
