package todo;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic.Kind;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("todo.ToDo")
public class ToDoProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> typeElements, RoundEnvironment roundEnv) {

        Messager messager = super.processingEnv.getMessager();

        for (TypeElement typeElement : typeElements) {
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(typeElement);

            for (Element element : elements) {
                ToDo todo = element.getAnnotation(ToDo.class);
                messager.printMessage(Kind.WARNING, "@ToDo at " + element + " : " + todo.message());

                LocalDate expirationDate = LocalDate.parse(todo.expiration(), DateTimeFormatter.ofPattern("yyyyMMdd"));

                if (LocalDate.now().isAfter(expirationDate)) {
                    messager.printMessage(Kind.ERROR, "ToDoの対応期限が切れています。対応期限" + expirationDate, element);
                }
            }
        }

        return true;
    }
}
