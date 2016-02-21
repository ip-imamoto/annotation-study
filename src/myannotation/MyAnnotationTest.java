package myannotation;

public class MyAnnotationTest {

    @MyAnnotation
    public String hoge;

    @MyAnnotation(value = "コンストラクタ！！！")
    public MyAnnotationTest(String hoge) {
        this.hoge = hoge;
    }

    @MyAnnotation("メソッド！！")
    public String getHoge() {
        return hoge;
    }
}
