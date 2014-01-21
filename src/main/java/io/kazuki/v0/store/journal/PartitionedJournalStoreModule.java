package io.kazuki.v0.store.journal;

import io.kazuki.v0.store.keyvalue.KeyValueStoreJdbiH2Module;

import com.google.inject.Key;
import com.google.inject.Scopes;
import com.google.inject.name.Names;


public class PartitionedJournalStoreModule extends KeyValueStoreJdbiH2Module {
  public PartitionedJournalStoreModule(String name, String propertiesPath) {
    super(name, propertiesPath);
  }

  protected void includeInternal() {
    bind(JournalStore.class).annotatedWith(Names.named(name)).to(PartitionedJournalStore.class)
        .in(Scopes.SINGLETON);
  }

  @Override
  protected void includeExposures() {
    expose(Key.get(JournalStore.class, Names.named(name)));
  }
}
