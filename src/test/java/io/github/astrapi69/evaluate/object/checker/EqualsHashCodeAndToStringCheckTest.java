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
package io.github.astrapi69.evaluate.object.checker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.evaluate.object.Person;
import io.github.astrapi69.evaluate.object.api.ContractViolation;
import io.github.astrapi69.evaluate.object.enumeration.EqualsContractViolation;
import io.github.astrapi69.evaluate.object.enumeration.EqualsHashcodeContractViolation;
import io.github.astrapi69.evaluate.object.enumeration.HashcodeContractViolation;
import io.github.astrapi69.random.number.RandomIntFactory;

/**
 * The unit test class for the class {@link EqualsHashCodeAndToStringCheck}
 */
public class EqualsHashCodeAndToStringCheckTest
{

	/** The boolean actual result of the tests. */
	protected Optional<ContractViolation> actual;

	/** The boolean expected result of the tests. */
	protected Optional<ContractViolation> expected;

	/**
	 * {@inheritDoc}
	 */
	@BeforeEach
	protected void setUp()
	{
	}

	/**
	 * {@inheritDoc}
	 */
	@AfterEach
	protected void tearDown()
	{
		actual = Optional.empty();
		expected = Optional.empty();
	}


	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringCheck#equalsAndHashcode(Object, Object, Object, Object)}.
	 */
	@Test
	public void testEqualsAndHashcode()
	{
		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcode(Integer.valueOf(0),
			Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcode(Integer.valueOf(0),
			Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.of(EqualsHashcodeContractViolation.FIRST_AND_SECOND_EQUAL);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcode(Integer.valueOf(0), null,
			Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.SYMMETRICITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcode(null, Integer.valueOf(0),
			Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.of(EqualsHashcodeContractViolation.FIRST_ARG_NULL);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcode(Integer.valueOf(0),
			Integer.valueOf(1), null, Integer.valueOf(0));
		expected = Optional.of(EqualsHashcodeContractViolation.FIRST_AND_THIRD_UNEQUAL);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcode(Integer.valueOf(0),
			Integer.valueOf(1), Integer.valueOf(0), null);
		expected = Optional.of(EqualsContractViolation.TRANSITIVITY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringCheck#equalsAndHashcodeEquality(Object, Object)}.
	 */
	@Test
	public void testEqualsAndHashcodeEquality()
	{
		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcodeEquality(Integer.valueOf(0),
			Integer.valueOf(1));
		expected = Optional.of(HashcodeContractViolation.EQAUALITY);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcodeEquality(Integer.valueOf(1),
			Integer.valueOf(0));
		expected = Optional.of(HashcodeContractViolation.EQAUALITY);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcodeEquality(null, Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.REFLEXIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcodeEquality(Integer.valueOf(0), null);
		expected = Optional.of(EqualsContractViolation.SYMMETRICITY_NULL_ARGUMENT);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringCheck#equalsAndHashcodeUnequality(Object, Object)}.
	 */
	@Test
	public void testEqualsAndHashcodeUnequality()
	{
		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcodeUnequality(Integer.valueOf(0),
			Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcodeUnequality(Integer.valueOf(1),
			Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcodeUnequality(null,
			Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.REFLEXIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsAndHashcodeUnequality(Integer.valueOf(0),
			null);
		expected = Optional.of(EqualsContractViolation.SYMMETRICITY_NULL_ARGUMENT);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringCheck#equalsHashcodeAndToString(Object, Object, Object, Object)}.
	 */
	@Test
	public void testEqualsHashcodeAndToString()
	{
		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(Integer.valueOf(0),
			Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(Integer.valueOf(0),
			Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.of(EqualsHashcodeContractViolation.FIRST_AND_SECOND_EQUAL);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(Integer.valueOf(0), null,
			Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.SYMMETRICITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(null, Integer.valueOf(0),
			Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.of(EqualsHashcodeContractViolation.FIRST_ARG_NULL);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(Integer.valueOf(0),
			Integer.valueOf(1), null, Integer.valueOf(0));
		expected = Optional.of(EqualsHashcodeContractViolation.FIRST_AND_THIRD_UNEQUAL);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(Integer.valueOf(0),
			Integer.valueOf(1), Integer.valueOf(0), null);
		expected = Optional.of(EqualsContractViolation.TRANSITIVITY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsHashCodeAndToStringCheck#equalsHashcodeAndToString(Object)}
	 */
	@Test
	public void testEqualsHashcodeAndToStringObject()
	{
		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(String.valueOf("foo"));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString((Object)null);
		expected = Optional.of(EqualsContractViolation.REFLEXIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(new Person()
		{
			@Override
			public int hashCode()
			{
				return RandomIntFactory.randomInt();
			}
		});
		expected = Optional.of(HashcodeContractViolation.CONSISTENCY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsHashCodeAndToStringCheck#hashcodeCheck(Object, Object, Object)}
	 */
	@Test
	public void testHashcodeCheck()
	{
		actual = EqualsHashCodeAndToStringCheck.hashcodeCheck(Integer.valueOf(0),
			Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.of(HashcodeContractViolation.UNEQAUALITY);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.hashcodeCheck(new Person()
		{
			@Override
			public int hashCode()
			{
				return RandomIntFactory.randomInt();
			}
		}, Person.builder().build(), new Person()
		{
			@Override
			public int hashCode()
			{
				return RandomIntFactory.randomInt();
			}
		});
		expected = Optional.of(HashcodeContractViolation.EQAUALITY);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for {@link EqualsHashCodeAndToStringCheck} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(EqualsHashCodeAndToStringCheck.class);
	}

}
