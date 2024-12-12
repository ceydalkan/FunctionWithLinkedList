public class Node {
    Object data1;
    Object data2;
    Object data3;
    Node link;

    public Node(Object data1, Object data2, Object data3, Node link) {
        this.data1 = data1;
        this.data2 = data2;
        this.data3 = data3;
        this.link = link;
    }

    public Node(Object data1, Object data2, Node link) {
        this.data1 = data1;
        this.data2 = data2;
        this.link = link;
    }

    public void setData1(Object data1) {
        this.data1 = data1;
    }

    public void setExponentX(Object data2) {
        this.data2 = data2;
    }

    public void setExponentY(Object data3) {
        this.data3 = data3;
    }

    public void setLink(Node n) {
        link = n;
    }

    public Object getData1() {
        return data1;
    }

    public Object getData2() {
        return data2;
    }

    public Object getData3() {
        return data3;
    }

    public Node getLink() {
        return link;
    }
}
