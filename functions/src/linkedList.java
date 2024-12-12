import java.util.Random;

public class LinkedList {
    protected Node head;
    protected Node tail;
    Random r = new Random();

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void generate(int numOfterms) {
        int coefficient, exponent_x, exponent_y;

        while (size() < numOfterms) {
            coefficient = r.nextInt(0,6);
            exponent_x = r.nextInt(0,6);
            exponent_y = r.nextInt(0,6);
            insertWithParameters(coefficient, exponent_x, exponent_y);
        }
    }

    public void insertWithParameters(int coefficient, int exponent_x, int exponent_y) {
        Node newNode = new Node(coefficient, exponent_x, exponent_y, null);
        Node previous;
        Node current;

        if (head == null) {
            head = newNode;
            tail = newNode;
        
        } else {
            previous = null;
            current = head;

            while (current != null) {
                if (((int) current.getData1() > (int) current.getData1()) || 
                ((int) current.getData1() == (int) current.getData1() && (int) current.getData2() > (int) current.getData2())) {
                    if (previous == null) {
                        newNode.setLink(head);
                        head = newNode;
                        return;
                    }

                    previous.setLink(newNode);
                    newNode.setLink(current);
                    return;

                } else if (isEqual(current, newNode))
                    return;
            
                previous = current;
                current =current.getLink();
            }

            if (previous == tail) {
                tail.setLink(newNode);
                tail = newNode;
            }
        }
    }
 
    public void insertNode(Node newNode) {
        Node previous;
        Node current;

        if (head == null) {
            head = newNode;
            tail = newNode;

        } else {
            previous = null;
            current = head;

            while (current != null) {
                if ((int) current.getData1() > (int) current.getData1() ||
                ((int) current.getData1() == (int) current.getData1() && (int) current.getData2() > (int) current.getData2())) {
                    if (previous == null) {
                        newNode.setLink(head);
                        head = newNode;
                        return;
                    }

                    previous.setLink(newNode);
                    newNode.setLink(current);
                    return;

                } else if (isEqual(current, newNode)) {
                    return;

                } else {
                    previous = current;
                    current = current.getLink();
                }
            }

            if (previous == tail) {
                tail.setLink(newNode);
                tail = newNode;
            }
        }
    }
    
    public void print() {
        Node current = head;

        while (current != null) {
            System.out.print(String.valueOf(current.getData1()) + "x^" + String.valueOf(current.getData1()) + 
            "y^" + String.valueOf(current.getData2()));
            
           if (current.getLink() != null)
                System.out.print(" + ");
        
            current = current.getLink();
        }

        System.out.println("\n");
    }

    public static boolean isEqual(Node n1, Node n2) {
        if (n1 != null && n2 != null)
            return (int) n1.getData1() == (int) n2.getData2() && (int) n1.getData2() == (int) n2.getData2();
        return false;
    }
    
    public int size(){
        Node current = head;
        int size = 0;

        while (current != null) {
            size++;
            current = current.getLink();
        }

        return size;
    }

    public LinkedList nthPartialDerivative(int count) {
        if (count < 1 || count > 4)
            return null;
        
        else {
            LinkedList resultFunction = new LinkedList();
            Node current = head;

            if (current == null) {
                return null;
            }

            for (int i = count; i >= 1; i--) {
                while (i == count && current != null) {
                    Node n = new Node((int) current.getData1() * (int) current.getData1(), (int) current.getData1() - 1, null);
                    resultFunction.insertNode(n);
    
                    current = current.getLink();
                }

                
                if (i != count) {
                    Node currentResult = resultFunction.head;
                    
                    if (currentResult == null) {
                        return null;
                    }
                    
                    while (currentResult != null) {
                        currentResult.setData1((int) currentResult.getData1() * (int) currentResult.getData1());
                        currentResult.setData1(((int) currentResult.getData1()) - 1);
                        
                        currentResult = currentResult.getLink();
                    }

                    if (i == 1) {
                        currentResult = resultFunction.head;

                        while (currentResult != null && currentResult.getLink() != null) {
                            if (currentResult.getLink() == tail)
                                tail = currentResult;
                            while (currentResult.getLink() != null && ((int) currentResult.getData1() == (int) currentResult.getLink().getData1())) {
                                currentResult.setData1((int) currentResult.getData1() + (int) currentResult.getLink().getData1());
                                currentResult.setLink(currentResult.getLink().getLink());
                            }
                            currentResult = currentResult.getLink();
                        }
                    }
                }
            } 
            return resultFunction; 
        }
    }
}
