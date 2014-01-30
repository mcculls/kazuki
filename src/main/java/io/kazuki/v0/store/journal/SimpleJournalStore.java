package io.kazuki.v0.store.journal;

import io.kazuki.v0.store.KazukiException;
import io.kazuki.v0.store.keyvalue.KeyValueStore;
import io.kazuki.v0.store.keyvalue.KeyValueStoreConfiguration;
import io.kazuki.v0.store.schema.TypeValidation;

import java.util.Iterator;

import javax.inject.Inject;

import com.google.common.base.Preconditions;


public class SimpleJournalStore implements JournalStore {
  private final KeyValueStore store;
  private final String dataType;

  @Inject
  public SimpleJournalStore(KeyValueStore store, KeyValueStoreConfiguration config) {
    Preconditions.checkNotNull(config.getDataType(), "dataType");

    this.store = store;
    this.dataType = config.getDataType();
  }

  @Override
  public void initialize() throws KazukiException {}

  @Override
  public <T> void append(String type, Class<T> clazz, T inValue, TypeValidation typeSafety)
      throws KazukiException {
    store.create(type, clazz, inValue, typeSafety);
  }

  @Override
  public <T> Iterator<T> getIteratorAbsolute(String type, Class<T> clazz, Long offset, Long limit)
      throws KazukiException {
    return store.iterator(type, clazz, offset, limit);
  }

  @Override
  public <T> Iterator<T> getIteratorRelative(String type, Class<T> clazz, Long offset, Long limit)
      throws KazukiException {
    return getIteratorAbsolute(type, clazz, offset, limit);
  }

  @Override
  public Long approximateSize() throws KazukiException {
    return store.approximateSize(this.dataType);
  }

  @Override
  public void clear() throws KazukiException {
    store.clear(false, false);
  }

  @Override
  public boolean closeActivePartition() {
    throw new UnsupportedOperationException("closeActivePartition() not supported");
  }

  @Override
  public boolean dropPartition(String partitionId) {
    throw new UnsupportedOperationException("dropPartition() not yet supported");
  }

  @Override
  public PartitionInfo getActivePartition() {
    throw new UnsupportedOperationException("getActivePartition() not yet supported");
  }

  @Override
  public Iterator<PartitionInfoSnapshot> getAllPartitions() {
    throw new UnsupportedOperationException("getAllPartitions() not yet supported");
  }
}
