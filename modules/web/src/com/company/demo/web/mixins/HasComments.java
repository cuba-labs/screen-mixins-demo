package com.company.demo.web.mixins;

import com.company.demo.entity.Comment;
import com.company.demo.web.comment.CommentsFragment;
import com.haulmont.cuba.core.global.BeanLocator;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.Fragments;
import com.haulmont.cuba.gui.UiComponents;
import com.haulmont.cuba.gui.components.VBoxLayout;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.Extensions;
import com.haulmont.cuba.gui.screen.Screen;
import com.haulmont.cuba.gui.screen.Subscribe;
import com.haulmont.cuba.gui.screen.UiControllerUtils;

import java.util.List;
import java.util.UUID;

// Mixin for screens having comments panel
public interface HasComments {

    // abstract method that must be implemented in screen
    UUID getConversationId();

    @Subscribe
    default void initCommentsPanel(Screen.InitEvent event) {
        Screen screen = event.getSource();

        // get screen scope APIs: dialogs, notifications, fragments
        Fragments fragments = UiControllerUtils.getScreenContext(screen).getFragments();

        // get application beans from bean locator provided by screen
        BeanLocator beanLocator = Extensions.getBeanLocator(screen);
        UiComponents uiComponents = beanLocator.get(UiComponents.NAME);

        // we can create any UI component programmatically
        VBoxLayout commentsBox = uiComponents.create(VBoxLayout.class);
        commentsBox.setHeight("200px");

        // or even create additional fragments
        CommentsFragment commentsFragment = fragments
                .create(screen, CommentsFragment.class);
        commentsFragment.init();
        commentsBox.add(commentsFragment.getFragment());
        commentsBox.expand(commentsFragment.getFragment());

        screen.getWindow().add(commentsBox);

        // register additional state for screen
        Extensions.register(screen, CommentsExtension.class, new CommentsExtension(commentsFragment));
    }

    @Subscribe
    default void loadComments(Screen.BeforeShowEvent event) {
        Screen screen = event.getSource();
        // get previously registered extension
        CommentsExtension commentsExtension = Extensions.get(screen, CommentsExtension.class);

        CommentsFragment commentsFragment = commentsExtension.getCommentsFragment();

        // Mixins can load data using DataManager (or register additional data containers and loaders)
        DataManager dataManager = Extensions.getBeanLocator(screen).get(DataManager.NAME);
        List<Comment> comments = dataManager.load(Comment.class)
                .view("comment-view")
                .query("select c from demo_Comment c where c.conversation = :conversation")
                .parameter("conversation", getConversationId())
                .list();

        CollectionContainer<Comment> commentsDc = commentsFragment.getCommentsDc();
        commentsDc.getMutableItems().addAll(comments);
    }

    // state class of the mixin
    class CommentsExtension {
        private final CommentsFragment commentsFragment;

        public CommentsExtension(CommentsFragment commentsContainer) {
            this.commentsFragment = commentsContainer;
        }

        public CommentsFragment getCommentsFragment() {
            return commentsFragment;
        }
    }
}