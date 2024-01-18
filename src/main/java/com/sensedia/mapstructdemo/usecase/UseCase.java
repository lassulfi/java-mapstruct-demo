package com.sensedia.mapstructdemo.usecase;

public interface UseCase<IN, OUT> {
    OUT execute(IN anIn);
}
