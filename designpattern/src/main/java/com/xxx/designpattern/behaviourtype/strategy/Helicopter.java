package com.xxx.designpattern.behaviourtype.strategy;

public class Helicopter implements IAir {
    @Override
    public IStartFlyFeature startFlyFeature() {
        return new VericalTakeOff();
    }

    @Override
    public IFlyFeature flyFeature() {
        return new SuperSonicFly();
    }
}
