package com.snehadatta.drizzle.util;

public abstract class Resource<T> {
    private final T data;
    private final String message;

    protected Resource(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public static final class Success<T> extends Resource<T> {
        public Success(T data, String message) {
            super(data, message != null ? message : "Task completed successfully.");
        }

        public Success(T data) {
            this(data, "Task completed successfully.");
        }
    }

    public static final class Error<T> extends Resource<T> {
        public Error(String message) {
            super(null, message != null ? message : "An unknown error occurred.");
        }

        public Error() {
            this("An unknown error occurred.");
        }
    }

    public static final class Loading<T> extends Resource<T> {
        public Loading() {
            super(null, null);
        }
    }
}

