package streams;
import java.util.*;
import java.util.stream.Collectors;

public class CollectorsUse{

    public static void main(String[] args) {
        List<String> data= Arrays.asList("Jack","Oggy","Dee","Joey");
        System.out.println(data.stream().map(x->x.toUpperCase()).toList());

        System.out.println(data.stream()
                .map(x->x+"🚀")
                .collect(Collectors.toCollection(()->new ArrayList<>())));

        System.out.println(data.stream()
                .map(String::toUpperCase)
                .collect(Collectors.joining(" ")));

        List<Integer> intData=Arrays.asList(1,2,3,4);
        IntSummaryStatistics stats= intData.stream().collect(Collectors.summarizingInt(x->x));
        System.out.println(stats.getMax());
        System.out.println(stats.getMin());
        System.out.println(stats.getSum());
        System.out.println(stats.getAverage());
        System.out.println(stats.getCount());

        System.out.println(data.stream()
                .collect(Collectors.groupingBy(x->x.length()
                        ,Collectors.counting())));

        System.out.println(data.stream().collect((Collectors.partitioningBy(x->x.length()>3))));

        System.out.println(data.stream().collect(Collectors.mapping  (x->x.toUpperCase(),Collectors.toList())));

        List<String> words=Arrays.asList("apple","banana","apple","orange","banana");

        System.out.println(words.stream().collect(Collectors.toMap(x->x,y->y.length(),(x,y)->x+y-y)));
        words.stream().collect(Collectors.toMap(k->k,x->1,(x,y)->x+y));

    }

}