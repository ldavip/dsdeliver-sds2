package com.devsuperior.dsdeliver.util;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StreamUtils {
    public static <T, R> List<R> mapToList(Collection<T> list, Function<T, R> mapper) {
        return list.stream().map(mapper).collect(Collectors.toList());
    }
}
