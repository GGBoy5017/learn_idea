package org.ggboy;

public class test {
    public static void main(String[] args) {
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportTxtFileOperate();
        //调用导出数据的功能方法
        operate.export("test data");
    }
}
