package org.example.proxy;

public class IRentHouse implements RentHouse{
    private IntermediaryProxy proxy = null;
    @Override
    public void rentHouse(){
        if(hasProxy()){
            System.out.println("调用真实角色的方法");
        }else{
            System.out.println("请使用代理调用");
        }
    }
    @Override
    public RentHouse getProxy() {
        if(!hasProxy()){
            this.proxy = new IntermediaryProxy(this);
        }
        return this;
    }
    private boolean hasProxy(){
        return proxy != null;
    }
}
