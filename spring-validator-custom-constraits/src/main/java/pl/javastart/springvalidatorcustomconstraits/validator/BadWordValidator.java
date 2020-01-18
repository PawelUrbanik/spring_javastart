package pl.javastart.springvalidatorcustomconstraits.validator;

import pl.javastart.springvalidatorcustomconstraits.common.Lang;
import pl.javastart.springvalidatorcustomconstraits.constraint.NotBadWord;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BadWordValidator implements ConstraintValidator<NotBadWord, String> {

    private Lang[] languages;

    @Override
    public void initialize(NotBadWord constraintAnnotation) {
        this.languages = constraintAnnotation.lang();

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean valid = true;
        for (Lang lang: languages)
        {
            if (lang == Lang.PL)
                valid &= plFilter(s);
            if (lang == Lang.EN)
                valid &= enFilter(s);
        }
        return valid;
    }

    private boolean plFilter(String s) {
        List<String> badWords = Arrays.asList("kurwa", "cholera");
        return generalFilter(s, badWords);
    }
    private boolean enFilter(String text)
    {
        List<String> badWords = Arrays.asList("fak");
        return generalFilter(text, badWords);
    }

    private boolean generalFilter(String s, List<String> badWords) {
        List<String> found = badWords
                            .stream()
                            .filter(word -> s.toLowerCase().contains(word))
                            .collect(Collectors.toList());
        return found.isEmpty();
    }
}
