/*
 * TierkreiszeichenAdapter.java
 * 
 * (c) Thomas Künneth 2010 - 2015
 * Alle Rechte beim Autor.
 */
package com.thomaskuenneth.auswahlelement;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Diese Klasse bildet das Modell für die Listenansicht der App.
 * 
 * @author Thomas Künneth
 * @see BaseAdapter
 */
public class AuswahlelementAdapter extends BaseAdapter {

	private final List<Auswahlelement> zodiak;
	private final LayoutInflater inflator;

	public AuswahlelementAdapter(Context context)
	{
		// wird für das Aufblasen der XML-Datei benötigt
		inflator = LayoutInflater.from(context);
		// Auswahlelement für alle Monate ermitteln
		zodiak = new ArrayList<Auswahlelement>();
		zodiak.add(new Auswahlelement(R.string.auswahl1));
		zodiak.add(new Auswahlelement(R.string.auswahl2));
		zodiak.add(new Auswahlelement(R.string.auswahl3));
		zodiak.add(new Auswahlelement(R.string.auswahl4));
		zodiak.add(new Auswahlelement(R.string.auswahl5));
	}

	@Override
	public int getCount() {
		return zodiak.size();
	}

	@Override
	public Object getItem(int position) {
		return zodiak.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		ViewHolder holder;

		// falls nötig, convertView bauen
		if (convertView == null) {
			// Layoutdatei entfalten
			convertView = inflator.inflate(R.layout.icon_text_text, parent,
					false);

			// Holder erzeugen
			holder = new ViewHolder();
			holder.name = (TextView) convertView.findViewById(R.id.text1);
			holder.icon = (ImageView) convertView.findViewById(R.id.icon);

			convertView.setTag(holder);
		} else {
			// Holder bereits vorhanden
			holder = (ViewHolder) convertView.getTag();
		}

		Context context = parent.getContext();
		Auswahlelement auswahl = (Auswahlelement) getItem(position);
		holder.name.setText(auswahl.getName(context));
		holder.icon.setImageResource(auswahl.getIdForDrawable());
		if (++position >= getCount())
		{
			position = 0;
		}
        auswahl = (Auswahlelement) getItem(position);


		return convertView;
	}

	static class ViewHolder
	{
		TextView name;
		ImageView icon;
	}
}
