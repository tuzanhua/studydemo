package com.tzh.designpattern.structure.facdepattern;

/**
 * create by tuzanhua on 2020/4/17
 */
public class RequestSystem {

    private RequestSystem(Builder builder) {
        this.request = builder.request;
    }

    private String request;

    public String getRequest() {
        return request;
    }


    public ResponseSystem request() {
        Call call = new RealCall();
       return call.execute(this);
    }

    public static class Builder {
        private String request;

        public Builder addUrl(String request) {
            this.request = request;
            return this;
        }

        public RequestSystem build() {
            return new RequestSystem(this);
        }
    }
}
