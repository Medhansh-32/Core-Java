package streams;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class ParallelStreams {

    public static long factorial(int n){
        if(n==0) return 1;
        else return n*factorial(n-1);
    }


    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<Integer> list= Stream.iterate(1, x->x+1).limit(10000).toList();
        List<Long> factList=list.stream().map(x->factorial(x)).toList();
        long endTime = System.currentTimeMillis();

        System.out.println("Normal Stream :"+(endTime-startTime));

        startTime = System.currentTimeMillis();
        List<Integer> list1= Stream.iterate(1, x->x+1).limit(10000).toList();
        List<Long> factList1=list.parallelStream().map(x->factorial(x)).toList();
        endTime = System.currentTimeMillis();

        System.out.println("Parallel Stream :"+(endTime-startTime));

        List<Integer> list2= Arrays.asList(1,2,3,4,5);
        AtomicInteger sum=new AtomicInteger(0);
        List<Integer> coumulativeSum=list2.parallelStream()
                .map(x->sum.addAndGet(x))
                .toList();
        System.out.println(coumulativeSum);


    }

}