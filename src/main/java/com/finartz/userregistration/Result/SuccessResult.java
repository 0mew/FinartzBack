package com.finartz.userregistration.Result;

import com.sun.net.httpserver.Authenticator;

public class SuccessResult extends Result{

    public SuccessResult() {super(true);}

    public SuccessResult(String message){super(true,message); }
}
