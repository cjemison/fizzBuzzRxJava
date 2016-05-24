import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import rx.Observable;

/**
 * Created by cjemison on 5/24/16.
 */
public class App {
  public static void main(String[] args) {

    final Predicate<Integer> fizzPredicate = (v) -> v % 3 == 0 && v > 0;
    final Predicate<Integer> buzzPredicate = (v) -> v % 5 == 0 && v > 0;
    final Predicate<Integer> fizzBuzzPredicate = (v) -> v % 15 == 0 && v > 0;
    Observable<Integer> o = Observable.from(IntStream.range(0, 1000000).boxed().collect(Collectors
          .toList())).flatMap(Observable::just);

    o.subscribe((c) -> {
      if (fizzPredicate.test(c)) {
        System.out.println(String.format("Fizz: %d", c));
      }

      if (buzzPredicate.test(c)) {
        System.out.println(String.format("Buzz: %d", c));
      }
      if (fizzBuzzPredicate.test(c)) {
        System.out.println(String.format("FizzBuz: %d", c));
      }
    });
  }
}
