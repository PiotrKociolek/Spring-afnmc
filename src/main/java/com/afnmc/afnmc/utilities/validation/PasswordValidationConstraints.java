package com.afnmc.afnmc.utilities.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import org.passay.*;

public class PasswordValidationConstraints implements ConstraintValidator<ValidPassword, String> {
    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        final Properties props = new Properties();
        final MessageResolver resolver = new PropertiesMessageResolver(props);
        final PasswordValidator validator = new PasswordValidator(resolver, Arrays.asList(
                new LengthRule(8, 32),
                new WhitespaceRule(),
                new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 4, false),
                new IllegalSequenceRule(EnglishSequenceData.Numerical, 4, false)
        ));

        final RuleResult result = validator.validate(new PasswordData(value));
        if (result.isValid())
            return true;

        final List<String> messages = validator.getMessages(result);
        final String template = String.join(",", messages);
        context.buildConstraintViolationWithTemplate(template)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
