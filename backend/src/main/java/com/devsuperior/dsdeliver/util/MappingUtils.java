package com.devsuperior.dsdeliver.util;

import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.List;

import static com.devsuperior.dsdeliver.util.StreamUtils.mapToList;

public class MappingUtils {
    private static ModelMapper mapper;

    public static ModelMapper getMapper() {
        if (mapper == null) {
            mapper = new ModelMapper();
        }
        return mapper;
    }

    public static <T, R> R map(T source, R target) {
        getMapper().map(source, target);
        return target;
    }

    public static <T, R> R map(T source, Class<R> target) {
        return getMapper().map(source, target);
    }

    public static <T, R> List<R> mapList(Collection<T> list, Class<R> target) {
        return mapToList(list, o -> map(o, target));
    }
}
