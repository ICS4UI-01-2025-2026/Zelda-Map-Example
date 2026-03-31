
public class Map {
    private Scene[][] scenes;

    public Map(int numRows, int numCols){
        this.scenes = new Scene[numRows][numCols];
    }

    public void addScene(int row, int col, Scene sceneToAdd){
        this.scenes[row][col] = sceneToAdd;
    }

    public Scene getScene(int row, int col){
        return this.scenes[row][col];
    }

}
