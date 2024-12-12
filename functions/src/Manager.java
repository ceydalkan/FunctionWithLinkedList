public class Manager {
    public static void main(String[] args) {
        LinkedList function1 = new LinkedList();
        function1.generate(7);
        System.out.print("Function 1: ");
        function1.print();
        System.out.print("/////////////////// \n Function 1's 1st derivative: ");
        function1.nthPartialDerivative(1).print();
        System.out.print("/////////////////// \n Function 1's 2nd derivative: ");
        function1.nthPartialDerivative(2).print();

        LinkedList function2 = new LinkedList();
        function2.generate(7);
        System.out.print("///////////////// \n Function 2: ");
        function2.print();

        LinkedList function3 = sumFunctions(function1, function2);
        System.out.print("///////////////// \n Function 1 + Function 2: ");
        function3.print();
    }

    public static LinkedList sumFunctions(LinkedList f1, LinkedList f2) {
        LinkedList resultFunction = new LinkedList();
        Node current1 = f1.head;
        Node current2 = f2.head;

        while (current1 != null || current2 != null) {
            if (current1 == null) {
                resultFunction.insertWithParameters((int) current2.getData1(), (int) current2.getData2(), (int) current2.getData3());
                current2 = current2.getLink();

            } else if (current2 == null) {
                resultFunction.insertWithParameters((int) current1.getData1(), (int) current1.getData2(), (int) current1.getData3());
                current1 = current1.getLink();

            } else if (((int) current1.getData2() < (int) current2.getData2()) || 
            ((int) current1.getData2() == (int) current2.getData2() && (int) current1.getData3() < (int) current2.getData3())) {
                resultFunction.insertWithParameters((int) current1.getData1(), (int) current1.getData2(), (int) current1.getData3());
                current1 = current1.getLink();

            } else if (((int) current1.getData2() > (int) current1.getData2()) || 
            ((int) current1.getData2() == (int) current2.getData2() && (int) current1.getData3() > (int) current2.getData3())) {
                resultFunction.insertWithParameters((int) current2.getData1(), (int) current2.getData2(), (int) current2.getData3());
                current2 = current2.getLink();

            } else {
                resultFunction.insertWithParameters(((int) current1.getData1() + (int) current2.getData1()), (int) current1.getData2(), (int) current1.getData3());
                current1 = current1.getLink();
                current2 = current2.getLink();
            }
        }
        return resultFunction;
    }

    public static boolean isEqual(Node n1, Node n2){
        if(n1 != null && n2 != null)
            return n1.getData2() == n2.getData2() && n1.getData3() == n2.getData3();
        return false;
    }
}
