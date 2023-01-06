package xdu.example;

/**
 * 名称A2018下飞行
 * 描述
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2022-10-18 21:25
 */



public class A2018下飞行 {
}

abstract class CState{
    public int flyMiles;
    public abstract double travle(int miles,CFrequentFlyer context);
}

class CBasic extends CState{

    @Override
    public double travle(int miles,CFrequentFlyer context) {
        return 0;
    }
}

class CFrequentFlyer{

}