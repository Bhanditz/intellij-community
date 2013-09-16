package com.intellij.openapi.components.impl.stores;

import com.intellij.openapi.components.RoamingType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.io.InputStream;

public abstract class StreamProvider {
  public static final StreamProvider[] EMPTY_ARRAY = new StreamProvider[0];

  public abstract boolean isEnabled();

  public abstract void saveContent(@NotNull String fileSpec, @NotNull InputStream content, long size, @NotNull RoamingType roamingType, boolean async) throws IOException;

  @Nullable
  public abstract InputStream loadContent(@NotNull String fileSpec, @NotNull RoamingType roamingType) throws IOException;

  @NotNull
  public abstract String[] listSubFiles(@NotNull String fileSpec, @NotNull RoamingType roamingType);

  public abstract void deleteFile(@NotNull String fileSpec, @NotNull RoamingType roamingType);
}