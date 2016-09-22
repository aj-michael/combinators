package net.ajmichael.combinators;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class YTest {
  @Test
  public void testFactorial() {
    Function<Integer, Long> fact =
        new Y<Integer, Long>().apply(f -> n -> n == 0 ? 1 : n * f.apply(n - 1));
    assertEquals(120, (long) fact.apply(5));
  }

  @Test
  public void testFibonacci() {
    Function<Integer, Long> fib = new Y<Integer, Long>().apply(f -> n -> {
      if (n == 0) return 0L;
      if (n == 1) return 1L;
      return f.apply(n - 1) + f.apply(n - 2);
    });
    assertEquals(89, (long) fib.apply(11));
  }
}
