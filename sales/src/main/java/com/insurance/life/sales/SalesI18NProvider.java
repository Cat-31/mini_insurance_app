package com.insurance.life.sales;

import com.vaadin.flow.i18n.I18NProvider;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Component
public class SalesI18NProvider implements I18NProvider {
    @Override
    public List<Locale> getProvidedLocales() {
        return Arrays.asList(Locale.getDefault());
    }

    @Override
    public String getTranslation(String s, Locale locale, Object... objects) {
        return s;
    }
}
