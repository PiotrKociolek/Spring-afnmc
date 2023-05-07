package com.afnmc.afnmc.utilities.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.passay.*;

import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class PasswordValidationConstraints implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        Properties props = new Properties();
        MessageResolver resolver = new PropertiesMessageResolver(props);
        PasswordValidator validator = new PasswordValidator(resolver, Arrays.asList(
                new LengthRule(8, 32),
                new WhitespaceRule(),
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 4, false),
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 4, false)
        ));

        RuleResult result = validator.validate(new PasswordData(value));
        if (result.isValid())
            return true;

        List<String> messages = validator.getMessages(result);
        String template = String.join(",", messages);
        context.buildConstraintViolationWithTemplate(template)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
