package mediator.base;

/**
 * @program: Lear-Java
 * @description: 仲裁�?
 * @author: Mr.Dai
 * @create: 2018-10-27 21:01
 **/
public interface Mediator {

    /**
     * 生成�?要管理的组员
     */
     void createColleagues();

    /**
     * 组员向仲裁�?�进行报�?
     */
    void colleagueChanged();


}
