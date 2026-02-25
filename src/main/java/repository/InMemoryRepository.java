package repository;

/**
  Repositório genérico simples em memória. Usando Map para simular um banco.
 */
public class InMemoryRepository<T> {
    private final Map<String, T> storage = new LinkedHashMap<>();

    public void save(String id, T entity) {
        storage.put(id, entity);
    }

    public Optional<T> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    public void delete(String id) {
        storage.remove(id);
    }

    public boolean exists(String id) {
        return storage.containsKey(id);
    }
}