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
package io.github.astrapi69.evaluate.object.checker;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

import io.github.astrapi69.evaluate.object.Person;
import io.github.astrapi69.evaluate.object.WeirdBadInconsistencyClass;
import io.github.astrapi69.evaluate.object.api.ContractViolation;
import io.github.astrapi69.evaluate.object.enumeration.EqualsContractViolation;
import io.github.astrapi69.random.number.RandomBooleanFactory;
import io.github.astrapi69.random.number.RandomIntFactory;

/**
 * The unit test class for the class {@link EqualsCheck}
 */
public class EqualsCheckTest
{

	/** The boolean actual result of the tests. */
	protected Optional<ContractViolation> actual;

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
	 * Test method for {@link EqualsCheck#consistency(Object, Object)}.
	 */
	@Test
	public void testConsistency()
	{
		actual = EqualsCheck.consistency(Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.consistency(Integer.valueOf(1), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.consistency(Integer.valueOf(1), Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.consistency(null, Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.CONSISTENCY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.consistency(Integer.valueOf(0), null);
		expected = Optional.of(EqualsContractViolation.CONSISTENCY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.consistency(new Person()
		{
			@Override
			public boolean equals(Object o)
			{
				return RandomBooleanFactory.randomBoolean();
			}

			@Override
			public int hashCode()
			{
				return RandomIntFactory.randomInt();
			}
		}, Person.builder().build());
		expected = Optional.of(EqualsContractViolation.CONSISTENCY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsCheck#consistency(Object, Object, int)}.
	 */
	@Test
	public void testConsistencyWithIterations()
	{
		actual = EqualsCheck.consistency(Integer.valueOf(0), Integer.valueOf(0), 10);
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.consistency(Integer.valueOf(1), Integer.valueOf(0), 20);
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.consistency(Integer.valueOf(1), Integer.valueOf(1), 100);
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.consistency(null, Integer.valueOf(0), 10);
		expected = Optional.of(EqualsContractViolation.CONSISTENCY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.consistency(Integer.valueOf(0), null, 10);
		expected = Optional.of(EqualsContractViolation.CONSISTENCY_NULL_ARGUMENT);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsCheck#nonNull(Object)}.
	 */
	@Test
	public void testNonNull()
	{
		actual = EqualsCheck.nonNull(Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.nonNull(Integer.valueOf(10));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.nonNull(Integer.valueOf(100));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.nonNull(null);
		expected = Optional.of(EqualsContractViolation.NON_NULL_NULL_ARGUMENT);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsCheck#reflexivity(Object)}.
	 */
	@Test
	public void testReflexivity()
	{
		actual = EqualsCheck.reflexivity(Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivity(Integer.valueOf(10));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivity(Integer.valueOf(100));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivity(null);
		expected = Optional.of(EqualsContractViolation.REFLEXIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);
		// new scenario ...
		// provocate a reflexivity contract violation ...
		// while loop for provocate a reflexivity contract violation.
		// Note: Because of randomness of hashCode and equals this is not always the case
		int maxIteration = 100;
		int count = 0;
		do
		{
			actual = EqualsCheck.reflexivity(new WeirdBadInconsistencyClass());

			if (actual.isPresent())
			{
				ContractViolation contractViolation = actual.get();
				if (contractViolation.equals(EqualsContractViolation.REFLEXIVITY))
				{
					break;
				}
			}
			count++;

		}
		while (true && count < maxIteration);

		expected = Optional.of(EqualsContractViolation.REFLEXIVITY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsCheck#reflexivityAndNonNull(Object)}.
	 */
	@Test
	public void testReflexivityAndNonNull()
	{
		actual = EqualsCheck.reflexivityAndNonNull(Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityAndNonNull(Integer.valueOf(10));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityAndNonNull(Integer.valueOf(100));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityAndNonNull(null);
		expected = Optional.of(EqualsContractViolation.REFLEXIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

	}

	/**
	 * Test method for
	 * {@link EqualsCheck#reflexivityNonNullSymmetricAndConsistency(Object, Object)}.
	 */
	@Test
	public void testReflexivityNonNullSymmetricAndConsistency()
	{
		actual = EqualsCheck.reflexivityNonNullSymmetricAndConsistency(Integer.valueOf(0),
			Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityNonNullSymmetricAndConsistency(Integer.valueOf(1),
			Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityNonNullSymmetricAndConsistency(Integer.valueOf(1),
			Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityNonNullSymmetricAndConsistency(null, Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.REFLEXIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityNonNullSymmetricAndConsistency(Integer.valueOf(0), null);
		expected = Optional.of(EqualsContractViolation.SYMMETRICITY_NULL_ARGUMENT);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for
	 * {@link EqualsCheck#reflexivityNonNullSymmetricConsistencyAndTransitivity(Object, Object, Object)}.
	 */
	@Test
	public void testReflexivityNonNullSymmetricConsistencyAndTransitivity()
	{
		actual = EqualsCheck.reflexivityNonNullSymmetricConsistencyAndTransitivity(
			Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityNonNullSymmetricConsistencyAndTransitivity(
			Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.TRANSITIVITY);
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityNonNullSymmetricConsistencyAndTransitivity(
			Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityNonNullSymmetricConsistencyAndTransitivity(null,
			Integer.valueOf(1), Integer.valueOf(1));
		expected = Optional.of(EqualsContractViolation.TRANSITIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityNonNullSymmetricConsistencyAndTransitivity(
			Integer.valueOf(1), null, Integer.valueOf(1));
		expected = Optional.of(EqualsContractViolation.REFLEXIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.reflexivityNonNullSymmetricConsistencyAndTransitivity(
			Integer.valueOf(1), Integer.valueOf(1), null);
		expected = Optional.of(EqualsContractViolation.TRANSITIVITY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsCheck#symmetric(Object, Object)}.
	 */
	@Test
	public void testSymmetric()
	{
		actual = EqualsCheck.symmetric(Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.symmetric(Integer.valueOf(1), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.symmetric(Integer.valueOf(1), Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.symmetric(null, Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.SYMMETRICITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.symmetric(Integer.valueOf(0), null);
		expected = Optional.of(EqualsContractViolation.SYMMETRICITY_NULL_ARGUMENT);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsCheck#symmetricAndConsistency(Object, Object)}.
	 */
	@Test
	public void testSymmetricAndConsistency()
	{
		actual = EqualsCheck.symmetricAndConsistency(Integer.valueOf(0), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.symmetricAndConsistency(Integer.valueOf(1), Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.symmetricAndConsistency(Integer.valueOf(1), Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.symmetricAndConsistency(null, Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.SYMMETRICITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.symmetricAndConsistency(Integer.valueOf(0), null);
		expected = Optional.of(EqualsContractViolation.SYMMETRICITY_NULL_ARGUMENT);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsCheck#transitivity(Object, Object, Object)}.
	 */
	@Test
	public void testTransitivity()
	{
		actual = EqualsCheck.transitivity(Integer.valueOf(0), Integer.valueOf(0),
			Integer.valueOf(0));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.transitivity(Integer.valueOf(0), Integer.valueOf(1),
			Integer.valueOf(0));
		expected = Optional.of(EqualsContractViolation.TRANSITIVITY);
		assertEquals(expected, actual);

		actual = EqualsCheck.transitivity(Integer.valueOf(1), Integer.valueOf(1),
			Integer.valueOf(1));
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsCheck.transitivity(null, Integer.valueOf(1), Integer.valueOf(1));
		expected = Optional.of(EqualsContractViolation.TRANSITIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.transitivity(Integer.valueOf(1), null, Integer.valueOf(1));
		expected = Optional.of(EqualsContractViolation.TRANSITIVITY_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsCheck.transitivity(Integer.valueOf(1), Integer.valueOf(1), null);
		expected = Optional.of(EqualsContractViolation.TRANSITIVITY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsCheck} with {@link BeanTester}
	 */
	@Test
	public void testWithBeanTester()
	{
		final BeanTester beanTester = new BeanTester();
		beanTester.testBean(EqualsCheck.class);
	}

}
