package com.company.demo.web.comment;

import com.company.demo.entity.Comment;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.ScreenFragment;
import com.haulmont.cuba.gui.screen.UiController;
import com.haulmont.cuba.gui.screen.UiDescriptor;

import javax.inject.Inject;

@UiController("demo_CommentsFragment")
@UiDescriptor("comments-fragment.xml")
public class CommentsFragment extends ScreenFragment {
    @Inject
    private CollectionContainer<Comment> commentsDc;

    public CollectionContainer<Comment> getCommentsDc() {
        return commentsDc;
    }
}