import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar{

    static final int ROWS = 16;
    static final int COLS = 16;
    public static  int GOAL_ROW = 13;
    public static  int GOAL_COL = 5;



    public static Node aStar(Sketch s){
        PriorityQueue<Node> openList = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                double result = o1.getF()-o2.getF();
                if(result == 0){
                    return (int) (o1.getH()-o2.getH());
                }
                return  (int)result;
            }
        });
        openList.add(new Node(0,0,0,0,0, null));
        ArrayList<Node> closedList = new ArrayList();

        while(!openList.isEmpty()){
            Node q = openList.remove();
            s.fill(255,255,0);
            q.draw(s);

            ArrayList<Node> succesors = q.getSuccesors();
            for(Node n: succesors){

                    if (n.getCol() == GOAL_COL && n.getRow() == GOAL_ROW)
                        return n;
                    n.setG(q.getG() + 1);
                    n.setH(heuristics(n));
                    n.setF();
                    if (!skipable(openList, n) && !skipable(closedList, n)) {
                        s.fill(255, 255, 0);
                        n.draw(s);
                        openList.add(n);
                    }
            }
            closedList.add(q);


        }
        return null;
    }


    private static double heuristics(Node current){
        return Math.abs(current.getRow()-GOAL_ROW)+Math.abs(current.getCol()-GOAL_COL);
    }
    private static boolean skipable(Collection<Node> list, Node current){
        for(Node n:list){
            if(n.getRow() == current.getRow() && n.getCol() == current.getCol() && n.getF() < current.getF())
                return true;
        }
        return false;
    }
    public static void reconstructPath(Node n, Sketch s){
        while(n != null){
            s.fill(0,255,0);
            n.draw(s);
            n = n.getParent();
        }

    }



}
