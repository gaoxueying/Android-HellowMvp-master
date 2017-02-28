package com.test.act.app.view;

import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.test.act.app.mvp_master.R;
import com.test.act.app.presenter.IRegisterPresenter;
import com.test.act.app.presenter.IRegisterPresenterCompl;

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity implements IRegisterView,View.OnClickListener {
    private EditText etUserName;
    private EditText etPwd;
    private Button btnRegister;

    private IRegisterPresenterCompl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        etUserName = (EditText) findViewById(R.id.et_uname);
        etPwd = (EditText) findViewById(R.id.et_pwd);
        btnRegister = (Button) findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(this);
        presenter = new IRegisterPresenterCompl(this);

    }

    @Override
    public void onRegisterResult(String code, String msg) {
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_register:
                Map<String,String> params = new HashMap<String,String>();
                params.put("userName", TextUtils.isEmpty(etUserName.getText()) == true?"":etUserName.getText().toString());
                params.put("passWord", TextUtils.isEmpty(etPwd.getText()) == true?"":etPwd.getText().toString());
                presenter.doRegister(params);
                break;
            default:break;
        }
    }
}
