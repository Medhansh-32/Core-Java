package streams;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Streams {

    public static void main(String[] args) {


        List<String> list= Arrays.asList("Medhansh","Krishang","Shivam","Anant","Ashwin","Ritish");



        System.out.println((list.stream().filter(x->x.contains("sh")).collect(Collectors.toList())));

        System.out.println(list.stream().map(String::toUpperCase).toList());

        System.out.println(list.stream().sorted((a,b)->b.length()-a.length()).toList());

        System.out.println(Stream.iterate(1,i->i+1).limit(11).count());

        System.out.println(list.stream().limit(1).toList());

        list.stream().forEach(x->System.out.println(x));

        list.stream().forEach(System.out::println);


        Optional<String> data=list.stream().reduce((x, y)->x+" "+y);
        data.ifPresentOrElse(n->System.out.println(data.get()),()->System.out.println("data is empty"));
        Arrays.asList(1,2,4).stream().reduce((x,y)->x+y).get();

        Boolean check=list.stream().anyMatch((x)->x.contains("ansh"));
        System.out.println(check);

        System.out.println(list.stream().map(x->x.toLowerCase()).toList().stream().filter(x->x.contains("sh")).count());

        List<String> tList= Arrays.asList("Anna","Bob","Charlie","David")
                .stream()
                .filter(x->x.length()>3)
                .toList();

        System.out.println(tList);

        List<Integer> numbers= Arrays.asList(5,2,9,1,6);
        System.out.println(numbers.stream().map(x->x*x).sorted().toList());

        System.out.println(numbers.stream().reduce((x,y)->x+y).get());

        String word="Hello World";
        System.out.println(word.chars().filter(x->x=='l').count());

        list.forEach(x->{
            System.out.println(x);
            long count=x.chars().filter(y->y=='n').count();
            System.out.println(count);
        });


    }
}