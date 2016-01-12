package com.taniaticona.servicios.clinicadental;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


/**
 * An activity representing a list of Items. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a {@link ItemDetailActivity} representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 * <p/>
 * The activity makes heavy use of fragments. The list of items is a
 * {@link ItemListFragment} and the item details
 * (if present) is a {@link ItemDetailFragment}.
 * <p/>
 * This activity also implements the required
 * {@link ItemListFragment.Callbacks} interface
 * to listen for item selections.
 */
public class ItemListActivity extends AppCompatActivity
        implements ItemListFragment.Callbacks {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private boolean mTwoPane;
    private  String texto1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_app_bar);

        TextView tv2 = (TextView)findViewById(R.id.textView2);
        tv2.setSelected(true);
        //agergue
        //String texto1="DESCUBRE TU SONRISA CON NOSOTROS " ;
        //String texto2="SONRISA PERFECTA NOSOTROS TE AYUDAMOS A DESCUBRIRLA " ;
       // String texto3="LA MEJOR SONRISA UNA MEJOR CALIDAD DE VIDA" ;

        Random rand = new Random();
        int n = rand.nextInt(10);


        switch (n){
            case 0:
                texto1="La sonrisa de su vida comienza a dibujarse ahora" ;
                break ;

            case 1 :
                texto1="¡Hazle caso a tu dentista! " ;
                break ;
            case 2:
                texto1="¡Dé a su boca el cuidado que se merece!"; break ;
            case 3:
                texto1="¡No olvides usar hilo dental!" ;
                break ;
            case 4:
                texto1=" Pide tu cita con tu dentista cada seis meses " ;
                break ;
            case 5:
                texto1=" Come un dieta sana :) " ;
                break ;
            case 6:
                texto1=" ¡Lávate mínimo dos veces al día! " ;
                break ;
            case 7:
                texto1=" Cepillar los dientes y encías de púes de cada comida " ;
                break ;
            case 8:
                texto1=" No abuse de alimentos ni bebidas azucaradas " ;
                break ;
            case 9:
                texto1="No olvides el tratamiento de tu boca" ;
                break ;
            case 10:
                texto1=" No olvides nunca tu kit de limpieza bucal" ;
                break ;

        }


        TextView tv = (TextView)findViewById(R.id.textView);
        //tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tv.setText("Consejo par tu día :) "+ texto1);
        //


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle(getTitle());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Citas al correo: CONSULTAS@TUSONRISA.COM", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        if (findViewById(R.id.item_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-large and
            // res/values-sw600dp). If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true;

            // In two-pane mode, list items should be given the
            // 'activated' state when touched.
            ((ItemListFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.item_list))
                    .setActivateOnItemClick(true);
        }

        // TODO: If exposing deep links into your app, handle intents here.
    }

    /**
     * Callback method from {@link ItemListFragment.Callbacks}
     * indicating that the item with the given ID was selected.
     */
    @Override
    public void onItemSelected(String id) {
        if (mTwoPane) {
            // In two-pane mode, show the detail view in this activity by
            // adding or replacing the detail fragment using a
            // fragment transaction.
            Bundle arguments = new Bundle();
            arguments.putString(ItemDetailFragment.ARG_ITEM_ID, id);
            ItemDetailFragment fragment = new ItemDetailFragment();
            fragment.setArguments(arguments);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.item_detail_container, fragment)
                    .commit();

        } else {
            // In single-pane mode, simply start the detail activity
            // for the selected item ID.
            Intent detailIntent = new Intent(this, ItemDetailActivity.class);
            detailIntent.putExtra(ItemDetailFragment.ARG_ITEM_ID, id);
            startActivity(detailIntent);
        }
    }



}
