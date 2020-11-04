import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Chase Lewis
 */
public class QuickestTime extends Graph{

    /**
     * a make to make nodes with their neighbors with
     * thier integer weights
     */
    Map<String, Node> QT = new TreeMap<>();


    /**
     * this constructor takes in a file and constructs a graph
     * from it
     *
     * @param filename a string of the filename.
     */
    public QuickestTime(String filename){

        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine())!= null){
                String grid[] = line.split(", ");
                Node node = new Node(grid[0]);
                Node neighbor = new Node(grid[1]);

                if (isInGraph(QT,grid[0])){
                    Node temp = QT.get(grid[0]);
                    temp.addNeighbor(neighbor,Integer.parseInt(grid[2]));
                }
                if (!(isInGraph(QT,grid[0])) ){
                    QT.put(grid[0],node);
                    node.addNeighbor(neighbor,Integer.parseInt(grid[2]));
                }

                if (!(isInGraph(QT,grid[1]))){
                    QT.put(grid[1],neighbor);

                }
                if (isInGraph(QT,grid[1])){

                }


            }
        } catch (IOException e) {
            System.out.println("Hey, the file inputted wasn't found. Try again please. :)");
        }


    }

    /**
     * this method will return the graph constructed.
     *
     * @return a graph from the constructor
     */
    public Map<String, Node> getGraph(){
        return this.QT;
    }

    /**
     * this will print the graph with the nodes and thier directed
     * edges/neighbors
     *
     * @return a string of the of the graph's nodes and thier
     * neighbors with the integer weight
     */
    public String toString(){
        String empty = "";
        Map<String, Node> string = this.QT;
        Iterator it = string.entrySet().iterator();
        for (Node value : string.values()) {
            empty += value.toString();
            empty += "\n";


        }
    return empty;
    }

    /**
     * obtain the file name from the command line (args[0]); not user input.
     * obtain the start from the command line (args[1]); not user input.
     * obtain the end from the command line (args[2]); not user input.
     * It will construct and instance of this class using that file name.
     * Print the graph.
     * Then preform Dijkstra’s on the graph to find the shortest path from the start
     * to end.
     *
     * @param args passed in arguments
     */
    public static void main(String[] args) {
        String file = args[0];
        String start = args[1];
        String end = args[2];
        QuickestTime quick = new QuickestTime(file);
        System.out.print(quick.toString());
        System.out.print("\n");
        displayShortestPath(quick.QT,start,end);
    }

}
