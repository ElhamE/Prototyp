/*
 * TierkreiszeichenActivity.java
 * 
 * (c) Thomas Künneth 2010 - 2015
 * Alle Rechte beim Autor.
 */
package com.thomaskuenneth.auswahlelement;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.thomaskuenneth.auswahlelement.Werke.FragmentDemo3Activity;

/**
 * Dies ist die Listenansicht der App. Sie zeigt alle Sternzeichen nach
 * Kalendermonaten sortiert an.
 * 
 * @author Thomas Künneth
 */
public class AuswahlelementActivity extends ListActivity implements
		OnItemClickListener {

	private AuswahlelementAdapter adapter;

    @Override
    protected void onStart()
    {
        super.onStart();
//        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// hier werden die Auswahlelement gespeichert
		adapter = new AuswahlelementAdapter(this);
		setListAdapter(adapter);
		// auf das Antippen von Listenelementen 
		// reagieren
		getListView().setOnItemClickListener(this);
    }

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id)
	{
		Auswahlelement zeichen = (Auswahlelement) adapter.getItem(position);
        Intent i;
		switch (zeichen.getAuswahlelement())
		{
			case R.string.auswahl1: i = new Intent();
                i.setClass(getApplicationContext(), FragmentDemo3Activity.class);
                startActivity(i);
				break;
			case R.string.auswahl2:
				break;
			case R.string.auswahl3:
				break;
			case R.string.auswahl4: i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=restaurants"));
				i.setPackage("com.google.android.apps.maps");
				startActivity(i);
				break;
			case R.string.auswahl5:
				break;
			default:
		}
//		String url = getString(R.string.wikipedia_url, zeichen.getName(this));
//		// eine Webseite anzeigen
//		Intent viewIntent = new Intent("android.intent.action.VIEW",
//				Uri.parse(url));
//		startActivity(viewIntent);
	}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.menu_anmelden: return true;
            case R.id.menu_ueber_uns: return true;
            case R.id.menu_rechtliches: return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}