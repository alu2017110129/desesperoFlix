package br.com.grupo5.desesperoFlix.databinding;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import org.parceler.Parcels;

import br.com.grupo5.desesperoFlix.R;
import br.com.grupo5.desesperoFlix.databinding.model.Filme;

public class FilmeActivity extends AppCompatActivity
    implements FilmeClickListener {

    ActivityFilmeBinding mBinding;
    FilmeListFragment mListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_filme);
        mBinding.setHandler(this);

        mListFragment = (FilmeListFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_list);
    }

    public void onSearchClick(View view){
        mListFragment.search(mBinding.editSearch.getText().toString());
    }

    @Override
    public void onFilmeClick(Filme filme) {
        if (getResources().getBoolean(R.bool.abc_allow_stacked_button_bar)) { //tablet
            FilmeDetailFragment dlf = FilmeDetailFragment.newInstance(filme);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.detalhe, dlf, "detalhe")
                    .commit();
        } else {
            Intent it = new Intent(this, FilmeDetailActivity.class);
            Parcelable p = Parcels.wrap(filme);
            it.putExtra(FilmeDetailActivity.EXTRA_FILME, p);
            startActivity(it);
        }
    }
}
