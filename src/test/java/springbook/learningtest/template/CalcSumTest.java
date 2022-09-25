package springbook.learningtest.template;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcSumTest {
	Calculator calculator;
	String numFilepath;

	@BeforeEach
	public void setUp() {
		this.calculator = new Calculator();
		this.numFilepath = getClass().getResource("numbers.txt").getPath();
	}

	@Test
	public void sumOfNumbers() throws IOException {
		assertThat(calculator.calcSum(this.numFilepath)).isEqualTo(10);
	}

	@Test public void multiplyOfNumbers() throws IOException {
		assertThat(calculator.calcMultiply(this.numFilepath)).isEqualTo(24);
	}

	@Test public void concatenateStrings() throws IOException {
		assertThat(calculator.concatenate(this.numFilepath)).isEqualTo("1234");
	}

}

