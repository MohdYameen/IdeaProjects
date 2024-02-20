package ClassLPU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/*      ****************************************Theory*************************************************

Stream :
        * operates on object reference, it can't operate directly on primitive data types.
        DoubleStream, IntStream, LongStream...   (FloatStream is not available.)
        These stream all extend BaseStream and have capabilities similar to Stream except that they operate on primitive types.

Intermediate operations/methods : Java 8 Stream intermediate operations return another Stream which allows you to
                                  call multiple operations in the form of a query.
                                  * Partial result can be grabbed  from intermediate method
                                  * return Stream.
                                  * no final result until we use terminal methods.
                                  filter(), map(), flatMap(), distinct(), sorted(), peek(), limit(), skip()

2 types: Stateless and stateful.

Stateless operation : each operation  is processed independently of the others.

Stateful operation : the processing of elements may depends on aspects of the other elements.

Difference among them matter when parallel processing of a stream is desired.



Terminal methods : intermediate method of stream will not give any output, thus terminal methods are used.
                    forEach, toArray, reduce, collect, min,max,count,iterator,spliterator.


                    IntStream mystream = IntStream.range(1,11).skip(3)
 */


public class StreamDemo {

    public static void main(String ... args) {
        //just for study purpose.
        LongStream is = Arrays.stream(new long[]  {1,2,3,4});
        IntStream is2 = "abc".chars();

        Stream<Character> steamChar;
        String[] arr = {"wqert","sdfdg","afsdgf","fsdgf"};      //source of a stream
        Stream<String> str = Stream.of(arr); //using Stream.of, a stream is created on the source

        str.map(s -> s.toUpperCase()).forEach(System.out::println);

       /* str.filter(s -> s.startsWith("a")).forEach(System.out::println);      //*/

        ArrayList<String> arlist = new ArrayList<String>();
        arlist.add("APPlE");
        arlist.add("QWERTYUIOKJGF");
        arlist.add("QWERTYUIOKJGF");
        arlist.add("CWERTYUIOKJGF");
        arlist.add("CGF");
        Stream<String> str2 = arlist.stream();
        str2.map(s -> s.startsWith("C")).forEach(System.out::println);
        //str2.
        //str2.forEach(System.out::println);



    }
}
