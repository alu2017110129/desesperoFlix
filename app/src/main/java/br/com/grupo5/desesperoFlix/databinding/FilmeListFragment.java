package br.com.grupo5.desesperoFlix.databinding;


import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import br.com.grupo5.desesperoFlix.R;
import br.com.grupo5.desesperoFlix.databinding.http.FilmeTask;
import br.com.grupo5.desesperoFlix.databinding.model.Filme;


public class FilmeListFragment extends Fragment {

    List<Filme> mFilmes;
    FilmeAdapter mAdapter;
    FilmeTask mTask;
    FragmentListFilmeBinding mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        mFilmes = new ArrayList<>();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_list_filme, container, false);

        mAdapter = new FilmeAdapter(mFilmes, mListener);
        mBinding.listFilme.setAdapter(mAdapter);
        return mBinding.getRoot();
    }

    FilmeClickListener mListener = new FilmeClickListener() {
        @Override
        public void onFilmeClick(Filme filme) {
            if (getActivity() instanceof FilmeClickListener){
                FilmeClickListener listener = (FilmeClickListener)getActivity();
                listener.onFilmeClick(filme);
            }
        }
    };

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mTask != null && mTask.getStatus() == AsyncTask.Status.RUNNING) {
            mTask.setFragment(this);
        }
    }

    public void setFilmes(List<Filme> filmes){
        if (filmes != null) {
            mFilmes.clear();
            mFilmes.addAll(filmes);
        }
        mAdapter.notifyDataSetChanged();
    }

    public void search(String term){
        mTask = new FilmeTask(this);
        mTask.execute(term);
    }

    public void showError() {
 //       Toast.makeText(getActivity(), R.string.msg_error_search_filmes, Toast.LENGTH_SHORT).show();
    }
}
