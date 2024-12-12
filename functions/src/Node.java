import java.util.Random;

public class Node {
    int coefficient;
    int exponent_x;
    int exponent_y;
    Node link;
    Random r = new Random();

    public Node() {
        coefficient = r.nextInt(0, 6);
        exponent_x = r.nextInt(0, 6);
        exponent_y = r.nextInt(0, 6);
        link = null;
    }

    public Node(int coefficient, int exponent_x, int exponent_y, Node link){
        this.coefficient = coefficient;
        this.exponent_x = exponent_x;
        this.exponent_y = exponent_y;
        this.link = link;
    }

    public Node(int coefficient, int exponent_x, Node link){
        this.coefficient = coefficient;
        this.exponent_x = exponent_x;
        this.link = link;
    }


    public void setCoefficient(int coefficient){
        this.coefficient = coefficient;
    }

    public void setExponentX(int exponent_x){
        this.exponent_x = exponent_x;
    }

    public void setExponentY(int exponent_y){
        this.exponent_y = exponent_y;
    }

    public void setLink(Node n){
        link = n;
    }

    public int getCoefficient(){
        return coefficient;
    }

    public int getExponentX(){
        return exponent_x;
    }

    public int getExponentY(){
        return exponent_y;
    }

    public Node getLink(){
        return link;
    }
}
