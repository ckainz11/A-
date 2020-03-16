package AStar;

import javax.print.DocFlavor;
import java.util.ArrayList;

public class AStar {

    private static final int ROWS = 8;
    private static final int COLS = 8;
    private static final int GOAL_ROW = 4;
    private static final int GOAL_COL = 1;

    public static void main(String[] args){
        if(aStar() != null)
            System.out.println("Finished");
        else
            System.out.println("No solution");




    }

    private static Node aStar(){
        ArrayList<Node> openList = new ArrayList();
        openList.add(new Node(0,0,0,0,0, null));
        ArrayList<Node> closedList = new ArrayList();

        while(!openList.isEmpty()){
            Node q = findNodeWithLowestF(openList);
            openList.remove(q);
            ArrayList<Node> succesors = q.getSuccesors();
            for(Node n: succesors){
                if(n.getCol() == GOAL_COL && n.getRow() == GOAL_ROW)
                    return true;
                n.setG(q.getG()+1);
                n.setH(heuristics(n));
                n.setF();
                if(!skipable(openList, n)&&!skipable(closedList, n)){
                    openList.add(n);
                }
            }
            closedList.add(q);


        }
        return null;
    }

    private static Node findNodeWithLowestF(ArrayList<Node> openList){
        Node lowest = null;
        for(int i=0;i<openList.size();i++){
            if(lowest == null){
                lowest = openList.get(0);
            }
            else if(openList.get(i).getF() < lowest.getF()){
                lowest = openList.get(i);
            }
        }
        return lowest;
    }
    private static double heuristics(Node current){
        return Math.abs(current.getRow()-GOAL_ROW)+Math.abs(current.getCol()-GOAL_COL);
    }
    private static boolean skipable(ArrayList<Node> list, Node current){
        for(Node n:list){
            if(n.getRow() == current.getRow() && n.getCol() == current.getCol() && n.getF() < current.getF())
                return true;
        }
        return false;
    }

}
