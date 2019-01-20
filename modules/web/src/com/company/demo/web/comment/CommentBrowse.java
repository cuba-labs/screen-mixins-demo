package com.company.demo.web.comment;

import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Comment;

@UiController("demo_Comment.browse")
@UiDescriptor("comment-browse.xml")
@LookupComponent("commentsTable")
@LoadDataBeforeShow
public class CommentBrowse extends StandardLookup<Comment> {
}