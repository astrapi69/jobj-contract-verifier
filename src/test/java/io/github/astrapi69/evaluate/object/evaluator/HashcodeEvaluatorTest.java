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
package io.github.astrapi69.evaluate.object.evaluator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.evaluate.object.Person;
import io.github.astrapi69.random.number.RandomIntFactory;

/**
 * The unit test class for the class {@link HashcodeEvaluator}.
 */
public class HashcodeEvaluatorTest
{

	/**
	 * Test method for {@link HashcodeEvaluator#evaluateConsistency(Object)}.
	 */
	@Test
	public void testEvaluateConsistency()
	{
		boolean expected;
		boolean actual;
		actual = HashcodeEvaluator.evaluateConsistency(Integer.valueOf(0));
		expected = true;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateConsistency(Integer.valueOf(1));
		expected = true;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateConsistency(Integer.valueOf(10));
		expected = true;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateConsistency(null);
		expected = false;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateConsistency(new Person()
		{
			@Override
			public int hashCode()
			{
				return RandomIntFactory.randomInt();
			}
		});
		expected = false;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link HashcodeEvaluator#evaluateEquality(Object, Object)}.
	 */
	@Test
	public void testEvaluateEquality()
	{
		boolean expected;
		boolean actual;
		actual = HashcodeEvaluator.evaluateEquality(Integer.valueOf(0), Integer.valueOf(0));
		expected = true;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateEquality(null, Integer.valueOf(0));
		expected = false;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateEquality(Integer.valueOf(1), Integer.valueOf(1));
		expected = true;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateEquality(new Person()
		{
			@Override
			public int hashCode()
			{
				return RandomIntFactory.randomInt();
			}
		}, new Person()
		{
			@Override
			public int hashCode()
			{
				return RandomIntFactory.randomInt();
			}
		});
		expected = false;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link HashcodeEvaluator#evaluateUnequality(Object, Object)}.
	 */
	@Test
	public void testEvaluateUnequality()
	{
		boolean expected;
		boolean actual;
		actual = HashcodeEvaluator.evaluateUnequality(Integer.valueOf(0), Integer.valueOf(1));
		expected = true;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateUnequality(Integer.valueOf(1), Integer.valueOf(0));
		expected = true;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateUnequality(null, Integer.valueOf(0));
		expected = false;
		assertEquals(expected, actual);

		actual = HashcodeEvaluator.evaluateUnequality(Integer.valueOf(1), null);
		expected = true;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link HashcodeEvaluator} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(HashcodeEvaluator.class);
	}

}
