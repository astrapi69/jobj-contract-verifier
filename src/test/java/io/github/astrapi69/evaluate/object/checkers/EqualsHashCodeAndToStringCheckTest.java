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
package io.github.astrapi69.evaluate.object.checkers;

import static org.testng.AssertJUnit.assertEquals;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

import org.meanbean.test.BeanTester;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.astrapi69.evaluate.object.BaseEnhancedRandomExtensions;
import io.github.astrapi69.evaluate.object.Person;
import io.github.astrapi69.evaluate.object.api.ContractViolation;
import io.github.astrapi69.evaluate.object.enums.EqualsContractViolation;
import io.github.astrapi69.evaluate.object.enums.EqualsHashcodeContractViolation;
import io.github.astrapi69.evaluate.object.enums.HashcodeContractViolation;
import io.github.astrapi69.evaluate.object.enums.ToStringContractViolation;

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
	@BeforeMethod
	protected void setUp() throws Exception
	{
	}

	/**
	 * {@inheritDoc}
	 */
	@AfterMethod
	protected void tearDown() throws Exception
	{
		actual = null;
		expected = null;
	}


	/**
	 * Test method for
	 * {@link EqualsHashCodeAndToStringCheck#equalsAndHashcode(Object, Object, Object, Object)}.
	 */
	@Test(enabled = true)
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
	@Test(enabled = true)
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
	@Test(enabled = true)
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
	@Test(enabled = true)
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
	 * Test method for {@link EqualsHashCodeAndToStringCheck#equalsHashcodeAndToString(Class)}.
	 *
	 * @throws IllegalAccessException
	 *             if the caller does not have access to the property accessor method
	 * @throws InstantiationException
	 *             if a new instance of the bean's class cannot be instantiated
	 * @throws InvocationTargetException
	 *             if the property accessor method throws an exception
	 * @throws NoSuchMethodException
	 *             if an accessor method for this property cannot be found
	 * @throws IOException
	 *             Signals that an I/O exception has occurred
	 * @throws ClassNotFoundException
	 *             occurs if a given class cannot be located by the specified class loader
	 * @throws NoSuchFieldException
	 *             is thrown if no such field exists
	 */
	@Test(enabled = true)
	public void testEqualsHashcodeAndToStringClass()
		throws NoSuchMethodException, IllegalAccessException, InvocationTargetException,
		InstantiationException, IOException, ClassNotFoundException, NoSuchFieldException
	{
		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(null);
		expected = Optional.of(ToStringContractViolation.CLASS_NULL_ARGUMENT);
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(Person.class);
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(Integer.class);
		expected = Optional.empty();
		assertEquals(expected, actual);

		actual = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(String.class);
		expected = Optional.empty();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsHashCodeAndToStringCheck#equalsHashcodeAndToString(Object)}
	 */
	@Test(enabled = true)
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
				return BaseEnhancedRandomExtensions.nextObject(Integer.class);
			}
		});
		expected = Optional.of(HashcodeContractViolation.CONSISTENCY);
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link EqualsHashCodeAndToStringCheck#hashcodeCheck(Object, Object, Object)}
	 */
	@Test(enabled = true)
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
				return BaseEnhancedRandomExtensions.nextObject(Integer.class);
			}
		}, Person.builder().build(), new Person()
		{
			@Override
			public int hashCode()
			{
				return BaseEnhancedRandomExtensions.nextObject(Integer.class);
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
