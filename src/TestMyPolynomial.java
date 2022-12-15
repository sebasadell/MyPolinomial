public class TestMyPolynomial {
    public static void main(String[] argv){
        MyPolynomial p1 = new MyPolynomial(1.1, 2.2, 3.3, 4.4, 5.5);
        MyPolynomial p2 = new MyPolynomial("src/poly.txt");
        MyPolynomial p3;
        MyPolynomial p4;

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.getDegree());
        System.out.println(p2.evaluate(5));
        p3 = p1.add(p2);
        System.out.println(p3.toString());
        p4 = p1.multiply(p2);
        System.out.println(p4.toString());
    }
}