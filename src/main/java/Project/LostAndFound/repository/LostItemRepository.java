// src/main/java/Project/LostAndFound/repository/LostItemRepository.java
package Project.LostAndFound.repository;

import Project.LostAndFound.model.LostItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LostItemRepository extends JpaRepository<LostItem, Long> {
    List<LostItem> findTop5ByOrderByCreatedAtDesc();
    List<LostItem> findByStatus(String status);
    long countByStatus(String status);
}