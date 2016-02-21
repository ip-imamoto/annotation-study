## コンパイル時にアノテーションのProcessorクラスを指定する

1. srcディレクトリへ移動
1. `javac myannotation/MyAnnotation.java`
1. `javac myannotation/MyAnnotationProcessor.java`
1. `javac -processor myannotation.MyAnnotationProcessor myannotation/MyAnnotationTest.java`
