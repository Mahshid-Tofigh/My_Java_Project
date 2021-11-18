public class Recursion {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        System.out.println(recursion.sum(6));
        System.out.println(recursion.factorial(4));
        System.out.println(recursion.powerOf10(2));
        System.out.println(recursion.powerOfN(2,4));
        System.out.println(recursion.bunnyEars(6));

    }

    public int sum(int n){
        if(n == 0)
            return 0;
        else return sum(n-1) + n;
    }
    public int factorial(int n){
        if(n <= 1)
            return 1;
        else return factorial(n-1) * n;
    }
    public int powerOf10(int n){
        if(n == 0)
            return 1;
        else return powerOf10(n-1) * 10;
    }
    public int powerOfN(int x, int p){
        if(p == 0)
            return 1;
        else return powerOfN(x, p-1) * x;
    }
    public int bunnyEars(int n){
        if(n == 0)
            return 0;
        else return bunnyEars(n-1) + 2;
    }


}
