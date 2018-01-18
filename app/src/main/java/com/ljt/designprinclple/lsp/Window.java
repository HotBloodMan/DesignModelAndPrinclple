package com.ljt.designprinclple.lsp;

/**
 * Created by ${JT.L} on 2018/1/18.
 * LSP:Liskov Substitution Principle 里氏替换原则，所有引用基类的地方必须透明地使用其子类的对象 依赖于继承，多态
 *
 */

public class Window {
    //Window 与 View 属于依赖关系
    public void show(View child){
        child.draw();
    }
}
