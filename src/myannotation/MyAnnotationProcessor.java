package myannotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("myannotation.MyAnnotation")
public class MyAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> typeElements, RoundEnvironment roundEnv) {

        for (TypeElement typeElement : typeElements) {
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(typeElement);

            for (Element element : elements) {
                MyAnnotation myAnnotation = element.getAnnotation(MyAnnotation.class);
                System.out.println("@MyAnnotation at " + element);
                System.out.println("value : " + myAnnotation.value());
            }
        }

        return true;
    }
}
