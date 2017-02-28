package com.test.act.app.presenter;

import com.test.act.app.view.IRegisterView;

import java.util.Map;

/**
 * Created by gao on 2017/2/28.
 */

public class IRegisterPresenterCompl implements IRegisterPresenter{
    private IRegisterView iRegisterView;

    public IRegisterPresenterCompl(IRegisterView iRegisterView){
        this.iRegisterView = iRegisterView;
    }

    @Override
    public void doRegister(Map<String, String> params) {
        //接口调用
        String code = "S";
        String msg  = "登陆成功";
        iRegisterView.onRegisterResult(code,msg);
    }
}
