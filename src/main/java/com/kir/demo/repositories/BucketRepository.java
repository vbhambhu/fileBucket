package com.kir.demo.repositories;


import com.kir.demo.models.Bucket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BucketRepository extends PagingAndSortingRepository<Bucket, Long> {

    Page<Bucket> findAll(Pageable pageable);

}
