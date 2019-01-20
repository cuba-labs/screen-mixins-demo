package com.company.demo.web.product;

import com.company.demo.web.mixins.HasBanner;
import com.haulmont.cuba.gui.screen.*;
import com.company.demo.entity.Product;

@UiController("demo_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> implements HasBanner {
}