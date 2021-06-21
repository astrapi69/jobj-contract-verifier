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

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

/**
 * Simple bean to hold information about the version of a Manifest. Can be used for JAR, EAR and WAR
 * manifest files.
 */
public class ManifestVersion implements Serializable
{

	public static class ManifestVersionBuilder
	{
		private LocalDateTime lastModified;
		private Manifest manifest;
		private String title;
		private String version;

		ManifestVersionBuilder()
		{
		}

		public ManifestVersion build()
		{
			return new ManifestVersion(lastModified, manifest, title, version);
		}

		public ManifestVersion.ManifestVersionBuilder lastModified(LocalDateTime lastModified)
		{
			this.lastModified = lastModified;
			return this;
		}

		public ManifestVersion.ManifestVersionBuilder manifest(Manifest manifest)
		{
			this.manifest = manifest;
			return this;
		}

		public ManifestVersion.ManifestVersionBuilder title(String title)
		{
			this.title = title;
			return this;
		}

		public String toString()
		{
			return "ManifestVersion.ManifestVersionBuilder(lastModified=" + this.lastModified
				+ ", manifest=" + this.manifest + ", title=" + this.title + ", version="
				+ this.version + ")";
		}

		public ManifestVersion.ManifestVersionBuilder version(String version)
		{
			this.version = version;
			return this;
		}
	}

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public static ManifestVersionBuilder builder()
	{
		return new ManifestVersionBuilder();
	}

	/** The last modified holds the {@code LocalDateTime} when the last build was. */
	private LocalDateTime lastModified;

	/** The manifest. */
	private Manifest manifest;

	/** The title. */
	private String title;

	/** The version number. */
	private String version;

	public ManifestVersion()
	{
	}

	public ManifestVersion(LocalDateTime lastModified, Manifest manifest, String title,
		String version)
	{
		this.lastModified = lastModified;
		this.manifest = manifest;
		this.title = title;
		this.version = version;
	}

	protected boolean canEqual(final Object other)
	{
		return other instanceof ManifestVersion;
	}

	public boolean equals(final Object o)
	{
		if (o == this)
			return true;
		if (!(o instanceof ManifestVersion))
			return false;
		final ManifestVersion other = (ManifestVersion)o;
		if (!other.canEqual((Object)this))
			return false;
		final Object this$lastModified = this.getLastModified();
		final Object other$lastModified = other.getLastModified();
		if (this$lastModified == null
			? other$lastModified != null
			: !this$lastModified.equals(other$lastModified))
			return false;
		final Object this$manifest = this.getManifest();
		final Object other$manifest = other.getManifest();
		if (this$manifest == null ? other$manifest != null : !this$manifest.equals(other$manifest))
			return false;
		final Object this$title = this.getTitle();
		final Object other$title = other.getTitle();
		if (this$title == null ? other$title != null : !this$title.equals(other$title))
			return false;
		final Object this$version = this.getVersion();
		final Object other$version = other.getVersion();
		if (this$version == null ? other$version != null : !this$version.equals(other$version))
			return false;
		return true;
	}

	public LocalDateTime getLastModified()
	{
		return this.lastModified;
	}

	public Manifest getManifest()
	{
		return this.manifest;
	}

	/**
	 * Gets the manifest attribute value from the given {@code Attributes.Name} object.
	 *
	 * @param name
	 *            the name
	 * @return the manifest attribute or an empty String if the manifest attribute value is null
	 */
	public String getManifestAttribute(final Attributes.Name name)
	{
		if (getManifest() != null)
		{
			final Attributes attributes = getManifest().getMainAttributes();
			final Object value = attributes.get(name);
			if (value != null)
			{
				return value.toString().trim();
			}
		}
		return "";
	}

	public String getTitle()
	{
		return this.title;
	}

	public String getVersion()
	{
		return this.version;
	}

	public int hashCode()
	{
		final int PRIME = 59;
		int result = 1;
		final Object $lastModified = this.getLastModified();
		result = result * PRIME + ($lastModified == null ? 43 : $lastModified.hashCode());
		final Object $manifest = this.getManifest();
		result = result * PRIME + ($manifest == null ? 43 : $manifest.hashCode());
		final Object $title = this.getTitle();
		result = result * PRIME + ($title == null ? 43 : $title.hashCode());
		final Object $version = this.getVersion();
		result = result * PRIME + ($version == null ? 43 : $version.hashCode());
		return result;
	}

	public void setLastModified(LocalDateTime lastModified)
	{
		this.lastModified = lastModified;
	}

	public void setManifest(Manifest manifest)
	{
		this.manifest = manifest;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setVersion(String version)
	{
		this.version = version;
	}

	public ManifestVersionBuilder toBuilder()
	{
		return new ManifestVersionBuilder().lastModified(this.lastModified).manifest(this.manifest)
			.title(this.title).version(this.version);
	}

	public String toString()
	{
		return "ManifestVersion(lastModified=" + this.getLastModified() + ", manifest="
			+ this.getManifest() + ", title=" + this.getTitle() + ", version=" + this.getVersion()
			+ ")";
	}
}
