import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

/**
 * This programs uses backtracking/DFS to fill a soduku board with the duplicating numbers in rows
 * or columns and no zeros
 *
 * @author cjl (Chase Lewis)
 */
public class PuzzleConfig implements Configuration {

    /**
     * integer torepresent the current row of the constructor
     */
    private int currRow;

    /**
     * integer representing the current column of the constructor
     *
     */
    private int currCol;


    /**
     * 2d array represent the soduku board
     */
    private int [][] board;


    /**
     * constructor that takes in file and creates empty sudoku board
     *
     * @param filename the name of the file passed in
     * @throws IOException if filename isn't valid
     */
    public PuzzleConfig(String filename) throws IOException {
        this.currRow = 0;
        this.currCol = -1;
        FileReader fr = new FileReader(filename);
        BufferedReader br = new BufferedReader(fr);
        this.board = new int[9][9];
        String line;
        int j = 0;
        while ((line = br.readLine())!= null ){
            String grid[] = line.split(" ");
            for (int i = 0; i < 9; i++){
                if (grid[i].equals(".")){
                    board[j][i] = 0;
                }
                else{
                    board[j][i] = Integer.parseInt(grid[i]);
                }
            }
            j++;
        }



    }

    /**
     * copy of the original constructor's board
     *
     * @param config the original board is passed in
     */
    public PuzzleConfig(PuzzleConfig config){
        this.currCol = config.currCol;
        this.currRow = config.currRow;
        this.board = new int[9][9];
        for (int j = 0; j < 9; j++){
            for (int i = 0; i < 9; i++){
                this.board[j][i] = config.board[j][i];
            }
        }
    }


    /**
     * Will print out the PuzzleConfig
     *
     * @return a string of the puzzle config board
     */
    public String toString() {
        String puzzle = "";
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                puzzle += " " + Integer.toString(this.board[j][i]);
            }

            puzzle += "\n";
        }
        return puzzle;
    }

    /**
     * Get the collection of successors from the current one.
     *
     * @return All successors, valid and invalid
     */
    @Override
    public Collection<Configuration> getSuccessors() {
        Collection<Configuration> lst = new ArrayList<>();

        for (int i = 1; i <= 9; i++){
            PuzzleConfig copy = new PuzzleConfig(this);
            copy.currCol++;
            if (copy.currCol >= 9){
                copy.currCol = 0;
                copy.currRow++;
                if (copy.currRow >= 9){
                    return lst;
                }
            }
            if (copy.board[copy.currRow][copy.currCol] != 0){
                lst.add(copy);
                return lst;
            }

            else {
                copy.board[copy.currRow][copy.currCol] = i;
                lst.add(copy);
            }


        }
        return lst;
    }

    /**
     * Is the current configuration valid or not?
     *
     * @return true if valid; false otherwise
     */
    @Override
    public boolean isValid() {

        for (int j = 0; j < 9; j++){
            ArrayList<Integer> empty = new ArrayList<>();
            for (int i = 0; i < 9; i++){
                if (this.board[j][i] == 0){
                    continue;
                }
                if (empty.contains(this.board[j][i])){
                    return false;
                }
                else{
                    empty.add(this.board[j][i]);
                }
            }
        }
        for (int i = 0; i < 9; i++){
            ArrayList<Integer> empty = new ArrayList<>();
            for (int j = 0; j < 9; j++){
                if (this.board[j][i] == 0){
                    continue;
                }
                if (empty.contains(this.board[j][i])){
                    return false;
                }
                else{
                    empty.add(this.board[j][i]);
                }
            }
        }


        return true;
    }

    /**
     * Is the current configuration a goal?
     *
     * @return true if goal; false otherwise
     */
    @Override
    public boolean isGoal() {
        for (int j = 0; j < 9; j++){
            ArrayList<Integer> empty = new ArrayList<>();
            for (int i = 0; i < 9; i++){
                if (this.board[j][i] == 0){
                    return false;
                }
                else{
                    continue;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        String filename = args[0];
        PuzzleConfig config = new PuzzleConfig(filename);
        System.out.println(config.toString());
        Backtracker bt = new Backtracker(false);
        Optional<Configuration> sol = bt.solve(config);

        // look at the result
        if (sol.isPresent()) {
            System.out.println("Solution: " + sol.get());
        } else {
            System.out.println("No solution!");
        }
    }
}
