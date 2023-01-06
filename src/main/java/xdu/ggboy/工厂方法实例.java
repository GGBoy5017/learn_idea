package xdu.ggboy;

/**
 * 名称工厂方法实例
 * 描述
 *
 * @version 1.0
 * @author:GGBoy
 * @datatime:2022-11-01 20:59
 */

interface ExportFileApi {

    /**
     * 导出内容为文件
     * @param data 示意：需要导出的内容
     * @return 是否导出成功
     */
    public boolean export(String data);

}

class ExportTxtFile implements ExportFileApi {

    @Override
    public boolean export(String data) {
        //简单示意一下
        System.out.println("导出数据"+data+"到文本文件");
        return true;
    }
}

class ExportDB implements ExportFileApi {

    @Override
    public boolean export(String data) {
        //简单示意一下
        System.out.println("导出数据"+data+"到数据库备份文件");
        return true;
    }
}

abstract class ExportOperate {

    /**
     * 导出文件
     * @param data
     * @return
     */
    public boolean export(String data){
        //使用工厂方法
        ExportFileApi api = factoryMethod();
        return api.export(data);
    }

    /**
     * 工厂方法，创建导出的文件对象的接口对象
     * @return
     */
    protected abstract ExportFileApi factoryMethod();
}

class ExportTxtFileOperate extends ExportOperate {

    @Override
    protected ExportFileApi factoryMethod() {
        // 创建导出成文本文件格式的对象
        return new ExportTxtFile();
    }

}

class ExportDBOperate extends ExportOperate {

    @Override
    protected ExportFileApi factoryMethod() {
        // 创建导出成数据库备份形式的对象
        return new ExportDB();
    }

}

public class 工厂方法实例 {
    public static void main(String[] args) {
        //创建需要使用的Creator对象
        ExportOperate operate = new ExportTxtFileOperate();
        //调用导出数据的功能方法
        operate.export("test 11data");
    }
}
