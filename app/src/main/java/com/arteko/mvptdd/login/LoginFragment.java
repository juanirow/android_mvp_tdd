package com.arteko.mvptdd.login;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.arteko.mvptdd.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by juancho on 13/05/16.
 */
public class LoginFragment extends Fragment implements LoginContract.View {

    @InjectView(R.id.input_email)
    EditText mInputEmail;

    @InjectView(R.id.input_password)
    EditText mInputPassword;

    private LoginContract.Actions mActionsListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;

        view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        this.mActionsListener = new LoginPresenter(this, new LoginInteractor());
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Override
    public String getEmail() {
        return this.mInputEmail.getText().toString().trim();
    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLoginError() {

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void onErrorEmailNull() {
        this.mInputEmail.setError(getString(R.string.not_null));
    }

    @Override
    public String getPassowrd() {
        return this.mInputPassword.getText().toString().trim();
    }

    @Override
    public void onErrorPasswordNull() {
        this.mInputPassword.setError(getString(R.string.not_null));
    }

    @OnClick(R.id.btn_login)
    public void onClickLoginBtn(){
        this.mActionsListener.onClickLoginButton();
    }

}
