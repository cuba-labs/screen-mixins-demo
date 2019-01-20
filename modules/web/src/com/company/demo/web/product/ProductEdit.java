package com.company.demo.web.product;

import com.company.demo.entity.Product;
import com.company.demo.web.mixins.HasComments;
import com.haulmont.cuba.gui.screen.*;

import java.util.UUID;

@UiController("demo_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> implements HasComments {
    @Override
    public UUID getConversationId() {
        // for simplicity we will use ID of product as conversation id
        return getEditedEntity().getId();
    }
}