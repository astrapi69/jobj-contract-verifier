/**
 * The MIT License
 *
 * Copyright (C) 2015 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
/**
 *
 */
package io.github.astrapi69.evaluate.object.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.Serializable;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.evaluate.object.Person;
import io.github.astrapi69.random.object.RandomStringFactory;

/**
 * The unit test class for the class {@link ToStringEvaluator}.
 */
public class ToStringEvaluatorTest
{

	/**
	 * Test method for {@link ToStringEvaluator#evaluate(Class)}.
	 */
	@Test
	public void testEvaluate()
	{
		boolean expected;
		boolean actual;
		actual = ToStringEvaluator.evaluate(Integer.class);
		expected = true;
		assertEquals(expected, actual);

		actual = ToStringEvaluator.evaluate(String.class);
		expected = true;
		assertEquals(expected, actual);

		actual = ToStringEvaluator.evaluate(null);
		expected = false;
		assertEquals(expected, actual);

		actual = ToStringEvaluator.evaluate(Serializable.class);
		expected = false;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ToStringEvaluator#evaluateConsistency(Object)}.
	 */
	@Test
	public void testEvaluateConsistency()
	{
		boolean expected;
		boolean actual;

		actual = ToStringEvaluator.evaluateConsistency(Integer.valueOf(1));
		expected = true;
		assertEquals(expected, actual);

		actual = ToStringEvaluator.evaluateConsistency(new Person()
		{
			@Override
			public String toString()
			{
				return RandomStringFactory.newRandomString();
			}
		});
		expected = false;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ToStringEvaluator#evaluateConsistency(Object, int)}.
	 */
	@Test
	public void testEvaluateConsistencyWithIterations()
	{
		boolean expected;
		boolean actual;

		actual = ToStringEvaluator.evaluateConsistency(Integer.valueOf(1), 10);
		expected = true;
		assertEquals(expected, actual);

		actual = ToStringEvaluator.evaluateConsistency(null, 10);
		expected = false;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link ToStringEvaluator} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(ToStringEvaluator.class);
	}

}
