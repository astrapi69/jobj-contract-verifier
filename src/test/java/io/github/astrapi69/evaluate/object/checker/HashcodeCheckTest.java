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
import io.github.astrapi69.evaluate.object.enumeration.HashcodeContractViolation;
import io.github.astrapi69.random.number.RandomIntFactory;

/**
 * The unit test class for the class {@link HashcodeCheck}
 */
public class HashcodeCheckTest
{

	/** The boolean actual result of the tests. */
	protected Optional<ContractViolation> actual = HashcodeCheck.consistency(new Person()
	{

		@Override
		public int hashCode()
		{
			return RandomIntFactory.randomInt();
		}
	});

	/** The boolean expected result of the tests. */
	protected Optional<ContractViolation> expected;

	/**
	 * {@inheritDoc}
	 */
	@BeforeEach
	protected void setUp() throws Exception
	{
	}

	/**
	 * {@inheritDoc}
	 */
	@AfterEach
	protected void tearDown() throws Exception
	{
		actual = null;
		expected = null;
	}

	/**
	 * Test method for {@link HashcodeCheck#consistency(Object)}
	 */
	@Test
	public void testConsistency()
	{
		actual = HashcodeCheck.consistency(Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = HashcodeCheck.consistency(Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = HashcodeCheck.consistency(Integer.valueOf(10));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = HashcodeCheck.consistency(null);
		expected = Optional.of(HashcodeContractViolation.CONSISTENCY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = HashcodeCheck.consistency(new Person()
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
	 * Test method for {@link HashcodeCheck#equality(Object, Object)}
	 */
	@Test
	public void testEquality()
	{
		actual = HashcodeCheck.equality(Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = HashcodeCheck.equality(null, Integer.valueOf(0));
		expected = Optional.of(HashcodeContractViolation.EQAUALITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = HashcodeCheck.equality(Integer.valueOf(1), Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = HashcodeCheck.equality(new Person()
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
		expected = Optional.of(HashcodeContractViolation.EQAUALITY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link HashcodeCheck#unequality(Object, Object)}
	 */
	@Test
	public void testUnequality()
	{
		actual = HashcodeCheck.unequality(Integer.valueOf(0), Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = HashcodeCheck.unequality(Integer.valueOf(1), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = HashcodeCheck.unequality(null, Integer.valueOf(0));
		expected = Optional.of(HashcodeContractViolation.UNEQAUALITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = HashcodeCheck.unequality(Integer.valueOf(1), null);
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = HashcodeCheck.unequality(new Person()
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
		expected = Optional.of(HashcodeContractViolation.UNEQAUALITY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link HashcodeCheck} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(HashcodeCheck.class);
	}

}
