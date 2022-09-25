package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public Integer calcSum(String filepath) throws IOException {
		LineCallback<Integer> sumCallback =
				(line, value) -> value + Integer.valueOf(line);
		return lineReadTemplate(filepath, sumCallback, 0);
	}

	public Integer calcMultiply(String filepath) throws IOException {
		LineCallback<Integer> multiplyCallback =
				(line, value) -> value * Integer.valueOf(line);
		return lineReadTemplate(filepath, multiplyCallback, 1);
	}

	public String concatenate(String filepath) throws IOException {
		LineCallback<String> concatenateCallback =
				(line, value) -> value + line;
			return lineReadTemplate(filepath, concatenateCallback, "");
	}

	public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws IOException {
		try(BufferedReader br = new BufferedReader(new FileReader(filepath))) {
			T res = initVal;
			String line = null;
			while((line = br.readLine()) != null) {
				res = callback.doSomethingWithLine(line, res);
			}
			return res;
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			throw e;
		}
	}

}
