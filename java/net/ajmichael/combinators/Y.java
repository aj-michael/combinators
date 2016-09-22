package net.ajmichael.combinators;

import java.util.function.Function;

public final class Y<A, B> implements
    Function<Function<Function<A, B>, Function<A, B>>, Function<A, B>> {
  @Override
  public Function<A, B> apply(Function<Function<A, B>, Function<A, B>> x) {
    return ((Function<Function<Function, Function<A, B>>, Function<A, B>>)
        p -> x.apply(a -> p.apply(p).apply(a))
    ).apply(p -> x.apply(a -> ((Function<A, B>) p.apply(p)).apply(a)));
  }
}