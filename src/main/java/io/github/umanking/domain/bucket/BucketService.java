package io.github.umanking.domain.bucket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Geonguk Han
 * @since 2020-06-20
 */
@Service
@Slf4j
public class BucketService {

    private final BucketRepository bucketRepository;

    public BucketService(final BucketRepository bucketRepository) {
        this.bucketRepository = bucketRepository;
    }

    //todo: 장바구니 목록
    public List<Bucket> findBuckets() {
        return bucketRepository.findAll();
    }

    // todo: 장바구니에 상품 추가
}
