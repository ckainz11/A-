package AStar;

import java.util.ArrayList;

class Node {
    private double f;
    private double g;
    private double h;
    private int row;
    private int col;
    private Node parent;



    public Node(double f, double g, double h, int row, int col, Node parent){
        this.f = f;
        this.g = g;
        this.h = h;
        this.row = row;
        this.col = col;
        this.parent = parent;
    }
    public double getF(){
        return f;
    }
    public ArrayList<Node> getSuccesors(){
        ArrayList<Node> succesors = new ArrayList<Node>();
        if(row+1 < 8)
            succesors.add(new Node(0,0,0, row+1, col, this));
        if(col+1 < 8)
            succesors.add(new Node(0,0,0, row, col+1, this));
        if(row-1 >= 0)
            succesors.add(new Node(0,0,0, row-1, col, this));
        if(col-1 >= 0)
            succesors.add(new Node(0,0,0,row,col-1, this));
        return succesors;
    }

    public double getG() {
        return g;
    }

    public double getH() {
        return h;
    }

    public int getRow() {
        return row;
    }

    public void setF() {
        this.f = this.g+this.h;
    }

    public void setG(double g) {
        this.g = g;
    }

    public void setH(double h) {
        this.h = h;
    }

    public int getCol() {
        return col;
    }
}
