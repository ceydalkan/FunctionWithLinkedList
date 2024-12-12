public class linkedList {
    protected Node head;
    protected Node tail;

    public linkedList() {
        head = null;
        tail = null;
    }

    public void generate(int numOfterms){
        while(size() < numOfterms){
            Node newNode = new Node();
            insertNode(newNode);
        }
        

    }

    public void insertWithParameters(int coefficient, int exponent_x, int exponent_y){
        Node previous;
        Node current;
        Node newNode = new Node(coefficient, exponent_x, exponent_y, null);

        if(head==null){
            head = newNode;
            tail = newNode;
        }

        else{
            previous = null;
            current = head;

            while(current != null){
                if(current.getExponentX() > newNode.getExponentX() | 
                (current.getExponentX() == newNode.getExponentX() && current.getExponentY() > newNode.getExponentY())){

                    if(previous == null){
                        newNode.setLink(head);
                        head = newNode;
                        return;
                    }

                    previous.setLink(newNode);
                    newNode.setLink(current);
                    return;
                }

                else if(isEqual(current, newNode))
                    return;
                
                
                previous = current;
                current =current.getLink();
            }

            if(previous == tail){
                tail.setLink(newNode);
                tail = newNode;
            }
        }
    }
 
    public void insertNode(Node newNode){
        Node previous;
        Node current;

        if(head==null){
            head = newNode;
            tail = newNode;
        }

        else{
            previous = null;
            current = head;

            while(current != null){
                if(current.getExponentX() > newNode.getExponentX() ||
                (current.getExponentX() == newNode.getExponentX() && current.getExponentY() > newNode.getExponentY())){

                    if(previous == null){
                        newNode.setLink(head);
                        head = newNode;
                        return;
                    }

                    previous.setLink(newNode);
                    newNode.setLink(current);
                    return;
                }

                else if(isEqual(current, newNode) && current.getExponentY() != 0 && newNode.getExponentY() != 0)
                    return;
                
                else{
                    previous = current;
                    current = current.getLink();
                }
            }

            if(previous == tail){
                tail.setLink(newNode);
                tail = newNode;
            }
        }
    }
    
    public void print(){
        Node current = head;

        while(current != null){
            System.out.print(String.valueOf(current.getCoefficient()) + "x^" + String.valueOf(current.getExponentX()) 
            + "y^" + String.valueOf(current.getExponentY()));
            
           if(current.getLink() != null)
                System.out.print(" + ");
        
            current = current.getLink();
        }

        System.out.println("\n");
    }

    public static boolean isEqual(Node n1, Node n2){
        if(n1 != null && n2 != null)
            return n1.getExponentX() == n2.getExponentX() && n1.getExponentY() == n2.getExponentY();
        return false;
    }
    
    public int size(){
        Node current = head;
        int size = 0;

        while(current != null){
            size++;
            current = current.getLink();
        }

        return size;
    }

    public linkedList nthPartialDerivative(int count){
        if(count < 1 || count > 4)
            return null;
        
        else{
            linkedList resultFunction = new linkedList();
            Node current = head;

            if(current == null){
                return null;
            }

            for(int i = count; i >= 1; i--){
                while(i == count && current != null){
                    Node n = new Node(current.getCoefficient() * current.getExponentX(), current.getExponentX() - 1, null);
                    resultFunction.insertNode(n);
    
                    current = current.getLink();
                }

                
                if(i != count){
                    Node currentResult = resultFunction.head;
                    
                    if(currentResult == null){
                        return null;
                    }
                    
                    while(currentResult != null){
                        currentResult.setCoefficient(currentResult.getCoefficient() * currentResult.getExponentX());
                        currentResult.setExponentX(currentResult.getExponentX() - 1);
                        
                        currentResult = currentResult.getLink();
                    }

                    if(i == 1){
                        currentResult = resultFunction.head;

                        while(currentResult != null && currentResult.getLink() != null){
                            if(currentResult.getLink() == tail)
                                tail = currentResult;
                            while(currentResult.getLink() != null && currentResult.getExponentX() == currentResult.getLink().getExponentX()){
                                currentResult.setCoefficient(currentResult.getCoefficient() + currentResult.getLink().getCoefficient());
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
