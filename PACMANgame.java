import java.util.Random;
import java.util.Scanner;

class Pacman{
    private int x;
    private int y;

    public Pacman(){
        this.x=0;
        this.y=0;
    }

    public Pacman(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void move(char direction,gameboard board){
        int newX=x;
        int newY=y;


        switch (direction) {
            case 's':
                newX++;
                break;

            case 'w':
                newX--;
                break;

            case 'd':
                newY++;
                break;

            case 'a':
                newY--;
                break;
                
                default:
                    break;
                }
                if(newX>=0 && newY>=0 && newX<10 && newY<10 && !board.isWall(newX,newY)){
                    x = newX;
                    y = newY;
                }
            }

    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }

}

class Ghost{
    private int x;
    private int y;

    public Ghost(){
        this.x=0;
        this.y=0;
    }

    public Ghost(int x,int y){
        this.x=x;
        this.y=y;

    }
    public void move(){
        Random r=new Random();
        int dir=r.nextInt(4);

        switch (dir) {
            case 0:
                x++;
                break;
            case 1:
                x--;
                break;
            case 2:
                y++;
                break;
            case 3:
                y--;
                break;
            default:
                break;
        }
        
        if(x<0){
            x=0;
        }
        if (y<0) {
            y=0;
        }
        if (x>9) {
            x=9;
        }
        if (y>9) {
            y=9;
        }
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

}
class Food{

    private int x;
    private int y;

    public Food(int x,int y){
        this.x=x;
        this.y=y;

    }
    public void reset(gameboard board){

        Random r=new Random();
        do{
        x=r.nextInt(10);
        y=r.nextInt(10);
        }while(board.isWall(x,y));
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}

class gameboard{
    char [][] grid={
        {'#','#','#','#','#','#','#','#','#','#'},
        {'#','.','.','.','.','.','.','.','.','#'},
        {'#','.','#','#','.','#','#','.','.','#'},
        {'#','.','.','#','.','.','#','.','.','#'},
        {'#','#','.','#','#','.','#','#','.','#'},
        {'#','.','.','.','.','.','.','#','.','#'},
        {'#','.','#','#','#','#','.','#','.','#'},
        {'#','.','.','.','.','#','.','.','.','#'},
        {'#','.','#','#','.','.','.','#','.','#'},
        {'#','#','#','#','#','#','#','#','#','#'}
    };


    int size=grid.length;

    public void display(Pacman p,Ghost g,Food f){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){

                if(i==p.getX() && j==p.getY()){
                    System.out.print("P ");
                }
                else if(i==g.getX() && j==g.getY()){
                    System.out.print("G ");
                }
                else if (i==f.getX() && j==f.getY()){
                    System.out.print("F ");
                }
                else{
                    System.out.print(grid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
    public boolean isWall(int x,int y){
        return grid[x][y]=='#';

    }

}


public class PACMANgame {

    public static void main(String[] args) {
        gameboard board=new gameboard();
        Pacman pacman=new Pacman(1,1);
        Ghost ghost=new Ghost(3,3);
        Food food=new Food(1, 2);

        Scanner sc=new Scanner(System.in);
        // boolean running=true;

            int lives=3;
            int score=0;

            while(lives>0){
                board.display(pacman, ghost, food);
            System.out.println("move pacman with (w/s/a/d):");
            char move=sc.next().charAt(0);

            pacman.move(move,board);
            ghost.move();

            if(pacman.getX()==food.getX() && pacman.getY()==food.getY()){
                score+=10;
                System.out.println("Pacman ate the food ");
                System.out.println("score: "+score);
                food.reset(board);
            }
            if(pacman.getX()==ghost.getX() && pacman.getY()==ghost.getY()){
                lives--;
                System.out.println("Lives: " + lives + "   Score: " + score);
                
                pacman=new Pacman(1,1);
                ghost=new Ghost(3,3);
               }
            if(lives==0){
                System.out.println("Game over zero lives left!");
                System.out.println("Final Score: " + score);
            }

            }

            sc.close();
        }
    }



