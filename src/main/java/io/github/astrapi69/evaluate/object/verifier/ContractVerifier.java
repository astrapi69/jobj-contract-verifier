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
package io.github.astrapi69.evaluate.object.verifier;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

import io.github.astrapi69.evaluate.object.annotation.Experimental;
import io.github.astrapi69.evaluate.object.api.ContractViolation;
import io.github.astrapi69.evaluate.object.checker.EqualsHashCodeAndToStringCheck;
import io.github.astrapi69.evaluate.object.enumeration.VerificationType;

/**
 * The class {@link ContractVerifier} can verify if the fulfillment of contracts from a given object
 * is given. This is useful in unit tests for verifying the contracts for the methods
 * {@code equals}, {@code hashCode} and optionally {@code toString}. This can also improve the code
 * coverage of a project because the most methods of beans are tested.
 */
@Experimental
public final class ContractVerifier<T>
{

	/**
	 * Factory method for create a new {@link ContractVerifier} object from the given class
	 *
	 * @param <T>
	 *            the generic type
	 * @param type
	 *            the class
	 * @param ignoreFieldNames
	 *            an optional array with the field names that shell be ignored
	 * @return the contract verifier
	 */
	public static <T> ContractVerifier<T> of(final Class<T> type, String... ignoreFieldNames)
	{
		Objects.requireNonNull(type);
		return new ContractVerifier<>(type, ignoreFieldNames);
	}

	/** The cls. */
	private final Class<T> cls;
	private final String[] ignoreFieldNames;

	/** The factory function. */
	private Function<Class<T>, T> factoryFunction;

	/** The verification type. */
	private VerificationType verificationType = VerificationType.EQUALS_HASHCODE_AND_TO_STRING;

	/**
	 * Private constructor
	 *
	 * @param cls
	 *            the class
	 * @param ignoreFieldNames
	 *            an optional array with the field names that shell be ignored
	 */
	private ContractVerifier(final Class<T> cls, String... ignoreFieldNames)
	{
		Objects.requireNonNull(cls);
		this.cls = cls;
		this.ignoreFieldNames = ignoreFieldNames;
	}

	/**
	 * Gets the verification type
	 *
	 * @return the {@link VerificationType} object
	 */
	public VerificationType getVerificationType()
	{
		return verificationType;
	}

	/**
	 * Verify the given class and returns an {@link Optional} that is empty if the verification was
	 * successful
	 *
	 * @return an empty {@link Optional} object if the verification was successful
	 */
	public Optional<ContractViolation> verify()
	{
		Optional<ContractViolation> verificationResult = Optional.empty();
		try
		{
			if (factoryFunction != null)
			{
				verificationResult = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(cls,
					factoryFunction);
			}
			else
			{
				verificationResult = EqualsHashCodeAndToStringCheck.equalsHashcodeAndToString(cls);
			}
		}
		catch (NoSuchMethodException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (IllegalAccessException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (InvocationTargetException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (InstantiationException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (ClassNotFoundException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (IOException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		catch (NoSuchFieldException e)
		{
			throw new AssertionError(e.getMessage(), e);
		}
		return verificationResult;
	}

	/**
	 * Builder method that sets the verification type
	 * {@link VerificationType#EQUALS_HASHCODE_AND_TO_STRING}
	 *
	 * @return this {@link ContractVerifier}
	 */
	public ContractVerifier<T> withEqualsHashcodeAndToString()
	{
		verificationType = VerificationType.EQUALS_HASHCODE_AND_TO_STRING;
		return this;
	}

	/**
	 * Builder method that sets the factory function
	 *
	 * @param factoryFunction
	 *            the factory function
	 * @return this {@link ContractVerifier}
	 */
	public ContractVerifier<T> withFactoryFunction(final Function<Class<T>, T> factoryFunction)
	{
		Objects.requireNonNull(factoryFunction);
		this.factoryFunction = factoryFunction;
		return this;
	}

}
