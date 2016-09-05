package euler;

public class P001
{
    public static void main( String[] args )
    {
        P001 solver = new P001();
        solver.solve(1000);
    }

    private void solve(long n) {
        System.out.print(subSum(n, 3) + subSum(n, 5) - subSum(n, 15));
    }

    private long subSum(long n, long k) {
        return k*(n/k + 1)*(n/k)/2 + ((n % k == 0) ? n/k : 0);
    }


}
