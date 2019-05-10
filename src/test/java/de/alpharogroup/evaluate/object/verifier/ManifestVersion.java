package de.alpharogroup.evaluate.object.verifier;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.jar.Attributes;
import java.util.jar.Manifest;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * Simple bean to hold information about the version of a Manifest. Can be used for JAR, EAR and WAR
 * manifest files.
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ManifestVersion implements Serializable
{

	/** The serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The last modified holds the {@code LocalDateTime} when the last build was. */
	LocalDateTime lastModified;

	/** The manifest. */
	Manifest manifest;

	/** The title. */
	String title;

	/** The version number. */
	String version;

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

}
