import java.util.ArrayList;

class Node {
    private double f;
    private double g;
    private double h;
    private float radius = 5;
    private float offset = 25;
    private int row;
    private int col;
    private boolean blocked;
    private Node parent;
    private final int[][] blockedNodes = {
            {10, 4},
            {7, 14},
            {3, 3},
            {3, 4},
            {3, 5},
            {4, 3}
    };


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
        if(row+1 < AStar.ROWS) {
            succesors.add(new Node(0, 0, 0, row + 1, col, this));
        }
        if(col+1 < AStar.COLS)
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

    public Node getParent() {
        return parent;
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

    public void draw(Sketch s){
        s.ellipse((col+1)*offset,(row+1)*offset,5,5);
    }
    public boolean isBlocked() {
        for(int i = 0;i<AStar.ROWS;i++){
            for(int j=0;j<AStar.COLS;j++){
                for(int k=0;k<blockedNodes.length;k++){
                    if(row == blockedNodes[k][0] && col == blockedNodes[k][1])
                        return true;
                }
            }
        }
        return false;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
