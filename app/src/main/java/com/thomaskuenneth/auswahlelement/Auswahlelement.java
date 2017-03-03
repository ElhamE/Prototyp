/*
 * Tierkreiszeichen.java
 * 
 * (c) Thomas Künneth 2010 - 2015
 * Alle Rechte beim Autor.
 */
package com.thomaskuenneth.auswahlelement;

import android.content.Context;

/**
 * Diese Klasse speichert Informationen über ein Auswahlelement:
 * <ul>
 * <li>erster Tag des Datumsbereichs, den es abdeckt</li>
 * <li>Monat, in dem dieser Bereich beginnt</li>
 * <li>eine Zahl, die das Sternzeichnen kennzeichnet</li>
 * </ul>
 * <p>
 * Die Methode {@link #getIdForDrawable()} liefert einen Wert, der für das
 * Zeichnen des Tierkreiszeichens verwendet werden kann. Damit das funktioniert,
 * muss das Sternzeichen aus {@code R.string} belegt werden,
 * 
 * @author Thomas Künneth
 * 
 */
public final class Auswahlelement
{

	private final int auswahlelement;

	public Auswahlelement(int auswahlelement) {
		this.auswahlelement = auswahlelement;
	}

	// Java-typische Getter und Setter

	public int getAuswahlelement() {
		return auswahlelement;
	}

	public String getName(Context context) {
		return context.getString(getAuswahlelement());
	}

	/**
	 * Liefert einen Wert aus {@code R.drawable}, der für das Zeichnen des
	 * Sternzeichens verwendet werden kann.
	 * 
	 * @return Wert aus {@code R.drawable}
	 */
	public int getIdForDrawable()
	{
		switch (getAuswahlelement())
		{
		case R.string.auswahl1:
			return R.drawable.aquarius;
		case R.string.auswahl2:
			return R.drawable.aries;
		case R.string.auswahl3:
			return R.drawable.cancer;
		case R.string.auswahl4:
			return R.drawable.gemini;
		case R.string.auswahl5:
			return R.drawable.leo;
			default: return R.drawable.icon;
		}
	}
}
