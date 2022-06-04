package com.mrgrd56.springoauth2.utils;

public final class ObjectUtils {
    private ObjectUtils() { }

    public static <T> T tryCast(Object object, Class<T> targetClass) {
        try {
            if (targetClass.isAssignableFrom(object.getClass())) {
                return (T) object;
            }

            return null;
        } catch (NullPointerException | ClassCastException e) {
            return null;
        }
    }
}
