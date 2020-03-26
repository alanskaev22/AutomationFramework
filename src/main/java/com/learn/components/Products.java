package com.learn.components;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.concurrent.atomic.AtomicReference;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
public class Products extends AtomicReference<Products> {

    private transient Profile profile;

}
