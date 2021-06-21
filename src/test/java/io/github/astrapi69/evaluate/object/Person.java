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
package io.github.astrapi69.evaluate.object;

/**
 * The class {@link Person} is a class intended for use in unit tests.
 */
public class Person
{

	public static class PersonBuilder
	{
		private String about;
		private Boolean married;
		private String name;
		private String nickname;

		PersonBuilder()
		{
		}

		public Person.PersonBuilder about(String about)
		{
			this.about = about;
			return this;
		}

		public Person build()
		{
			return new Person(about, married, name, nickname);
		}

		public Person.PersonBuilder married(Boolean married)
		{
			this.married = married;
			return this;
		}

		public Person.PersonBuilder name(String name)
		{
			this.name = name;
			return this;
		}

		public Person.PersonBuilder nickname(String nickname)
		{
			this.nickname = nickname;
			return this;
		}

		public String toString()
		{
			return "Person.PersonBuilder(about=" + this.about + ", married=" + this.married
				+ ", name=" + this.name + ", nickname=" + this.nickname + ")";
		}
	}

	public static PersonBuilder builder()
	{
		return new PersonBuilder();
	}

	/** The about. */
	private String about;

	/** The married flag. */
	private Boolean married;

	/** The name. */
	private String name;

	/** The nickname. */
	private String nickname;

	public Person()
	{
	}

	public Person(String about, Boolean married, String name, String nickname)
	{
		this.about = about;
		this.married = married;
		this.name = name;
		this.nickname = nickname;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof Person;
	}

	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof Person))
			return false;
		final Person other = (Person)o;
		if (!other.canEqual((Object)this))
			return false;
		final Object this$about = this.getAbout();
		final Object other$about = other.getAbout();
		if (this$about == null ? other$about != null : !this$about.equals(other$about))
			return false;
		final Object this$married = this.getMarried();
		final Object other$married = other.getMarried();
		if (this$married == null ? other$married != null : !this$married.equals(other$married))
			return false;
		final Object this$name = this.getName();
		final Object other$name = other.getName();
		if (this$name == null ? other$name != null : !this$name.equals(other$name))
			return false;
		final Object this$nickname = this.getNickname();
		final Object other$nickname = other.getNickname();
		if (this$nickname == null ? other$nickname != null : !this$nickname.equals(other$nickname))
			return false;
		return true;
	}

	public String getAbout()
	{
		return this.about;
	}

	public Boolean getMarried()
	{
		return this.married;
	}

	public String getName()
	{
		return this.name;
	}

	public String getNickname()
	{
		return this.nickname;
	}

	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $about = this.getAbout();
		result = result * PRIME + ($about == null ? 43 : $about.hashCode());
		final Object $married = this.getMarried();
		result = result * PRIME + ($married == null ? 43 : $married.hashCode());
		final Object $name = this.getName();
		result = result * PRIME + ($name == null ? 43 : $name.hashCode());
		final Object $nickname = this.getNickname();
		result = result * PRIME + ($nickname == null ? 43 : $nickname.hashCode());
		return result;
	}

	public void setAbout(String about)
	{
		this.about = about;
	}

	public void setMarried(Boolean married)
	{
		this.married = married;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String toString()
	{
		return "Person(about=" + this.getAbout() + ", married=" + this.getMarried() + ", name="
			+ this.getName() + ", nickname=" + this.getNickname() + ")";
	}
}
