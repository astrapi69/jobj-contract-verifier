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
package de.alpharogroup.evaluate.object;

public class WeirdBadInconsistencyClass
{
	String name;

	public WeirdBadInconsistencyClass(String name)
	{
		this.name = name;
	}

	public WeirdBadInconsistencyClass()
	{
	}

	public static WeirdBadInconsistencyClassBuilder builder()
	{
		return new WeirdBadInconsistencyClassBuilder();
	}

	@Override
	public boolean equals(Object o)
	{
		boolean randomBoolean = BaseEnhancedRandomExtensions.nextObject(boolean.class);
		return randomBoolean;
	}

	@Override
	public int hashCode()
	{
		return BaseEnhancedRandomExtensions.nextObject(Integer.class);
	}

	@Override
	public String toString()
	{
		return BaseEnhancedRandomExtensions.nextObject(String.class);
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public static class WeirdBadInconsistencyClassBuilder
	{
		private String name;

		WeirdBadInconsistencyClassBuilder()
		{
		}

		public WeirdBadInconsistencyClass.WeirdBadInconsistencyClassBuilder name(String name)
		{
			this.name = name;
			return this;
		}

		public WeirdBadInconsistencyClass build()
		{
			return new WeirdBadInconsistencyClass(name);
		}

		public String toString()
		{
			return "WeirdBadInconsistencyClass.WeirdBadInconsistencyClassBuilder(name=" + this.name
				+ ")";
		}
	}
}