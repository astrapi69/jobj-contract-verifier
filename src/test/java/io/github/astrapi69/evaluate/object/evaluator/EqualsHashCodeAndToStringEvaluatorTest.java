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

/**
 * The unit test class for the class {@link EqualsHashCodeAndToStringEvaluator}.
 */
public class EqualsHashCodeAndToStringEvaluatorTest
{

	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringEvaluator#evaluateEqualsAndHashcode(Object, Object, Object, Object)}.
	 */
	@Test
	public void testEvaluateEqualsAndHashcode()
	{
		boolean expected;
		boolean actual;
		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcode(0, 1, 0, 0);
		expected = true;
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcode(0, 0, 0, 0);
		expected = false;
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcode(0, null, 0, 0);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcode(null, 0, 0, 0);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcode(0, 0, null, 0);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcode(0, 0, 0, null);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringEvaluator#evaluateEqualsAndHashcodeEquality(Object, Object)}.
	 */
	@Test
	public void testEvaluateEqualsAndHashcodeEquality()
	{
		boolean expected;
		boolean actual;
		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcodeEquality(0, 0);
		expected = true;
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcodeEquality(1, 1);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcodeEquality(null, 0);
		expected = false;
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcodeEquality(0, null);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringEvaluator#evaluateEqualsAndHashcodeUnequality(Object, Object)}.
	 */
	@Test
	public void testEvaluateEqualsAndHashcodeUnequality()
	{
		boolean expected;
		boolean actual;
		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcodeUnequality(0, 1);
		expected = true;
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcodeUnequality(1, 0);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcodeUnequality(null, 0);
		expected = false;
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsAndHashcodeUnequality(0, null);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringEvaluator#evaluateEqualsHashcodeAndToString(Object, Object, Object, Object)}.
	 */
	@Test
	public void testEvaluateEqualsHashcodeAndToString()
	{
		boolean expected;
		boolean actual;
		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(0, 1, 0, 0);
		expected = true;
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(0, 0, 0, 0);
		expected = false;
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(0, null, 0,
			0);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(null, 0, 0,
			0);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(0, 1, null,
			0);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(0, 1, 0,
			null);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringEvaluator#evaluateEqualsHashcodeAndToString(Object)}
	 */
	@Test
	public void testEvaluateEqualsHashcodeAndToStringSingleObject()
	{
		boolean expected;
		boolean actual;
		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(0);
		expected = true;
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString("foo");
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringEvaluator.evaluateEqualsHashcodeAndToString(null);
		expected = false;
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsHashCodeAndToStringEvaluator} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(EqualsHashCodeAndToStringEvaluator.class);
	}

}
