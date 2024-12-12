public class Manager {
    public static void main(String[] args) {
        linkedList function1 = new linkedList();
        function1.generate(7);
        System.out.print("Function 1: ");
        function1.print();
        System.out.print("/////////////////// \n Function 1's 1st derivative: ");
        function1.nthPartialDerivative(1).print();
        System.out.print("/////////////////// \n Function 1's 2nd derivative: ");
        function1.nthPartialDerivative(2).print();

        linkedList function2 = new linkedList();
        function2.generate(7);
        System.out.print("///////////////// \n Function 2: ");
        function2.print();

        linkedList function3 = sumFunctions(function1, function2);
        System.out.print("///////////////// \n Function 1 + Function 2: ");
        function3.print();
    }

    public static linkedList sumFunctions(linkedList f1, linkedList f2){
        linkedList resultFunction = new linkedList();
        Node current1 = f1.head;
        Node current2 = f2.head;

        while(current1 != null || current2 != null){
            if(current1 == null){
                resultFunction.insertWithParameters(current2.getCoefficient(), current2.getExponentX(), current2.getExponentY());
                current2 = current2.getLink();
            }

            else if(current2 == null){
                resultFunction.insertWithParameters(current1.getCoefficient(), current1.getExponentX(), current1.getExponentY());
                current1 = current1.getLink();
            }


            else if(current1.getExponentX() < current2.getExponentX() || 
                current1.getExponentX() == current2.getExponentX() && current1.getExponentY() < current2.getExponentY()){

                resultFunction.insertWithParameters(current1.getCoefficient(), current1.getExponentX(), current1.getExponentY());
                current1 = current1.getLink();
            }

            else if(current1.getExponentX() > current1.getExponentX() ||
                current1.getExponentX() == current2.getExponentX() && current1.getExponentY() > current2.getExponentY()){

                resultFunction.insertWithParameters(current2.getCoefficient(), current2.getExponentX(), current2.getExponentY());
                current2 = current2.getLink();
            }

            else{
                resultFunction.insertWithParameters((current1.getCoefficient() + current2.getCoefficient()), current1.getExponentX(), current1.getExponentY());
                current1 = current1.getLink();
                current2 = current2.getLink();
            }
        }

        return resultFunction;
    }

    public static boolean isEqual(Node n1, Node n2){
        if(n1 != null && n2 != null)
            return n1.getExponentX() == n2.getExponentX() && n1.getExponentY() == n2.getExponentY();
        return false;
    }
}
