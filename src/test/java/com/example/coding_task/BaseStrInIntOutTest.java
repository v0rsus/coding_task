package com.example.coding_task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;

public abstract class BaseStrInIntOutTest
{
	@ParameterizedTest
	@MethodSource("input")
	void test(Map<String, Integer> input)
	{
		input.forEach((k, v) -> Assertions.assertEquals(v, testImpl(k)));
	}

	protected abstract int testImpl(String s);
}
