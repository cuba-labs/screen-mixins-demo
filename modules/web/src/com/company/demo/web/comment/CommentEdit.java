package com.company.demo.web.comment;

import com.company.demo.entity.Comment;
import com.haulmont.cuba.core.global.UserSessionSource;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("demo_Comment.edit")
@UiDescriptor("comment-edit.xml")
@EditedEntityContainer("commentDc")
@LoadDataBeforeShow
public class CommentEdit extends StandardEditor<Comment> {
    @Inject
    private UserSessionSource userSessionSource;

    @Subscribe
    protected void onInitEntity(InitEntityEvent<Comment> event) {
        event.getEntity().setUser(userSessionSource.getUserSession().getUser());
    }
}