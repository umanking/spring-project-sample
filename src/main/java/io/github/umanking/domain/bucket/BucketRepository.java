package io.github.umanking.domain.bucket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Repository
public interface BucketRepository extends JpaRepository<Bucket, Long> {
}
