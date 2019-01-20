package com.company.demo.web.mixins;

import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.Label;
import com.haulmont.cuba.gui.screen.Extensions;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.web.theme.HaloTheme;

public interface HasBanner {
    @Subscribe
    default void initBanner(Screen.InitEvent event) {
        BeanLocator beanLocator = Extensions.getBeanLocator(event.getSource());
        UiComponents uiComponents = beanLocator.get(UiComponents.NAME);

        Label<String> banner = uiComponents.create(Label.NAME);
        banner.setStyleName(HaloTheme.LABEL_H2);
        banner.setValue("Hello, world!");

        event.getSource().getWindow().add(banner, 0);
    }
}