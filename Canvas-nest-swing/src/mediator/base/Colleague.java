package mediator.base;

/**
 * @program: Lear-Java
 * @description: 向仲裁�?�报告的组员的接�?
 * @author: Mr.Dai
 * @create: 2018-10-27 21:05
 **/
public interface Colleague {

    /**
     * ColleagueButton、ColleaqueTextField、ColleagueCheckbox 拿到Mediator实例的办�?
     * @param mediator
     */
    void setMediator(Mediator mediator);

    /**
     * 控制组员的状态的方法�?
     * 注意：如果组员有更多的状态，�?要定义更多的方法
     * @param enabled
     */
    void setColleagueEnabled(boolean enabled);
}
